# mlp_regression_from_scratch.py
# - 21개 입력(X), 타겟 1개(SCR)
# - 히든 레이어/노드 수를 자유롭게 설정
# - 역전파(MSE) 학습, 에포크-로스 그래프, 모델 피클 저장

import os
import pickle
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from typing import List, Tuple, Dict

# =========================
# 하이퍼파라미터(여기만 바꿔 쓰세요)
# =========================
DATA_PATH = r"D:\workspace\project\Project_Libra\2nd_Project_LLM_Service\services\data_service\datafiles\csvfiles\필터링데이터.csv"

INPUT_COLS = [
    "YR","APS_APS","BGT_MCT","BGT_UBGT","BPS_BPS","BR_BCNT_SUM","CPSS_CPS","EHS_EHS",
    "FACLT_EQP_TPC","FACLT_LAS","FACLT_RS_TRS","LBRT_USTL","LPK_LPK","LPS_LPS",
    "LS_LB_SUM","LS_LU_SUM","SPK_SPK","STL_MCT","STL_USTL","VPS_VPS","VUC_UC_LUC"
]
TARGET_COL = "SCR"

HIDDEN_SIZES = [32, 16]      # 예: [64, 32, 16] 처럼 층/노드 수 자유롭게
ACTIVATION = "tanh"          # 'tanh' | 'relu' | 'sigmoid'
EPOCHS = 3000
LR = 0.01
BATCH_SIZE = 0               # 0 이면 full-batch GD, >0 이면 미니배치
VAL_SPLIT = 0.2              # 검증 비율
SEED = 42

MODEL_PKL = r"D:\workspace\archive\ml\deeplearning\test.pkl"   # 저장될 피클 파일명

# =========================
# 유틸 (스케일러)
# =========================
def standardize_fit(X: np.ndarray) -> Tuple[np.ndarray, np.ndarray, np.ndarray]:
    mu = X.mean(axis=0, keepdims=True)
    sigma = X.std(axis=0, keepdims=True)
    sigma[sigma == 0] = 1.0
    return (X - mu) / sigma, mu, sigma

def standardize_apply(X: np.ndarray, mu: np.ndarray, sigma: np.ndarray) -> np.ndarray:
    sigma = np.where(sigma == 0, 1.0, sigma)
    return (X - mu) / sigma

def invert_standardize(Y_std: np.ndarray, mu: np.ndarray, sigma: np.ndarray) -> np.ndarray:
    return Y_std * sigma + mu

# =========================
# 활성함수/도함수
# =========================
def act_forward(z: np.ndarray, name: str) -> np.ndarray:
    if name == "tanh":
        return np.tanh(z)
    if name == "relu":
        return np.maximum(0, z)
    if name == "sigmoid":
        return 1.0 / (1.0 + np.exp(-z))
    raise ValueError(f"Unknown activation: {name}")

def act_backward(a: np.ndarray, z: np.ndarray, name: str) -> np.ndarray:
    # a: activation(z) 값, z: pre-activation
    if name == "tanh":
        return 1.0 - a**2
    if name == "relu":
        return (z > 0).astype(a.dtype)
    if name == "sigmoid":
        return a * (1.0 - a)
    raise ValueError(f"Unknown activation: {name}")

# =========================
# 모델 클래스 (가변 레이어)
# =========================
class MLPRegressor:
    def __init__(self, input_dim: int, hidden_sizes: List[int], output_dim: int = 1,
                 activation: str = "tanh", seed: int = 42):
        rng = np.random.default_rng(seed)

        self.activation = activation
        layer_dims = [input_dim] + hidden_sizes + [output_dim]
        self.L = len(layer_dims) - 1

        self.W: List[np.ndarray] = []
        self.b: List[np.ndarray] = []

        # Xavier/Glorot 초기화 (tanh/sigmoid), He는 ReLU에서 선호되지만 여기선 Xavier로 통일
        for l in range(self.L):
            fan_in, fan_out = layer_dims[l], layer_dims[l+1]
            limit = np.sqrt(6.0 / (fan_in + fan_out))
            Wl = rng.uniform(-limit, limit, size=(fan_in, fan_out)).astype(np.float64)
            bl = np.zeros((1, fan_out), dtype=np.float64)
            self.W.append(Wl)
            self.b.append(bl)

    def forward(self, X: np.ndarray) -> Dict[str, List[np.ndarray]]:
        """
        반환: cache dict
          - Zs: 각 층 pre-activation 리스트
          - As: 각 층 activation 리스트 (A0 = X 포함)
        """
        A = X
        Zs, As = [], [A]
        for l in range(self.L):
            Z = A @ self.W[l] + self.b[l]           # (N, d_l+1)
            if l < self.L - 1:
                A = act_forward(Z, self.activation) # hidden
            else:
                A = Z                               # output: linear
            Zs.append(Z)
            As.append(A)
        return {"Zs": Zs, "As": As}

    def predict(self, X: np.ndarray) -> np.ndarray:
        return self.forward(X)["As"][-1]

    def backward(self, cache: Dict[str, List[np.ndarray]], y_true: np.ndarray) -> Tuple[List[np.ndarray], List[np.ndarray]]:
        """
        MSE: L = mean((y - y_hat)^2)
        dL/dA_L = 2*(A_L - y)/N
        """
        Zs, As = cache["Zs"], cache["As"]
        N = y_true.shape[0]

        dW = [None] * self.L
        db = [None] * self.L

        A_L = As[-1]  # (N, 1)
        dA = (2.0 * (A_L - y_true)) / N  # (N, 1)

        for l in reversed(range(self.L)):
            A_prev = As[l]          # (N, d_l)
            Z = Zs[l]               # (N, d_l+1)
            if l == self.L - 1:
                # 출력층: 선형 -> dZ = dA
                dZ = dA
            else:
                # 히든층: dZ = dA * g'(Z)
                A_cur = As[l+1]     # activation(Z)
                dZ = dA * act_backward(A_cur, Z, self.activation)

            dW[l] = A_prev.T @ dZ                   # (d_l, d_l+1)
            db[l] = np.sum(dZ, axis=0, keepdims=True)  # (1, d_l+1)

            if l > 0:
                dA = dZ @ self.W[l].T              # backprop to previous A

        return dW, db

    def step(self, dW: List[np.ndarray], db: List[np.ndarray], lr: float):
        for l in range(self.L):
            self.W[l] -= lr * dW[l]
            self.b[l] -= lr * db[l]

# =========================
# 학습/평가
# =========================
def mse(y, yhat): return float(np.mean((y - yhat) ** 2))
def mae(y, yhat): return float(np.mean(np.abs(y - yhat)))
def r2_score(y, yhat):
    ss_res = np.sum((y - yhat) ** 2)
    ss_tot = np.sum((y - np.mean(y)) ** 2)
    return float(1.0 - ss_res / ss_tot) if ss_tot > 0 else 0.0

def iterate_minibatches(X, y, batch_size, rng):
    N = X.shape[0]
    idx = np.arange(N)
    rng.shuffle(idx)
    for start in range(0, N, batch_size):
        end = min(start + batch_size, N)
        batch_idx = idx[start:end]
        yield X[batch_idx], y[batch_idx]

def main():
    np.random.seed(SEED)

    # 1) 데이터 로드
    encodings = ["utf-8-sig", "cp949", "utf-8"]
    for enc in encodings:
        try:
            df = pd.read_csv(DATA_PATH, encoding=enc)
            break
        except Exception:
            df = None
    if df is None:
        raise RuntimeError(f"CSV를 읽지 못했습니다. 인코딩을 확인하세요. tried={encodings}")

    # 2) 컬럼 선택 & 숫자형 변환
    cols_needed = INPUT_COLS + [TARGET_COL]
    missing = [c for c in cols_needed if c not in df.columns]
    if missing:
        raise ValueError(f"다음 컬럼을 찾을 수 없습니다: {missing}")

    df = df[cols_needed].copy()
    df = df.replace([np.inf, -np.inf], np.nan)
    df = df.dropna(axis=0)

    for c in cols_needed:
        df[c] = pd.to_numeric(df[c], errors="coerce")
    df = df.dropna(axis=0)

    X = df[INPUT_COLS].values.astype(np.float64)
    y = df[[TARGET_COL]].values.astype(np.float64)  # shape (N, 1)

    # 3) train/val split
    N = X.shape[0]
    idx = np.arange(N)
    rng = np.random.default_rng(SEED)
    rng.shuffle(idx)
    split = int(N * (1.0 - VAL_SPLIT))
    tr_idx, va_idx = idx[:split], idx[split:]

    X_tr, X_va = X[tr_idx], X[va_idx]
    y_tr, y_va = y[tr_idx], y[va_idx]

    # 4) 표준화 (입력/타겟 둘 다; 모델 저장 시 역변환 파라미터 보존)
    X_tr_std, x_mu, x_std = standardize_fit(X_tr)
    X_va_std = standardize_apply(X_va, x_mu, x_std)

    y_tr_std, y_mu, y_std = standardize_fit(y_tr)
    y_va_std = standardize_apply(y_va, y_mu, y_std)

    # 5) 모델 준비
    model = MLPRegressor(
        input_dim=X_tr_std.shape[1],
        hidden_sizes=HIDDEN_SIZES,
        output_dim=1,
        activation=ACTIVATION,
        seed=SEED
    )

    # 6) 학습
    train_loss_hist, val_loss_hist = [], []
    for epoch in range(1, EPOCHS + 1):
        if BATCH_SIZE and BATCH_SIZE > 0:
            # 미니배치
            for Xb, yb in iterate_minibatches(X_tr_std, y_tr_std, BATCH_SIZE, rng):
                cache = model.forward(Xb)
                dW, db = model.backward(cache, yb)
                model.step(dW, db, LR)
            # 에폭 마지막에 전체 기준으로 로스 기록
            yhat_tr = model.predict(X_tr_std)
            yhat_va = model.predict(X_va_std)
        else:
            # 풀배치
            cache = model.forward(X_tr_std)
            dW, db = model.backward(cache, y_tr_std)
            model.step(dW, db, LR)
            yhat_tr = cache["As"][-1]
            yhat_va = model.predict(X_va_std)

        tr_loss = mse(y_tr_std, yhat_tr)
        va_loss = mse(y_va_std, yhat_va)
        train_loss_hist.append(tr_loss)
        val_loss_hist.append(va_loss)

        if epoch % max(1, (EPOCHS // 10)) == 0 or epoch == 1:
            print(f"[{epoch:5d}] train_MSE={tr_loss:.6f}  val_MSE={va_loss:.6f}")

    # 7) 검증 성능(역표준화해서 실제 단위로)
    yhat_tr = invert_standardize(model.predict(X_tr_std), y_mu, y_std)
    yhat_va = invert_standardize(model.predict(X_va_std), y_mu, y_std)

    tr_mse = mse(y_tr, yhat_tr)
    tr_mae = mae(y_tr, yhat_tr)
    tr_r2  = r2_score(y_tr, yhat_tr)

    va_mse = mse(y_va, yhat_va)
    va_mae = mae(y_va, yhat_va)
    va_r2  = r2_score(y_va, yhat_va)

    print("\n=== Train Metrics (original scale) ===")
    print(f"MSE: {tr_mse:.4f}  MAE: {tr_mae:.4f}  R2: {tr_r2:.4f}")
    print("=== Valid Metrics (original scale) ===")
    print(f"MSE: {va_mse:.4f}  MAE: {va_mae:.4f}  R2: {va_r2:.4f}")

    # 8) Loss 그래프
    plt.figure()
    plt.plot(range(1, EPOCHS + 1), train_loss_hist, label="train MSE")
    plt.plot(range(1, EPOCHS + 1), val_loss_hist, label="val MSE")
    plt.xlabel("Epoch")
    plt.ylabel("MSE (standardized)")
    plt.title("Training Curve")
    plt.legend()
    plt.tight_layout()
    plt.show()

    # 9) 모델 저장 (가중치/바이어스/스케일러/메타 포함)
    to_save = {
        "W": model.W,
        "b": model.b,
        "activation": model.activation,
        "input_cols": INPUT_COLS,
        "target_col": TARGET_COL,
        "x_mu": x_mu, "x_std": x_std,
        "y_mu": y_mu, "y_std": y_std,
        "hidden_sizes": HIDDEN_SIZES,
    }
    with open(MODEL_PKL, "wb") as f:
        pickle.dump(to_save, f)
    print(f"\n[저장 완료] {os.path.abspath(MODEL_PKL)}")

    # (선택) 예측 예시 몇 개 출력
    for i in range(min(5, X_va.shape[0])):
        true = float(y_va[i])
        pred = float(yhat_va[i])
        print(f"VAL sample {i}: true={true:.3f}  pred={pred:.3f}")

if __name__ == "__main__":
    main()

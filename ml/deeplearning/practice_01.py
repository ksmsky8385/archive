# xor.py
# 구조: Input(2) -> Hidden(2 + bias 1) -> Output(1)
# 학습: 시그모이드, Binary Cross-Entropy, 배치 경사하강법
# 추가: 에포크별 로스/정확도 로깅, 최종 Loss 곡선 그리기(matplotlib)

import numpy as np
import matplotlib.pyplot as plt

# ----- 데이터 (리스트 형식) -----
# 앞자리=입력, 뒷자리=타겟 (연속값)
raw_samples = [
    [0.00, 0.00],
    [0.10, 0.36],
    [0.20, 0.64],
    [0.30, 0.84],
    [0.40, 0.96],
    [0.50, 1.00],
    [0.60, 0.96],
    [0.70, 0.84],
    [0.80, 0.64],
    [0.90, 0.36],
    [1.00, 0.00],
]

# numpy 배열로 변환
X = np.array([[s[0]] for s in raw_samples], dtype=float)       # shape: (N, 1)
y = np.array([s[1] for s in raw_samples], dtype=float).reshape(-1, 1)  # shape: (N, 1)


# ----- 하이퍼파라미터 -----
np.random.seed(42)
lr = 0.7
epochs = 50000
log_interval = 500

# ----- 네트워크 구조 -----
in_dim = 1
hidden_dim = 4
out_dim = 1

# 가중치 초기화
# W1: (입력 2 + bias 1) -> 은닉 2  => shape (3, 2)
# W2: (은닉 2 + bias 1) -> 출력 1  => shape (3, 1)
W1 = np.random.randn(in_dim + 1, hidden_dim) * 0.5
W2 = np.random.randn(hidden_dim + 1, out_dim) * 0.5

# ----- 유틸 함수 -----
def sigmoid(z):
    return 1.0 / (1.0 + np.exp(-z))

def bce_loss(y_true, y_pred, eps=1e-8):
    y_pred = np.clip(y_pred, eps, 1 - eps)
    return -np.mean(y_true * np.log(y_pred) + (1 - y_true) * np.log(1 - y_pred))

def accuracy(y_true, y_prob, thresh=0.5):
    y_pred = (y_prob >= thresh).astype(float)
    return np.mean((y_pred == y_true).astype(float))

def mse(y_true, y_pred):
    return np.mean((y_true - y_pred) ** 2)

# ----- 로깅용 -----
loss_history = []
acc_history = []

# ----- 학습 루프 -----
for epoch in range(1, epochs + 1):
    # 순전파
    x_bias = np.hstack([X, np.ones((X.shape[0], 1))])           # (N, 2)
    z1 = x_bias @ W1                                            # (N, 4)
    h = sigmoid(z1)                                             # (N, 4)
    h_bias = np.hstack([h, np.ones((h.shape[0], 1))])           # (N, 5)
    z2 = h_bias @ W2                                            # (N, 1)
    y_hat = sigmoid(z2)                                         # (N, 1)

    # ----- 손실/지표 계산 + 기록 (여기가 빠져 있었음) -----
    loss = bce_loss(y, y_hat)           # 또는: loss = mse(y, y_hat)
    loss_history.append(loss)
    # acc는 회귀에 부적합하므로 주석 처리(원하면 mse를 따로 기록)
    # acc = accuracy(y, y_hat)
    # acc_history.append(acc)

    # 역전파
    dz2 = (y_hat - y)                                           # (N, 1)
    dW2 = h_bias.T @ dz2 / X.shape[0]                           # (5, 1)
    dh = dz2 @ W2[:-1].T                                        # (N, 4)
    dz1 = dh * h * (1 - h)                                      # (N, 4)
    dW1 = x_bias.T @ dz1 / X.shape[0]                           # (2, 4)

    # 가중치 업데이트
    W2 -= lr * dW2
    W1 -= lr * dW1

    # 로깅
    if epoch % log_interval == 0 or epoch == 1:
        mse_val = mse(y, y_hat)
        print(f"[{epoch:6d}] loss={loss:.6f}  mse={mse_val:.6f}")


# ----- 최종 예측 출력 -----
print("\n최종 예측:")
x_bias = np.hstack([X, np.ones((X.shape[0], 1))])
h = sigmoid(x_bias @ W1)
h_bias = np.hstack([h, np.ones((h.shape[0], 1))])
y_hat = sigmoid(h_bias @ W2)

final_acc = accuracy(y, y_hat)
final_loss = bce_loss(y, y_hat)
for i in range(len(X)):
    x1 = float(X[i, 0])
    pred_prob = float(y_hat[i])
    print(f"입력=({x1:.2f})  타겟={y[i][0]:.2f}  예측값={pred_prob:.4f}")

print(f"\n최종 Loss={final_loss:.6f}, 최종 Accuracy={final_acc:.3f}")

print("\n가중치(W1, W2):")
print("W1 (입력1 + bias -> 은닉4):\n", W1)
print("W2 (은닉4 + bias -> 출력1):\n", W2)

# ----- 그래프: 한 Figure 안에 3개 서브플롯 -----
fig, axes = plt.subplots(1, 3, figsize=(15, 4))

# 1) Loss 곡선
axes[0].plot(range(1, len(loss_history) + 1), loss_history)
axes[0].set_xlabel("Epoch")
axes[0].set_ylabel("Loss")
axes[0].set_title("Training Loss")
axes[0].grid(True)

# 2) Train Prediction vs Target
axes[1].plot(X[:, 0], y, 'o-', label="Target (Train)")
axes[1].plot(X[:, 0], y_hat, 's--', label="Prediction (Train)")
axes[1].set_xlabel("Input")
axes[1].set_ylabel("Output")
axes[1].set_title("Train: Target vs Prediction")
axes[1].legend()
axes[1].grid(True)

# 3) Test Prediction vs Target
test_vals = np.round(np.arange(0.00, 1.00 + 1e-9, 0.01), 2)
test_X = test_vals.reshape(-1, 1)
test_x_bias = np.hstack([test_X, np.ones((test_X.shape[0], 1))])
test_h = sigmoid(test_x_bias @ W1)
test_h_bias = np.hstack([test_h, np.ones((test_h.shape[0], 1))])
test_y_hat = sigmoid(test_h_bias @ W2)

# 테스트 타겟(정답) 곡선은 기존 y 데이터를 기반으로 보간해서 연결
axes[2].plot(X[:, 0], y, 'o-', label="Target (Train Ref)")
axes[2].plot(test_X[:, 0], test_y_hat, 'd-.', label="Prediction (Test)")
axes[2].set_xlabel("Input")
axes[2].set_ylabel("Output")
axes[2].set_title("Test: Target vs Prediction")
axes[2].legend()
axes[2].grid(True)

plt.tight_layout()
plt.show()

# ----- 콘솔 출력 -----
print("\n테스트 예측(0.05 ~ 1.05):")
for xv, yp in zip(test_vals, test_y_hat.flatten()):
    print(f"입력={xv:.2f}  예측={yp:.4f}")
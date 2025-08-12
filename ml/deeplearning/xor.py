# xor.py
# 구조: Input(2) -> Hidden(2 + bias 1) -> Output(1)
# 학습: 시그모이드, Binary Cross-Entropy, 배치 경사하강법
# 추가: 에포크별 로스/정확도 로깅, 최종 Loss 곡선 그리기(matplotlib)

import numpy as np
import matplotlib.pyplot as plt

# ----- 데이터 (리스트 형식) -----
# 인풋1 인풋2 타겟
raw_samples = [
    [0, 0, 0],
    [1, 0, 1],
    [0, 1, 1],
    [1, 1, 0],
]

# numpy 배열로 변환
X = np.array([[s[0], s[1]] for s in raw_samples], dtype=float)  # shape: (4, 2)
y = np.array([s[2] for s in raw_samples], dtype=float).reshape(-1, 1)  # shape: (4, 1)

# ----- 하이퍼파라미터 -----
np.random.seed(42)
lr = 0.02
epochs = 100000
log_interval = 500

# ----- 네트워크 구조 -----
in_dim = 2
hidden_dim = 2
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

# ----- 로깅용 -----
loss_history = []
acc_history = []

# ----- 학습 루프 -----
for epoch in range(1, epochs + 1):
    # 순전파
    x_bias = np.hstack([X, np.ones((X.shape[0], 1))])           # (N, 3)
    z1 = x_bias @ W1                                            # (N, 2)
    h = sigmoid(z1)                                             # (N, 2)
    h_bias = np.hstack([h, np.ones((h.shape[0], 1))])           # (N, 3)
    z2 = h_bias @ W2                                            # (N, 1)
    y_hat = sigmoid(z2)                                         # (N, 1)

    # 손실/정확도
    loss = bce_loss(y, y_hat)
    acc = accuracy(y, y_hat)

    loss_history.append(loss)
    acc_history.append(acc)

    # 역전파
    dz2 = (y_hat - y)                                           # (N, 1)  (BCE+sigmoid 미분)
    dW2 = h_bias.T @ dz2 / X.shape[0]                           # (3, 1)

    dh = dz2 @ W2[:-1].T                                        # (N, 2)
    dz1 = dh * h * (1 - h)                                      # (N, 2)
    dW1 = x_bias.T @ dz1 / X.shape[0]                           # (3, 2)

    # 가중치 업데이트
    W2 -= lr * dW2
    W1 -= lr * dW1

    # 로깅
    if epoch % log_interval == 0 or epoch == 1:
        print(f"[{epoch:4d}] loss={loss:.6f}  acc={acc:.3f}")

# ----- 최종 예측 출력 -----
print("\n최종 예측:")
x_bias = np.hstack([X, np.ones((X.shape[0], 1))])
h = sigmoid(x_bias @ W1)
h_bias = np.hstack([h, np.ones((h.shape[0], 1))])
y_hat = sigmoid(h_bias @ W2)

final_acc = accuracy(y, y_hat)
final_loss = bce_loss(y, y_hat)
for i in range(len(X)):
    x1, x2 = X[i]
    pred_prob = float(y_hat[i])
    pred = 1 if pred_prob >= 0.5 else 0
    print(f"입력=({int(x1)}, {int(x2)})  타겟={int(y[i][0])}  예측확률={pred_prob:.4f}  예측={pred}")

print(f"\n최종 Loss={final_loss:.6f}, 최종 Accuracy={final_acc:.3f}")

print("\n가중치(W1, W2):")
print("W1 (입력2 + bias -> 은닉2):\n", W1)
print("W2 (은닉2 + bias -> 출력1):\n", W2)

# ----- 학습 곡선 그리기 -----
plt.figure()
plt.plot(range(1, epochs + 1), loss_history)
plt.xlabel("Epoch")
plt.ylabel("Loss")
plt.title("Training Loss")
plt.tight_layout()
plt.show()
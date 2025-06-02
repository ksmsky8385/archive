# import numpy as np

# # 샘플 데이터
# x = np.array([1, 2, 3, 4, 5])
# y = np.array([2, 4, 6, 8, 10])  # 실제값 (y = 2x)

# # 초기 가중치 설정
# w, b = np.random.rand(), np.random.rand()
# learning_rate = 0.01
# epochs = 10000

# # 경사 하강법 적용
# for epoch in range(epochs):
#     y_pred = w * x + b
#     loss = np.mean((y - y_pred) ** 2)  # MSE 손실 함수

#     # 기울기 계산
#     dw = -2 * np.mean(x * (y - y_pred))
#     db = -2 * np.mean(y - y_pred)

#     # 가중치 업데이트
#     w -= learning_rate * dw
#     b -= learning_rate * db

#     if epoch % 100 == 0:
#         print(f"Epoch {epoch}: Loss = {loss:.4f}, w = {w:.4f}, b = {b:.4f}")

# print(f"최종 모델: y = {w:.4f}x + {b:.4f}")



# 강의 실습코드

import numpy as np

# 초기화 
w0 = 1.0 # w_0^0 초기값
w1 = 1.0 # w_1^0 초기값
learning_rate = 0.1 # 학습률
num_iterationes = 100 # 반복 횟수

# 경사 하강법 반복
for t in range(num_iterationes):
    #업데이트식 계산
    w0_gradient = 4 * w1 + 6 * w0 - 6
    w1_gradient = 4 * w1 + 4 * w0 - 6
    
    # 파라메터 업데이트
    w0 = w0 - learning_rate * w0_gradient
    w1 = w1 - learning_rate * w1_gradient
    
    # 현재 상태 출력
    print(f"iteration {t+1} : w0 = {w0:6f}, w1 = {w1:6f}")
    
print(f"최종 결과 : w0 = {w0:6f}, w1 = {w1:6f}")
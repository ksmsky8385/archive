# # Quiz - 10 ~ 20 사이의숫자만입력받아1부터입력받은수까지의합을구하시오.

# total = 0
# for i in range(10,21):
#     total += i
# print(total)

# total = 0
# for i in range(1,21,1):
#     if i ==1:
#         total += i
#     if i >=10:
#         total += i
# print(total)



# 문제 - 
# 쌀100통이저장되어있는창고에암수1쌍의쥐가있다. 
# 쥐 한 마리가 하루에 20g씩의 쌀을 먹고, 10일(10,20,30)마다
# 쥐의 수가 2배씩 증가한다. 며칠만에 창고의 쌀이 모두 쥐의 먹이가 될까.
# 그리고쥐는총몇마리인가? (쌀한통= 1kg)(쌀을 먹은후2배증가하는조건)



# 초기값 설정
rice = 100 * 1000  # 100통 * 1kg = 100000g
mice = 2  # 암수 1쌍 (2마리)
days = 0  # 경과 일수
daily_consumption = 20  # 쥐 한 마리가 하루에 먹는 쌀(g)

# 반복문 실행
for days in range(1, 10000):  # 충분히 큰 범위 설정
    rice -= mice * daily_consumption  # 하루 동안 쌀 소비
    if rice <= 0:  # 쌀이 모두 소진되면 종료
        break
    if days % 10 == 0:  # 10일마다 쥐의 수가 2배 증가
        mice *= 2

# 결과 출력
print(f"{days}일 만에 쌀이 모두 소비됨.")
print(f"최종 쥐의 개체 수: {mice}마리")
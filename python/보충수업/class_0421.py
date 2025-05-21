# 컴퓨터와 사용자는 끊임없이 소통하여야 합니다.
# 그래서 바드시 입력함수를 학습해야만 합니다.

# print("숫자입력") # 입력함수 사용시 반드시 입력함수에 대한 안내를 해준다.
                    # 작성자는 항시 사용자를 배려하는 마음으로 프로그램을 작성한다.



# print("이름 입력 : ")
# name = input()
# print("나이 입력 : ")
# age = input()

# print(f"{name}님의 나이는 {age}살 입니다.")
# # print("%s님의 나이는 %d살 입니다"%(name,age))



# print("두 수의 합을 구해줍니다")
# print("두 수 입력")
# # 입력함수는 입력하는 값에 따른 에러를 최소화 하기 위해
# # 기본 자료형을 문자열로 저장하게 만들었다다
# num1 = input()
# num2 = input()
# num3 = int(num1) + int(num2)
# print("두 수의 합 ", num1,"+",num2,'=',num3)

# print("num1 type : ",type(num1))
# print("num2 type : ",type(num2))
# print("num3 type : ",type(num3))



# 예외처리



# n1 = 10
# n2 = 0

# try:
#     result = n1/n2
#     print("%d/%d = %d" %(n1,n2,result))
    
# except:
#     print("0으로 나눌 수 없습니다.")
# print("프로그램 정상 종료!!")



# while True:
#     try:
#         n1 = int(input('정수1 : '))
#         n2 = int(input('정수2 : '))
#         break
#     except:
#         print('숫자로만 입력하세요~')
#     # print('%d / %d = %d'%(n1,n2,result))

# try:
#     result = n1/n2
#     print('%d / %d = %d'%(n1,n2,result))
# except:
#     print('0으로 나눌 수 없습니다.')
# print('프로그램 정상 종료!!')



# pet = ['거북이', '타란튤라', '전갈']
# for i in range(4):
#     try:
#         print(pet[i],'키울래용!')
#     except:
#         print('애완동물의 정보가 없습니다')
#     finally: #예외처리(에러)와 상관없이 꼭 실행되야 하는경우
#         print('애완동물 넘 조아~~')
# print('프로그램 정상 종료!')



# name = input("이름을 입력 하세요: ")
# # 입력함수에는 print함수도 포함하고 있다
# # 입력함수안내문구를 input()안에 넣어주면 된다.

# age = int(input("나이를 입력 하세요 : "))
# # 어떤 유형이든 안내문구로 활용할 수 있다
# # 단, 갯수는 1개까지만 허용되며, 2개 이상은 에러가 발생한다


# addr = input("주소를 입력 하세요: ")

# print("이름 : ",name,"\n나이 : ",age,"\n주소 : ",addr)



# or & and 연산 예문문
a = 20
b = 10
print(False or (a+b))
print(True or (a+b))
print(False and (a+b))
print(True and (a+b))




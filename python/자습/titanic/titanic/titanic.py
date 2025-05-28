import pandas as pd
import numpy as np
import matplotlib
import matplotlib.pyplot as plt
import seaborn as sns


# 한글폰트설정 함수
def 한글폰트설정():
    # 시스템에 맞는 한글 폰트 설정
    matplotlib.rcParams['font.family'] = 'Malgun Gothic'  # 윈도우용: 'Malgun Gothic'
    # MacOS는 'AppleGothic', Linux는 'NanumGothic' 등을 사용할 수 있습니다.
    matplotlib.rcParams['axes.unicode_minus'] = False  # 음수 기호 제대로 표시

def 파일불러오기():
    file_path = r'C:\workspace\python\자습\titanic\titanic\data\titanic.csv'

    df = pd.read_csv(file_path)
    print("🔍 타이타닉 데이터 (head 5):")
    print(df.head(5))
    print()
    print(df)
    print()



def 성별간생존자그래프():
    한글폰트설정()
    file_path = r'C:\workspace\python\자습\titanic\titanic\data\titanic.csv'

    df = pd.read_csv(file_path)
    
    # 성별과 생존 여부를 기준으로 집계
    gender_survival = df.groupby(['Sex', 'Survived']).size().unstack().fillna(0)

    # 그래프 생성
    gender_survival.plot(kind='bar', stacked=True)
    
    # 그래프 제목, 축 레이블 등 설정
    plt.title('성별에 따른 생존자 수')
    plt.xlabel('성별')
    plt.ylabel('생존자 수')
    plt.xticks(rotation=0)
    plt.legend(['사망', '생존'], title="생존 여부")
    plt.tight_layout()
    
    # 그래프 표시
    plt.show()



def 탑승요금에따른생존자수():
    한글폰트설정()
    file_path = r'C:\workspace\python\자습\titanic\titanic\data\titanic.csv'

    df = pd.read_csv(file_path)

    # Fare를 구간으로 나누기
    fare_bins = [0, 10, 30, 100, 600]
    fare_labels = ['0-10', '10-30', '30-100', '100+']
    df['Fare_Bin'] = pd.cut(df['Fare'], bins=fare_bins, labels=fare_labels)

    # 생존 여부를 문자열로 변경
    df['Survived_Label'] = df['Survived'].map({0: '사망', 1: '생존'})

    # 시각화
    plt.figure(figsize=(10, 6))
    sns.countplot(data=df, x='Fare_Bin', hue='Survived_Label', palette='Set2', hue_order=['생존', '사망'], dodge=True)
    plt.title('요금 구간별 생존자 수 (성별 분리)')
    plt.xlabel('요금 구간')
    plt.ylabel('탑승자 수')
    plt.legend(title='생존 여부')
    plt.tight_layout()
    plt.show()



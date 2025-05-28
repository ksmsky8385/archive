# 초보자를 위한 파이썬 300제 (https://wikidocs.net/book/922)

def ch01_파이썬_시작하기():
    print('\n-001-\n')
    print("Hello world")

    print('\n-002-\n')
    print("Mary/'s cosmetics")

    print('\n-003-\n')
    print('신씨가 소리질렀다. "도둑이야".')

    print('\n-004-\n')
    print(f'C:\windows')

    print('\n-005-\n')
    print("안녕하세요.\n만나서\t\t반갑습니다.")
    print("\\n은 줄바꿈, \\t는 탭키 삽입 기능")

    print('\n-006-\n')
    print("오늘은", "일요일")
    print("오늘은일요일")

    print("\n-007-")
    print("naver;kakao;sk;samsung")

    print("\n-008-\n")
    print("naver/kakao/sk/samsung")

    print("\n-009-\n")
    print("first", end=" ");print("second")

    print("\n-010-\n")
    a = float(5/3)
    print(round(a,2))

def ch02_파이썬_변수():
    print("\n-011-\n")
    삼성전자 = 50000
    평가금액 = 삼성전자*10
    print(f"{평가금액:,}")

    print("\n-012-\n")
    시가총액 = 298000000000000
    현재가 = 50000
    PER = 15.79
    print(f"{시가총액:,}", type(시가총액))
    print(f"{현재가:,}", type(현재가))
    print(PER, type(PER))

    print("\n-013-\n")
    s = "hello"
    t = "python"
    print(s+"!",t)

    print("\n-014-\n")
    print(2 + 2 * 3)
    print(8)

    print("\n-015-\n")
    a = 128
    print(a, type(a))
    a = "132"
    print(a, type(a))

    print("\n-016-\n")
    num_str = "728"
    print(num_str, type(num_str))
    num_int = int(num_str)
    print(num_int,type(num_int))

    print("\n-017-\n")
    num = 100
    print(num, type(num))
    num_str = str(num)
    print(num_str,type(num_str))
    
    print("\n-018-\n")
    num_str = "15.79"
    print(num_str,type(num_str))
    num_float = float(num_str)
    print(num_float,type(num_float))
    
    print("\n-019-\n")
    year = "2020"
    print(year,type(year))
    year_int = int(year)
    print(year_int,type(year_int))
    print(year_int-1)
    print(year_int-2)
    print(year_int-3)

    print("\n-020-\n")
    price = 48584
    month = 36
    print(f"{price*month:,}")

def ch03_파이썬_문자열():
    print("\n-021-\n")
    letters = 'python'
    print(letters,type(letters))
    print(letters[0],letters[2])
    
    print("\n-022-\n")
    license_plate = "24가 2210"
    print(license_plate,type(license_plate))
    print(license_plate[-4:])
    
    print("\n-023-\n")
    string = "홀짝홀짝홀짝"
    print(string, type(string))
    print(string[::2])
    
    print("\n-024-\n")
    string = "PYTHON"
    print(string[::-1])
    
    print("\n-025-\n")
    phone_number = "010-1111-2222"
    print(phone_number[0:3]+" "+phone_number[4:8]+" "+phone_number[9:13])
    phone_number2 = phone_number.replace('-',' ')
    print(phone_number2)
    
    print("\n-026-\n")
    print(phone_number[0:3]+phone_number[4:8]+phone_number[9:13])
    phone_number3 = phone_number.replace('-','')
    print(phone_number3)
    
    print("\n-027-\n")
    url = "http://sharebook.kr"
    print(url[-2:])
    url_split = url.split('.')
    print(url_split[1]) # [-1]도 가능
    
    print("\n-028-\n")
    print("lang = 'python'\nlang[0] = 'p'\nprint(lang)\n애러뜸")
    
    
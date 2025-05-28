# SmartPhoneMain.py 파일

from SmartPhone import SmartPhone

class SmartPhoneMain:
    def __init__(self):
        self.smartphone = SmartPhone()
        
    def print_menu(self):
        print("\n주소관리메뉴")
        print("-------------------")
        print("1. 연락처등록")
        print("2. 모든 연락처 출력")
        print("3. 연락처 검색")
        print("4. 연락처 삭제")
        print("5. 연락처 수정")
        print("6. 프로그램 종료")
        print("-------------------")
        
    def start(self):
        while True:
            self.print_menu()
            choice = input("원하는 작업을 선택하세요 (1~6) : ")
            
            if choice == '1':
                addr = self.smartphone.input_addr_data()
                self.smartphone.add_addr(addr)
            elif choice == '2':
                self.smartphone.print_all_data()
            elif choice == '3':
                name = input("검색할 이름을 입력하세요 : ")
                self.smartphone.search_addr(name)
            elif choice == '4':
                name = input("삭제할 이름을 입력하세요 : ")
                self.smartphone.delete_addr(name)
            elif choice == '5':
                name = input("수정할 이름을 입력하세요 : ")
                print("새로운 연락처 정보를 입력하세요")
                new_addr = self.smartphone.input_addr_data()
                self.smartphone.edit_addr(name, new_addr)
            elif choice == '6':
                print("프로그램을 종료합니다.")
                break
            else:
                print("잘못된 입력입니다. 다시 선택하세요.")

# 프로그램 실행 구분
if __name__ == "__main__":
    smartphone_main = SmartPhoneMain()
    smartphone_main.start()
    
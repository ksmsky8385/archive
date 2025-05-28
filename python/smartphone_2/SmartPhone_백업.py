# SmartPhone.py 파일일

from Address import Addr

class SmartPhone:
    def __init__(self):
        self.addr_list = []

    # 사용자 입력을 받아 Addr 인스턴스 생성
    def input_addr_data(self):
        name = input("이름: ")
        phone = input("전화번호: ")
        email = input("이메일: ")
        address = input("주소: ")
        birth = input("생일 : ")
        while True:
            group = input("그룹(회사/거래처): ")
            if group not in ["회사", "거래처"]:
                print("'회사' 또는 '거래처' 중 하나를 입력해주세요.")
                continue
            break
        
        if group == "회사":
            addr = CompanyAddr(group)
        elif group == "거래처":
            addr = CustomerAddr(group)
        return Addr(name, phone, email, address, birth, addr.group)

    # 주소 등록
    def add_addr(self, addr):
        if len(self.addr_list) >= 10:
            print("실패. 최대 10개의 연락처만 저장 가능합니다.")
            return
        self.addr_list.append(addr)
        print(f"{addr.name}님의 연락처 등록 완료.")
        
    # 객체 정보 출력
    def print_addr(self):
        pass
        

    # 주소 전체 출력
    def print_all_data(self):
        if not self.addr_list:
            print("저장된 연락처가 없습니다.")
            return
        print("\n저장된 연락처 목록:")
        print("--------------------------")
        for addr in self.addr_list:
            addr.print_info()
            print("--------------------------")

    # 주소 검색
    def search_addr(self, name):
        for addr in self.addr_list:
            if addr.name == name:
                print("\n검색 결과:")
                addr.print_info()
                return
        print(f"{name}님의 연락처를 찾을 수 없습니다.")

    # 주소 삭제
    def delete_addr(self, name):
        for addr in self.addr_list:
            if addr.name == name:
                self.addr_list.remove(addr)
                print(f"{name}님의 연락처가 삭제되었습니다.")
                return
        print(f"{name}님의 연락처를 찾을 수 없습니다.")

    # 주소 수정
    def edit_addr(self, name, new_addr):
        for i, addr in enumerate(self.addr_list):
            if addr.name == name:
                self.addr_list[i] = new_addr
                print(f"{name}님의 연락처가 수정되었습니다.")
                return
        print(f"{name}님의 연락처를 찾을 수 없습니다.")


# 상속클래스
class CompanyAddr(SmartPhone):
    def __init__(self, group):
        super().__init__()
        if group == "회사":
            company = input("회사명을 입력해주세요 : ")
            depart = input("부서명을 입력해주세요 : ")
            position = input("직급을 입력해주세요 : ")
            self.group = f"회사\n회사명 : {company}\n부서 : {depart}\n직급 : {position}"

class CustomerAddr(SmartPhone):
    def __init__(self, group):
        super().__init__()
        if group == "거래처":
            company = input("거래처명을 입력해주세요 : ")
            depart = input("품목을 입력해주세요 : ")
            position = input("직급을 입력해주세요 : ")
            self.group = f"거래처\n거래처명 : {company}\n품목 : {depart}\n직급 : {position}"

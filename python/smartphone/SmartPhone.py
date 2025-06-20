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
        group = input("그룹(친구/가족 등): ")
        return Addr(name, phone, email, address, group)

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
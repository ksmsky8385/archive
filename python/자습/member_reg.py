# Member 클래스

class Member:
    def __init__(self, id, pw):
        self.id = id
        self.pw = pw

# MemberRegister 클래스

class MemberRegister:
    def __init__(self):
        self.member = {}

    def login(self, id, pw):
        isMember = id in self.member
        if isMember and self.member[id] == pw:
            print(f'{id} : Log-in Success!')
            return True
        else:
            print(f'{id} does not exist.')
            return False

    def viewMember(self):
        for key in self.member.keys():
            print(f'ID: {key}')
            print(f'ID: {self.member[key]}')

    def deleteMember(self, id, pw):
        isMember = id in self.member
        if isMember and self.member[id] == pw:
            # self.member.pop(id)
            del self.member[id]
            self.viewMember()
        else:
            print(f'{id} does not exist.')
            

if __name__ == "__main__":

    mRegister = MemberRegister()
    print('\t 회원가입 \t')

    for i in range(3):
        id = input('ID : ')
        pw = input('PW : ')
        member = Member(id, pw)
        mRegister.member.update({member.id: member.pw})

    # 멤버 조회
    mRegister.viewMember()

    # 로그인
    print('로그인')
    while True:
        id = input('ID : ')
        pw = input('PW : ')
        if mRegister.login(id, pw):
            break

    # 삭제
    print('회원 관리')
    id = input('ID : ')
    pw = input('PW : ')
    mRegister.deleteMember(id, pw)
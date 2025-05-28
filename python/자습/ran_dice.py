import random

class Dice:
    def __init__(self):
        self.com = None
        self.user = None
        
    def setCnum(self):
        print("[Dice] setCnum()")
        return random.randint(1,6)
    
    def setUnum(self):
        print("[Dice] setUnum()")
        return random.randint(1,6)
    
    def startGame(self):
        print("[Dice] startGame()")
        self.com = self.setCnum()
        self.user = self.setUnum()
        self.printResult()
        
    def printResult(self):
        if self.com == self.user:
            print(f'컴퓨터 vs 유저 : {self.com} vs {self.user} >> 무승부')
        elif self.com > self.user:
            print(f"컴퓨터 vs 유저 : {self.com} vs {self.user} >> Computer Win")
        else:
            print(f"컴퓨터 vs 유저 : {self.com} vs {self.user} >> User Win")
            
if __name__ == "__main__":
    dice = Dice()
    dice.startGame()
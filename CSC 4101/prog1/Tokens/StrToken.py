# StrToken -- Token object for representing string constants

from Tokens import TokenType
from Tokens import Token

class StrToken(Token):
    def __init__(self, s):
        super().__init__(TokenType.STR)
        self.name = s

    def getName(self):
        return self.name

if __name__ == "__main__":
    tok = StrToken("hello")
    print(tok.getType())
    print(tok.getName())

# Scanner -- The lexical analyzer for the Scheme printer and interpreter

import sys
import io
from Tokens import *

class Scanner:
    def __init__(self, i):
        self.In = i
        self.buf = []
        self.ch_buf = None

    def read(self):
        if self.ch_buf == None:
            return self.In.read(1)
        else:
            ch = self.ch_buf
            self.ch_buf = None
            return ch
    
    def peek(self):
        if self.ch_buf == None:
            self.ch_buf = self.In.read(1)
            return self.ch_buf
        else:
            return self.ch_buf

    @staticmethod
    def isDigit(ch):
        return ch >= '0' and ch <= '9'

    def isIdentifier(self, ch):
        if (ch >= 'A' and ch <= 'Z') or (ch >= 'a' and ch <= 'z'):
            return True
        elif ch == "+" or ch == "*" or ch == "-" or ch == "%" or ch == "/" or ch == "^":
            return True
        elif ch == "!" or ch == "$" or ch == "&" or ch == "." or ch == ":" or ch == "?" or ch == "@" or ch == "_" or ch == "~":
            return True
        elif ch == "<" or ch == ">" or ch == "=" or self.isDigit(ch):
            return True
        else:
            return False

    def getNextToken(self):
        try:
            # It would be more efficient if we'd maintain our own
            # input buffer for a line and read characters out of that
            # buffer, but reading individual characters from the
            # input stream is easier.
            ch = self.read()

            # DONE: Skip white space and comments, returning nothing
            # TODO: check and see if correct
            flag = True

            while flag:
                if ch == " " or ch == "\t" or ch == "\n":
                    ch = self.read()
                elif ch == ";":
                    while ord(ch) != 10 and ch != "":
                        ch = self.read()
                else:
                    flag = False

            # if ch == ';':
            #     return
            #     # ch = self.In.readline()
            #     # print(ch)
            #     # print("if 2")
            #     # ch = self.read()
            #     # print(ch)

            # Return None on EOF
            if ch == "":
                return None
    
            # Special characters
            elif ch == '\'': 
                return Token(TokenType.QUOTE)
            elif ch == '(':
                return Token(TokenType.LPAREN)
            elif ch == ')':
                return Token(TokenType.RPAREN)
            elif ch == '.':
                #  We ignore the special identifier `...'.
                return Token(TokenType.DOT)

            # Boolean constants
            elif ch == '#':
                ch = self.read()

                if ch == 't':
                    return Token(TokenType.TRUE)
                elif ch == 'f':
                    return Token(TokenType.FALSE)
                elif ch == "":
                    sys.stderr.write("Unexpected EOF following #\n")
                    return None
                else:
                    sys.stderr.write("Illegal character '" +
                                     chr(ch) + "' following #\n")
                    return self.getNextToken()

            # String constants
            elif ch == '"':
                self.buf = []
                # DONE: scan a string into the buffer variable buf
                ch = self.read()
                while ch != '"':
                    self.buf.append(ch)
                    ch = self.read()
                return StrToken("".join(self.buf))

            # Integer constants
            elif self.isDigit(ch):
                i = ord(ch) - ord('0')
                # DONE: scan the number and convert it to an integer
                num = ""
                num += ch
                while self.isDigit(self.peek()):
                    ch = self.read()
                    num += ch
                i = int(num)
                # make sure that the character following the integer
                # is not removed from the input stream
                return IntToken(i)
    
            # Identifiers
            elif self.isIdentifier(ch): #(ch >= 'A' and ch <= 'Z') or (ch):
                # or ch is some other vaid first character
                # for an identifier
                self.buf = []
                self.buf.append(ch)
                # TODO: scan an identifier into the buffer variable buf
                while self.isIdentifier(self.peek()):
                    ch = self.read()
                    self.buf.append(ch)

                # make sure that the character following the identifier
                # is not removed from the input stream
                return IdentToken("".join(self.buf))

            # Illegal character
            else:
                sys.stderr.write("Illegal input character '" + ch + "'\n")
                return self.getNextToken()

        except IOError:
            sys.stderr.write("IOError: error reading input file\n")
            return None


if __name__ == "__main__":
    scanner = Scanner(sys.stdin)
    tok = scanner.getNextToken()
    tt = tok.getType()
    print(tt)
    if tt == TokenType.INT:
        print(tok.getIntVal())

# Regular -- Parse tree node strategy for printing regular lists

from Special import Special
import sys

from Tokens.TokenType import TokenType

class Regular(Special):
    # TODO: Add fields and modify the constructor as needed.
    def __init__(self):
        pass

    def print(self, t, n, p):
        #print tabs
        for _ in range(n):
            sys.stdout.write(' ')

        #see if need to print LPAREN
        if p:
            print("(", end = "")
        
        #print the first value
        if t.getCar() is not None:
            if t.getCar().isPair():
                t.getCar().print(0, True)
            else:
                t.getCar().print(0)
            
        if t.getCdr().isPair():
            t.getCdr().print(1)
        elif t.getCdr().isNull():
            t.getCdr().print(0, True)
        else:
            print(" . ", end="")
            t.getCdr().print(0)
            print(")", end="", flush=True)

            

        
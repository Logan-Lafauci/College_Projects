# Set -- Parse tree node strategy for printing the special form set!

from Special import Special
import sys

class Set(Special):
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
        if t.getCar().isPair():
            t.getCar().print(0, True)
        else:
            t.getCar().print(0)
        
        if t.getCdr().isPair():
            t.getCdr().print(1)
        else:
            t.getCdr().print(0, True)


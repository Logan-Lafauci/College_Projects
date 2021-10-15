# Define -- Parse tree node strategy for printing the special form define
import sys
from Special import Special

class Define(Special):
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
        print("define", end="")

        if t.getCdr().getCar().isPair():
            next = t
            first = True
            while next.getCdr().isNull() is False:
                next = next.getCdr()
                if first:
                    next.getCar().print(n+1, True)  
                    first = False  
                else:
                    next.getCar().print(n+4, True)
                print()
            
            next.getCdr().print(n, True)
        
        else:
            t.getCdr().print(1)


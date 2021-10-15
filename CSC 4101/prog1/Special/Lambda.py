# Lambda -- Parse tree node strategy for printing the special form lambda

from Special import Special
import sys

class Lambda(Special):
    # TODO: Add fields and modify the constructor as needed.
    def __init__(self):
        pass

    def print(self, t, n, p):
        for _ in range(n):
            sys.stdout.write(' ')
        if p:
            sys.stdout.write("(")
        sys.stdout.write("lambda")
        
        next = t
        first = True
        while next.getCdr().isNull() is False:
            next = next.getCdr()
            if first:
                next.getCar().print(1, True)  
                first = False  
            else:
                next.getCar().print(n+4, True)
            print()
        
        next.getCdr().print(n, True)


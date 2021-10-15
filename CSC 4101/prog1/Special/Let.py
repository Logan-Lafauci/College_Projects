# Let -- Parse tree node strategy for printing the special form let

from Special import Special
import sys

class Let(Special):
    # TODO: Add fields and modify the constructor as needed.
    def __init__(self):
        pass

    def print(self, t, n, p):
        for _ in range(n):
            sys.stdout.write(' ')
        if p:
            sys.stdout.write("(")
        sys.stdout.write("let\n")
        
        next = t
        while next.getCdr().isNull() is False:
            next = next.getCdr()
            next.getCar().print(n+4, True)
            print()
        
        next.getCdr().print(0, True)

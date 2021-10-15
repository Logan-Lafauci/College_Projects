# Quote -- Parse tree node strategy for printing the special form quote

from Special import Special
import sys

class Quote(Special):
    # TODO: Add fields and modify the constructor as needed.
    def __init__(self):
        pass

    def print(self, t, n, p):
        #print tabs
        for _ in range(n):
            sys.stdout.write(' ')

        next = t
        flag = True
        while flag:

            print("'", end="")
            if next.getCdr().getCar().getCar().name.lower() == "quote":
                next = next.getCdr().getCar()
            else:
                flag = False
            

        print("(", end = "")
        next.getCdr().getCar().print(0)
        
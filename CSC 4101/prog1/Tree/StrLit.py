# StLit -- Parse tree node class for representing string literals

import sys
from Tree import Node

class StrLit(Node):
    def __init__(self, s):
        self.name = s

    def print(self, n, p=False):
        # There got to be a more efficient way to print n spaces.
        for _ in range(n):
            sys.stdout.write(' ')
        sys.stdout.write("\"" + self.name + "\"")

    def isString(self):
        return True

if __name__ == "__main__":
    id = StrLit("foo")
    id.print(0)

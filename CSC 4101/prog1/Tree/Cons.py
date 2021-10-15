# Cons -- Parse tree node class for representing a Cons node

from Special.Begin import Begin
from Tree import Node
from Tree import Ident
from Special import *

class Cons(Node):
    def __init__(self, a, d):
        self.car = a
        self.cdr = d
        self.special = True
        self.parseList()

    # parseList() `parses' special forms, constructs an appropriate
    # object of a subclass of Special, and stores a pointer to that
    # object in variable form.  It would be possible to fully parse
    # special forms at this point.  Since this causes complications
    # when using (incorrect) programs as data, it is easiest to let
    # parseList only look at the car for selecting the appropriate
    # object from the Special hierarchy and to leave the rest of
    # parsing up to the interpreter.
    def parseList(self):
        # TODO: implement this function and any helper functions
        # you might need
        if self.__getName() == "begin":
            self.form = Begin()
        elif self.__getName() == "cond":
            self.form = Cond()
        elif self.__getName() == "define":
            self.form = Define()
        elif self.__getName() == "if":
            self.form = If()
        elif self.__getName() == "lambda":
            self.form = Lambda()
        elif self.__getName() == "let":
            self.form = Let()
        elif self.__getName() == "quote":
            self.form = Quote()
        elif self.__getName() == "set!":
            self.form = Set()
        else: #self.car == "regular":
            self.special = False
            self.form = Regular()

    def __getName(self):
        if self.car.isNull() or self.car.isPair() or self.car.isNumber() or self.car.isBool():
            return ""
        else:
            return self.car.name.lower()

    def print(self, n, p=False):
        self.form.print(self, n, p)

    def isSpecial(self):
        return self.special

    def isPair(self):
        return True

    def setCar(self, a):
        self.car = a
        self.parseList()
    
    def setCdr(self, d):
        self.cdr = d

    def getCar(self):
        return self.car
    
    def getCdr(self):
        return self.cdr

if __name__ == "__main__":
    c = Cons(Ident("Hello"), Ident("World"))
    c.print(0)

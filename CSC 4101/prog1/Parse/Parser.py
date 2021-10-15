# Parser -- the parser for the Scheme printer and interpreter
#
# Defines
#
#   class Parser
#
# Parses the language
#
#   exp  ->  ( rest
#         |  #f
#         |  #t
#         |  ' exp
#         |  integer_constant
#         |  string_constant
#         |  identifier
#    rest -> )
#         |  exp+ [. exp] )
#
# and builds a parse tree.  Lists of the form (rest) are further
# `parsed' into regular lists and special forms in the constructor
# for the parse tree node class Cons.  See Cons.parseList() for
# more information.
#
# The parser is implemented as an LL(0) recursive descent parser.
# I.e., parseExp() expects that the first token of an exp has not
# been read yet.  If parseRest() reads the first token of an exp
# before calling parseExp(), that token must be put back so that
# it can be re-read by parseExp() or an alternative version of
# parseExp() must be called.
#
# If EOF is reached (i.e., if the scanner returns None instead of a token),
# the parser returns None instead of a tree.  In case of a parse error, the
# parser discards the offending token (which probably was a DOT
# or an RPAREN) and attempts to continue parsing with the next token.

from Tree import *
import sys
from Tokens import *

class Parser:
    def __init__(self, s):
        self.scanner = s

    def parseExp(self):
        # DONE: write code for parsing an exp
        return self.__parseExp(self.scanner.getNextToken())

    #DONE we need to look for a dot then we follow it up with a exp and Rparen 
    def parseRest(self, t):
        # DONE: write code for parsing a rest
        if t.getType() == TokenType.RPAREN:
            return Nil.getInstance()
        elif t.getType() == TokenType.LPAREN:
            return Cons(self.__parseExp(t), self.__parseRest())
        else:
            extra = self.scanner.getNextToken()
            if extra.getType() == TokenType.DOT:
                retval = Cons(self.__parseExp(t), self.parseExp())
                self.scanner.getNextToken()  #Get the RPAREN after the exp, so not messing up the parser
                return retval
            elif extra.getType() == TokenType.RPAREN:
                return Cons(self.__parseExp(t), Nil.getInstance())
            else:
                return Cons(self.__parseExp(t), self.parseRest(extra))

    # DONE: Add any additional methods you might need

    def __parseRest(self):
        return self.parseRest(self.scanner.getNextToken())

    def __parseExp(self, t):
        if t == None:
            return None
        elif t.getType() == TokenType.LPAREN:
            return self.__parseRest()
        elif t.getType() == TokenType.FALSE:
            return BoolLit.getInstance(False)
        elif t.getType() == TokenType.TRUE:
            return BoolLit.getInstance(True)
        elif t.getType() == TokenType.QUOTE:
            return Cons(Ident("quote"), Cons(self.parseExp(), Nil.getInstance()))
        elif t.getType() == TokenType.INT:
            return IntLit(t.getIntVal())
        elif t.getType() == TokenType.STR:
            return StrLit(t.getName())
        elif t.getType() == TokenType.IDENT:
            return Ident(t.getName()) 
    

    def __error(self, msg):
        sys.stderr.write("Parse error: " + msg + "\n")

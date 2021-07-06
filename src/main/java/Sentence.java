import java.util.*;

class Sentence {

    public boolean evaluate(Map model) throws Exception{
        /**
         * Takes in thre statement and evaluates it
         */
        throw new Exception("sorry device error");
    }

    public String formula() {
        /**
         * Returns string formula representing logical sentence.
         */
        return "";
    }

    public Set<String> symbols(){
        /**
         * Returns a set of all symbols in the logical sentence.
         */
        Set<String> symbols = new HashSet<String>();
        return symbols;
    }

    static void validate(Object sentence) throws Exception{
        if (!(sentence instanceof Sentence)) {
            throw new Exception("This is not a valid logical Sentence");
        }
    }

    static String parenthesize(String expr){
        /**
         * Parenthesizes an expression if not already parenthesized.
         */
        if (Helper.isAlpha(expr) || (expr.charAt(0)=='(' && expr.charAt(expr.length() - 1)==')' && Helper.balanced(expr)))
            return expr;
        else
            return String.format("(%s)", expr);
    }

}
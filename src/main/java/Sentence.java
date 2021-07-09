import java.util.*;

public class Sentence {

    /**
     * Takes in thre statement and evaluates it
     */
    public boolean evaluate(Map model) throws Exception{
        throw new Exception("sorry device error");
    }

    /**
     * Returns string formula representing logical sentence.
     */
    public String formula() {
        return "";
    }

    /**
     * Returns a set of all symbols in the logical sentence.
     */
    public Set<String> symbols(){
        Set<String> symbols = new HashSet<String>();
        return symbols;
    }

    /**
     * Checks if given object is a valid sentence
     */
    static void validate(Object sentence) throws Exception{
        if (!(sentence instanceof Sentence)) {
            throw new Exception("This is not a valid logical Sentence");
        }
    }

    /**
     * Parenthesizes an expression if not already parenthesized.
     */
    static String parenthesize(String expr){
        if (Helper.isAlpha(expr) || (expr.charAt(0)=='(' && expr.charAt(expr.length() - 1)==')' && Helper.balanced(expr)))
            return expr;
        else
            return String.format("(%s)", expr);
    }

}
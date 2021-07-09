import java.util.*;

public class Helper{

    public static final String TEXT_RED = "\u001B[31m";

    /**
     * Checks if a string has balanced parentheses.
     */
    public static boolean balanced(String expr){
        if (expr.isEmpty())
            return true;

        Stack<Character> parenthesis = new Stack<Character>();

        for (int i = 0; i < expr.length(); i++){
            char current = expr.charAt(i);

            if(current=='(')
                parenthesis.push(current);

            if(current==')'){
                char last = parenthesis.peek();
                if(current==')' && last=='(')
                    parenthesis.pop();
                else
                    return false;
            }
        }
        return expr.isEmpty() ? true : false;
    }

    /**
     * Checks if a string has only alphabaets.
     */
    public static boolean isAlpha(String s) {
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Appends the obj argument to the Object array
     * Returns the new array
     */
    public static Sentence[] addToSentenceArray(Sentence[] currentArray, Sentence obj){
        ArrayList<Sentence> temp = new ArrayList<Sentence>(Arrays.asList(currentArray));
        temp.add(obj);
        return temp.toArray(new Sentence[0]);
    }

    public static String randomSet(Set<String> obj){
        int item = new Random().nextInt(obj.size()); // In real life, the Random object should be rather more shared than this
        int i = 0;
        for(String o : obj)
        {
            if (i == item)
                return o;
            i++;
        }
        return "";
    }
}

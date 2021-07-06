import java.util.*;

class Helper{

    public static final String TEXT_RED = "\u001B[31m";

    public static boolean balanced(String expr){
        /**
         * Checks if a string has balanced parentheses.
         */
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

    public static boolean isAlpha(String s) {
        /**
         * Checks if a string has only alphabaets.
         */
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public static Sentence[] addToSentenceArray(Sentence[] currentArray, Sentence obj){
        /**
         * Appends the obj argument to the Object array
         * Returns the new array
         */
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

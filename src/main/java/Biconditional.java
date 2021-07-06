import java.util.*;

class Biconditional extends Sentence{

    Sentence left;

    Sentence right;

    public Biconditional(Sentence leftInput, Sentence rightInput){
        try{
            Sentence.validate(leftInput);
            Sentence.validate(rightInput);
        }
        catch(Exception e){
            System.out.println(Helper.TEXT_RED + "Error Occoured:"+ e.toString());
            System.exit(0);
        }
        left = leftInput;
        right = rightInput;
    }

    public boolean equals(Object other){
        boolean result = (other instanceof Biconditional) && left.equals(((Biconditional)other).left) && right.equals(((Biconditional)other).right);
        return result;
    }

    public int hashCode(){
        String hasher = "biconditional" + left.hashCode() + right.hashCode();
        return hasher.hashCode();
    }

    public String toString(){
        return String.format("Bimplication(%s, %s)", left.toString(), right.toString());
    }

    public boolean evaluate(Map model){
        boolean result = false;
        try{
            result = (left.evaluate(model)) && right.evaluate(model)||(!left.evaluate(model)) && !right.evaluate(model) ;
        }
        catch(Exception e){
            System.out.println(Helper.TEXT_RED + "Error Occoured:"+ e.toString());
            System.exit(0);
        }
        return result;
    }

    public String formula(){
        return String.format("%s <=> %s", Sentence.parenthesize(left.toString()), Sentence.parenthesize(right.toString()));
    }

    public Set<String> symbols(){
        Set<String> symbol = new HashSet<String>();
        for(String l: left.symbols())
            symbol.add(l);
        for(String r: right.symbols())
            symbol.add(r);
        return symbol;
    }
}

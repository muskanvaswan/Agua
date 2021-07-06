import java.util.*;

class Implication extends Sentence{

    Sentence antecedent;

    Sentence consequent;

    public Implication(Sentence antecedentInput, Sentence consequentInput){
        try{
            Sentence.validate(antecedentInput);
            Sentence.validate(consequentInput);
        }
        catch(Exception e){
            System.out.println(Helper.TEXT_RED + "Error Occoured:"+ e.toString());
            System.exit(0);
        }
        antecedent = antecedentInput;
        consequent = consequentInput;
    }

    public boolean equals(Object other){
        boolean result = (other instanceof Implication) && antecedent.equals(((Implication)other).antecedent) && consequent.equals(((Implication)other).consequent);
        return result;
    }

    public int hashCode(){
        String hasher = antecedent.hashCode() + "implies" + consequent.hashCode();
        return hasher.hashCode();
    }

    public String toString(){
        return String.format("Implication(%s, %s)", antecedent.toString(), consequent.toString());
    }

    public boolean evaluate(Map model){
        boolean result = false;
        try{
            result = !(antecedent.evaluate(model)) || consequent.evaluate(model);;
        }
        catch(Exception e){
            System.out.println(Helper.TEXT_RED + "Error Occoured:"+ e.toString());
            System.exit(0);
        }
        return result;
    }

    public String formula(){
        return String.format("%s => %s", Sentence.parenthesize(antecedent.toString()), Sentence.parenthesize(consequent.toString()));
    }

    public Set<String> symbols(){
        Set<String> symbol = new HashSet<String>();
        for(String a: antecedent.symbols())
            symbol.add(a);
        for(String c: consequent.symbols())
            symbol.add(c);
        return symbol;
    }
}

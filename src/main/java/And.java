import java.util.*;

public class And extends Sentence{

    public Sentence[] conjuncts;

    public And(Sentence ...conjunctsInput){
        for(Sentence conjunct: conjunctsInput){
            try{
                Sentence.validate(conjunct);
            }
            catch(Exception e){
                System.out.println(Helper.TEXT_RED + "Error Occoured:"+ e.toString());
                System.exit(0);
            }
        }
        conjuncts = conjunctsInput;
    }

    public boolean equals(Object other){
        boolean result = (other instanceof And) && conjuncts.equals(((And)other).conjuncts);
        return result;
    }

    public int hashCode(){
        String hasher = "and" + conjuncts.hashCode();
        return hasher.hashCode();
    }

    public String toString(){
        Set<String> conjunctions = new HashSet<String>();
        for (Sentence conjunct: conjuncts){
            String ss = conjunct.toString();
            conjunctions.add(ss);
        }
        String str = String.join(", ", conjunctions);
        return String.format("And(%s)", str);
    }

    public void add(Sentence conjunct){
        try{
            Sentence.validate(conjunct);
        }
        catch(Exception e){
            System.out.println(Helper.TEXT_RED + "Error Occoured:"+ e.toString());
            System.exit(0);
        }
        conjuncts = Helper.addToSentenceArray(conjuncts, conjunct);
    }

    public boolean evaluate(Map model){
        try{
            for (Sentence conjunct: conjuncts){
                if (!conjunct.evaluate(model))
                    return false;
            }
        }
        catch(Exception e){
            System.out.println(Helper.TEXT_RED + "Error Occoured:"+ e.toString());
            System.exit(0);
        }
        return true;
    }

    public String formula(){
        if (conjuncts.length == 1)
            return conjuncts[0].formula();
        Set<String> conjunctions = new HashSet<String>();
        for (Sentence conjunct: conjuncts){
            String ss = Sentence.parenthesize(conjunct.formula());
            conjunctions.add(ss);
        }
        return String.join(" ∧ ", conjunctions);
    }

    public Set<String> symbols(){
        Set<String> symbol = new HashSet<String>();
        for (Sentence conjunct: conjuncts){
            Set<String> ss= conjunct.symbols();
            for (String s: ss){
                symbol.add(s);
            }
        }
        return symbol;
    }
}

import java.util.*;

public class Or extends Sentence{
    public Sentence[] disjuncts;

    public Or(Sentence ...disjunctsInput){
        for(Sentence disjunct: disjunctsInput){
            try{
                Sentence.validate(disjunct);
            }
            catch(Exception e){
                System.out.println(Helper.TEXT_RED + "Error Occoured:"+ e.toString());
                System.exit(0);
            }
        }
        disjuncts = disjunctsInput;
    }

    public boolean equals(Object other){
        boolean result = (other instanceof Or) && disjuncts.equals(((Or)other).disjuncts);
        return result;
    }

    public int hashCode(){
        String hasher = "or" + disjuncts.hashCode();
        return hasher.hashCode();
    }

    public String toString(){
        Set<String> disjunctions = new HashSet<String>();
        for (Sentence disjunct: disjuncts){
            String ss = disjunct.toString();
            disjunctions.add(ss);
        }
        String str = String.join(",  ", disjunctions);
        return String.format("Or(%s)", str);
    }

    public boolean evaluate(Map model){
        try{
            for (Sentence disjunct: disjuncts){
                if (disjunct.evaluate(model))
                    return true;
            }
        }
        catch(Exception e){
            System.out.println(Helper.TEXT_RED + "Error Occoured:"+ e.toString());
            System.exit(0);
        }
        return false;
    }

    public String formula(){
        if (disjuncts.length == 1)
            return disjuncts[0].formula();
        Set<String> disjunctions = new HashSet<String>();
        for (Sentence disjunct: disjuncts){
            String ss = Sentence.parenthesize(disjunct.formula());
            disjunctions.add(ss);
        }
        return String.join(" ∨ ", disjunctions);
    }

    public Set<String> symbols(){
        Set<String> symbol = new HashSet<String>();
        for (Sentence disjunct: disjuncts){
            Set<String> ss= disjunct.symbols();
            for (String s: ss){
                symbol.add(s);
            }
        }
        return symbol;
    }

}

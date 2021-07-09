import java.util.*;

public class Not extends Sentence{
    public Sentence operand;

    public Not(Sentence operand_input){
        try{
            Sentence.validate(operand_input);
            operand = operand_input;
        }
        catch(Exception e){
            System.out.println(Helper.TEXT_RED + "Error Occoured:"+ e.toString());
            System.exit(0);
        }
    }

    public boolean equals(Object other){
        return (other instanceof Not) && operand.equals(((Not)other).operand);
    }

    public int hashCode(){
        String hasher = "not" + operand.hashCode();
        return hasher.hashCode();
    }

    public String toString(){
        return String.format("Not(%s)", operand.toString());
    }

    public boolean evaluate(Map model){
        boolean result = false;
        try{
            result = !(operand.evaluate(model));
        }
        catch(Exception e){
            System.out.println(Helper.TEXT_RED + "Error Occoured:"+ e.toString());
            System.exit(0);
        }
        return result;
    }

    public String formula(){
        return "¬" + Sentence.parenthesize(operand.formula());
    }

    public Set<String> symbols(){
        return operand.symbols();
    }
}

import java.util.*;

public class Symbol extends Sentence{

    String name;

    public Symbol(String inputName){
        name = inputName;
    }

    public String toString(){
        return name;
    }

    public boolean equals(Object other){
        return (other instanceof Symbol) && (other.toString() == name);
    }

    public int hashCode(){
        String hasher = "symbol" + name;
        return hasher.hashCode();
    }

    public boolean evaluate(Map model){
        try{
            return (boolean)model.get(name);
        }
        catch(Exception e){
            System.out.println(Helper.TEXT_RED + String.format("Error Occoured: variable %s not in model", name));
            throw e;
        }
    }

    public String formula(){
        return name;
    }

    public Set<String> symbols(){
        Set<String> symbol_set = new HashSet<String>();
        symbol_set.add(name);
        return symbol_set;
    }
}

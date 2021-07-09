import java.util.*;

public class Solver {
    public static boolean checkAll(Sentence knowledge, Sentence query, Set<String> symbols, Map<String, Boolean> model){
        /**
         * Checks if knowledge base entails query, given a particular model.
         */

        // If model has an assignment for each symbol
        if (symbols.size() == 0){
            try{
                System.out.println(model);
                System.out.println(knowledge.evaluate(model));

                // If knowledge base is true in model, then query must also be true
                //if (knowledge.evaluate(model))
                //return query.evaluate(model);
            }
            catch(Exception e){
                System.out.println(Helper.TEXT_RED + "Error Occoured:"+ e.toString());
                System.exit(0);
            }

            return true;
        }
        else{
            Set<String> remaining = new HashSet<String>(symbols);

            // Choose one of the remaining unused symbols
            String p = Helper.randomSet(remaining);
            remaining.remove(p);


            Map<String, Boolean> modelTrue = new HashMap<String, Boolean>();
            Map<String, Boolean> modelFalse = new HashMap<String, Boolean>();

            // copying old model
            for(String k: model.keySet()){
                boolean val = model.get(k);
                modelTrue.put(k, val);
                modelFalse.put(k, val);
            }

            // Create a model where the symbol is true
            modelTrue.put(p, true);

            // Create a model where the symbol is false
            modelFalse.put(p, false);

            // Ensure entailment holds in both models
            return (checkAll(knowledge, query, remaining, modelTrue) && checkAll(knowledge, query, remaining, modelFalse));
        }
    }

    public static boolean modelCheck(Sentence knowledge, Sentence query){
        /**
         * Checks if knowledge base entails query.
         */

        // Get all symbols in both knowledge and query
        Set<String> symbols = knowledge.symbols();
        for(String symbol: query.symbols()){
            symbols.add(symbol);
        }

        // Initialise empty model
        Map<String, Boolean> newModel = new HashMap<String, Boolean>();

        // Check that knowledge entails query
        return checkAll(knowledge, query, symbols, newModel );
    }
}

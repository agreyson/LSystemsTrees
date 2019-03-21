import java.util.HashMap;

public class LSystem {
    private Turtle turtle;
    private String generation;
    private int numGenerations;
    private HashMap<String, String> productionRules;

    public LSystem(String axiom, HashMap<String, String> productionRules, float startingLength, float theta, int color)
    {
        this.turtle = new Turtle(startingLength, theta, color);
        this.generation = axiom;
        this.numGenerations = 0;

        this.productionRules = productionRules;
        productionRules.put("+", "+");
        productionRules.put("-", "-");
        productionRules.put("[", "[");
        productionRules.put("]", "]");
    }

    public void render(){
        LSystemsTreesApp app = LSystemsTreesApp.getApp();
        for (int i = 0; i < generation.length(); i++){
            turtle.render(generation.charAt(i), numGenerations);
        }
    }

    public void generateNewSentence(){
        StringBuffer nextgen = new StringBuffer();
        for (int i = 0; i < generation.length(); i++){
            char c = generation.charAt(i);
            String replacement = productionRules.get(Character.toString(c));
            nextgen.append(replacement);
            if (replacement == null){
                System.out.println("Something went wrong " + c);
            }
        }
        generation = nextgen.toString();
        numGenerations++;
        System.out.println(generation);
    }
}

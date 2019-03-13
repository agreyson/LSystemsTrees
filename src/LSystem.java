import java.util.HashMap;

public class LSystem {

    private String generation; // current generation
    private int numGenerations; // quantity of generations so far
    private HashMap<String, String> productionRules; // key-value pairs representing replacements
    private Turtle turtle;

    public LSystem(String axiom, HashMap<String, String> productionRules) {
        this.generation = axiom;
        this.productionRules = productionRules;
        this.numGenerations = 0;
        this.turtle = new Turtle();
    }

    public void render(){
        for (int i = 0; i < generation.length(); i++) {
            turtle.render(generation.charAt(i), numGenerations);
        }
    }

    public void generateNewSentence() {
        StringBuffer nextgen = new StringBuffer();
        for (int i = 0; i < generation.length(); i++) {
            String replacement = productionRules.get(Character.toString(generation.charAt(i)));
            nextgen.append(replacement);
        }
        generation = nextgen.toString();
        numGenerations++;
    }
}

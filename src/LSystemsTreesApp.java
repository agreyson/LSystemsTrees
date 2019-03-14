import processing.core.PApplet;

import java.util.HashMap;

public class LSystemsTreesApp extends PApplet {
    private static LSystemsTreesApp app;
    private LSystem lSystem;
    private int regenerations;

    public static void main(String[] args){
        PApplet.main("LSystemsTreesApp");
    }

    public LSystemsTreesApp(){
        app = this;
        regenerations = 0;
    }

    public void settings(){
        size(600, 1000);
    }

    public void setup() {
        lSystem = get3_2_a();
    }

    public void draw() {
        background(255);
        translate(width/2, height);
        rotate(-PI/2);
        lSystem.render();
        noLoop();
    }

    public void mousePressed() {
        if (regenerations < 5) {
            lSystem.generateNewSentence();
            regenerations++;
            redraw();
        }
    }

    public static LSystemsTreesApp getApp(){
        return app;
    }

    private LSystem get3_2_d(){
        HashMap<String, String> ruleset = new HashMap<String, String>();
        ruleset.put("F", "FF+[+F-F-F]-[-F+F+F]");
        ruleset.put("+", "+");
        ruleset.put("[", "[");
        ruleset.put("]", "]");
        ruleset.put("-", "-");
        LSystem lSystem = new LSystem("F", ruleset);
        return lSystem;
    }

    private LSystem get3_2_a(){
        HashMap<String, String> ruleset = new HashMap<String, String>();
        ruleset.put("F", "F[+F]F[−F]F");
        ruleset.put("+", "+");
        ruleset.put("[", "[");
        ruleset.put("]", "]");
        ruleset.put("-", "-");
        LSystem lSystem = new LSystem("F", ruleset);
        return lSystem;
    }
}

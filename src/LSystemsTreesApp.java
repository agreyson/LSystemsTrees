import processing.core.PApplet;

import java.util.ArrayList;
import java.util.HashMap;

public class LSystemsTreesApp extends PApplet {
    private static LSystemsTreesApp app;
    private ArrayList<LSystem> lSystems;
    private int regenerations;

    public static void main(String[] args){
        PApplet.main("LSystemsTreesApp");
    }

    public LSystemsTreesApp(){
        app = this;
        lSystems = new ArrayList<LSystem>();
        regenerations = 0;
    }

    public void settings(){
        size(1000, 500);
    }

    public void setup(){
        this.lSystems.add(get3_2_d(height/8, color(random(255), random(255), random(255))));
        this.lSystems.add(get3_2_a(height/7, color(random(255), random(255), random(255))));
        this.lSystems.add(get3_2_d(height/5, color(random(255), random(255), random(255))));
        this.lSystems.add(get3_2_a(height/4, color(random(255), random(255), random(255))));
        this.lSystems.add(get3_2_d(height/3, color(random(255), random(255), random(255))));
    }

    public void draw(){
        background(255);
        for (int i = 0; i < lSystems.size(); i++) {
            pushMatrix();
            translate(i*width/lSystems.size() + random(25,50), height);
            rotate(-PI / 2);
            lSystems.get(i).render();
            popMatrix();
        }
        noLoop();
    }

    public void mouseClicked(){
        for (LSystem lSystem: lSystems) {
            lSystem.generateNewSentence();
        }
        regenerations++;
        redraw();
    }

    private LSystem get3_2_d(float height, int color){
        HashMap<String, String> ruleset = new HashMap<String, String>();
        ruleset.put("F", "FF+[+F-F-F]-[-F+F+F]");

        // might need to adjust startingLength w.r.t. canvas size
        LSystem lSystem = new LSystem("F", ruleset, height, radians((float) 22.5), color);
        return lSystem;
    }

    private LSystem get3_2_e(float height, int color){
        HashMap<String, String> ruleset = new HashMap<String, String>();
        ruleset.put("X", "F[+X]F[-X]+X");
        ruleset.put("F", "FF");

        // might need to adjust startingLength w.r.t. canvas size
        LSystem lSystem = new LSystem("X", ruleset, height, radians(20), color);
        return lSystem;
    }

    private LSystem get3_2_b(float height, int color){
        HashMap<String, String> ruleset = new HashMap<String, String>();
        ruleset.put("X", "F-[[X]+X]+F[+FX]-X");
        ruleset.put("F", "FF");

        // might need to adjust startingLength w.r.t. canvas size
        LSystem lSystem = new LSystem("X", ruleset, height, radians((float) 22.5), color);
        return lSystem;
    }

    private LSystem get3_2_a(float height, int color){
        HashMap<String, String> ruleset = new HashMap<String, String>();
        ruleset.put("F", "F[+F]F[-F]F");

        // might need to adjust startingLength w.r.t. canvas size
        LSystem lSystem = new LSystem("F", ruleset, height, radians((float) 25.7), color);
        return lSystem;
    }

    private LSystem get3_2_c(float height, int color){
        HashMap<String, String> ruleset = new HashMap<String, String>();
        ruleset.put("Y", "YFX[+Y][-Y]");
        ruleset.put("X", "X[-FFF][+FFF]FX");
        ruleset.put("F", "F");

        // might need to adjust startingLength w.r.t. canvas size
        LSystem lSystem = new LSystem("Y", ruleset, height, radians((float) 25.7), color);
        return lSystem;
    }


    public static LSystemsTreesApp getApp(){
        return app;
    }
}

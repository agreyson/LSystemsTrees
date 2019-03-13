public class Turtle {
    private float lineLength; // original line length
    private float theta;

    public Turtle() {
        LSystemsTreesApp app = LSystemsTreesApp.getApp();
        this.lineLength = app.height/3;
        this.theta = app.radians(25);
    }

    public void render(char c, int numGenerations) {
        float len = (float) (lineLength * Math.pow(2, -numGenerations));
        LSystemsTreesApp app = LSystemsTreesApp.getApp();
        app.stroke(0, 175);
        if (c == 'F') {
            app.line(0, 0, len, 0);
            app.translate(len, 0);
        } else if (c == 'G'){
            app.translate(len, 0);
        } else if (c == '+') {
            app.rotate(theta);
        } else if (c == '-') {
            app.rotate(-theta);
        }
        else if (c == '[') {
            app.pushMatrix();
        } else if (c == ']') {
            app.popMatrix();
        }
    }
}
import java.awt.*;

public class Button extends Rectangle {
    private String text;
    private static int roundness = 20;
    public static Color colour = new Color(187, 173, 160);
    private static Color textColour = new Color(250, 248, 239);

    // constructor creates ball at given location with given dimensions
    public Button(int x, int y, String t) {
        super(x, y, 125, 50);
        text = t;
    }

    // draws centered text
    private static void drawCenteredText(Graphics g, String s, int x, int y) {
        int w = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
        int h = (int) g.getFontMetrics().getStringBounds(s, g).getHeight();
        int newX = x - w / 2;
        int newY = y + h / 2;

        g.drawString(s, newX, newY);
    }

    // called frequently from the GamePanel class
    // draws the current location of the ball to the screen
    public void draw(Graphics g) {
        g.setColor(colour);
        g.fillRoundRect(x, y, width, height, roundness, roundness);
        g.setFont(new Font("Impact", Font.PLAIN, 18));
        g.setColor(textColour);
        drawCenteredText(g, text, x + width / 2, y + height / 2);
    }

    public boolean checkMouse(int a, int b) {
        System.out.println(x + " " + a + " " + width + " " + y + " " + b + " " + height);
        return (x <= a && a <= x + width && y <= b && b <= y + height);
    }
}
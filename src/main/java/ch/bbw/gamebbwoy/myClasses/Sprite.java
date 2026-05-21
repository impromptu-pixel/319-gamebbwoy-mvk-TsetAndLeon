package ch.bbw.gamebbwoy.myClasses;
import ch.bbw.gamebbwoy.api.PixelColor;
import ch.bbw.gamebbwoy.api.PixelDisplay;

public class Sprite {

    private final int[][] pixels;
    private int x;
    private int y;

    public Sprite(int[][] pixels) {
        this.pixels = pixels;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public void moveUp()    { y--; }
    public void moveDown()  { y++; }
    public void moveLeft()  { x--; }
    public void moveRight() { x++; }

    public void draw(PixelDisplay graphic) {
        draw(graphic, x, y);
    }

    public void draw(PixelDisplay graphic, int x, int y) {
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[row].length; col++) {
                PixelColor color = switch (pixels[row][col]) {
                    case 0 -> PixelColor.WHITE;
                    case 1 -> PixelColor.LOW;
                    case 2 -> PixelColor.HIGH;
                    case 3 -> PixelColor.BLACK;
                    default -> null;
                };
                if (color != null) {
                    graphic.setPixel(x + col, y + row, color);
                }
            }
        }
    }
}
package geometric;

import java.awt.Color;

public class Rectangle extends AbstractShape {
    private int width;
    private int height;

    public Rectangle(Color color, Position center, int width, int height) {
        super(color, center);
        this.width = width;
        this.height = height;
    }

    public Rectangle(Color color, int centerX, int centerY, int width, int height) {
        // super(color, new Position(centerX, centerY));
        // this.width = width;
        // this.height = height;
        this(color, new Position(centerX, centerY), width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return String.format("%s, width: %d, height: %d", super.toString(), width, height);
    }

    private Position getTopLeft() {
        Position center = getCenter();
        int left = center.getX() - width / 2;
        int top = center.getY() - height / 2;
        return new Position(left, top);
    }

    @Override
    public String toSvg() {
        Position topLeft = getTopLeft();
        return String.format("<rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" fill=\"%s\" />", topLeft.getX(), topLeft.getY(), width, height, getColorAsSvg());
    }
}

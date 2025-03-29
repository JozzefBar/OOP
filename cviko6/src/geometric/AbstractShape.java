package geometric;


import java.awt.Color;

public abstract class AbstractShape /* extends Object */ {
    private Color color;
    private Position center;

    public AbstractShape(Color color, Position center) {
        this.color = color;
        this.center = center;
    }

    public Color getColor() {
        return color;
    }

    public Position getCenter() {
        return center;
    }

    public abstract double getArea();

    @Override
    public String toString() {
        return String.format("color: %s, center: %s", color, center);
    }

    public abstract String toSvg();

    protected String getColorAsSvg() {
        return String.format("rgb(%d,%d,%d)", color.getRed(), color.getGreen(), color.getBlue());
    }
}

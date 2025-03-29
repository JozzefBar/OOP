package geometric;

import java.awt.Color;

public class Circle1 {
    private Color color;
    private Position center;
    private int radius;

    public Circle1(Color color, Position center, int radius) {
        this.color = color;
        this.center = center;
        this.radius = radius;
    }

    public Color getColor() {
        return color;
    }

    public Position getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return String.format("color: %s, center: [%s], radius: %d", color/*.toString()*/, center/*.toString()*/, radius);
    }
}

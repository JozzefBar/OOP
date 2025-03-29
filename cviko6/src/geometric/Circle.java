package geometric;

import java.awt.Color;

public class Circle extends AbstractShape {
    private int radius;

    public Circle(Color color, Position center, int radius) {
        super(color, center);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return String.format("%s, radius = %d", super.toString(), radius);
    }

    @Override
    public String toSvg() {
        return String.format("<circle cx=\"%d\" cy=\"%d\" r=\"%d\" fill=\"%s\" />", getCenter().getX(), getCenter().getY(), radius, getColorAsSvg());
    }
}

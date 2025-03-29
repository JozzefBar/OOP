package geometric;

import java.awt.Color;

public class Application {
    public static void main(String[] args) {
        Circle c1 = new Circle(Color.RED, new Position(200, 100), 50);
        Rectangle r1 = new Rectangle(Color.GREEN, 400, 200, 150, 100);
        Rectangle r2 = new Rectangle(Color.BLUE, new Position(200, 300), 200, 50);

        // System.out.println(c1);
        // System.out.println(r1);
        // System.out.println(r2);

        AbstractShape[] shapes = {c1, r1, r2};

        for (AbstractShape s: shapes) {
            System.out.println(s + ", area: " + s.getArea());
        }

        for (AbstractShape s: shapes) {
            System.out.println(s.toSvg());
        }

        Svg svg = new Svg(shapes);
        System.out.println(svg);
    }
}

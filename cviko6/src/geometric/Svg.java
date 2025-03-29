package geometric;

public class Svg {
    private AbstractShape[] shapes;

    public Svg(AbstractShape[] shapes) {
        this.shapes = shapes;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("<svg version=\"1.1\" width=\"500\" height=\"400\" xmlns=\"http://www.w3.org/2000/svg\">\n");
        for (AbstractShape s: shapes) {
            builder.append("    " + s.toSvg() + "\n");
        }
        builder.append("</svg>\n");
        return builder.toString();
    }
}

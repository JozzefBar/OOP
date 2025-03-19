public class Mathematics {
    public static final double PI = 3.14;
    public static final double GOLDEN_RATIO = (1 + Math.sqrt(5.0)) / 2; // https://en.wikipedia.org/wiki/Golden_ratio
    // https://www.elegantthemes.com/blog/design/the-golden-ratio-the-ultimate-guide-to-understanding-and-using-it

    public static void main(String[] args) {
        double radius = 5;
        double circumference = 2 * Mathematics.PI * radius;

        double height = 2;
        double width = height * Mathematics.GOLDEN_RATIO;

        System.out.println(circumference);
        System.out.println(height);
    }
}

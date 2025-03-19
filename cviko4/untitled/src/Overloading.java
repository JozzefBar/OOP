public class Overloading {
    public static void main(String[] args) {
        print(10);
        print("oop");
        print(10);
    }

    public static void print(int integer) {
        System.out.println("integer: " + integer);
    }

    public static void print(String text) {
        System.out.println("text: " + text);
    }
}

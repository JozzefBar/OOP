public class Vynimky {
    public static void main(String[] args) {
//        verzia1();
//        verzia2();
//        verzia3();
//        verzia4();
        verzia5();
    }

    private static void verzia1() {
        int[] array = {10, 20, 30};
//        int element = array[1];
        int element = array[5];
        System.out.println("element = " + element);
    }

    private static void verzia2() {
        String text1 = "prvy text";
        text1 = null;
        String text2 = "druhy text";
        boolean b = text1.equals(text2);
        System.out.println("b = " + b);
    }

    private static void verzia3() {
        int a = 10 / 0;
    }

    private static void verzia4() {
        try {
            int[] array = {10, 20, 30};
            int element = array[1];
//            int element = array[5];
            System.out.println("element = " + element);

            String text1 = "prvy text";
//            text1 = null;
            String text2 = "druhy text";
            boolean b = text1.equals(text2);

            int a = 10 / 0;
        }
        catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("chybny index: " + exception.getMessage());
        }
        catch (NullPointerException exception) {
            System.out.println("nulova referencia: " + exception.getMessage());
        }
        catch (ArithmeticException exception) {
            System.out.println("matematicka chyba: " + exception.getMessage());
        }
    }

    private static void verzia5() {
        try {
            int[] array = {10, 20, 30};
//            int element = array[1];
            int element = array[5];
            System.out.println("element = " + element);
        }
//        catch (ArrayIndexOutOfBoundsException exception) {
//            System.out.println("chybny index: " + exception.getMessage());
//        }
        finally {
            System.out.println("vykona sa vzdy");
        }
        System.out.println("vykona sa len ak nenastala vynimka alebo sa vynimka uz zachytila");
    }
}

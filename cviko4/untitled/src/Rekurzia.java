public class Rekurzia {
    public static void main(String[] args) {
        printTriangle(0, 5);

    }

    private static void printTriangle(int spaces, int height) {
        if (height < 1){
            return;
        }

        printTriangle(spaces + 1, height - 1);

        for (int i = 0; i < spaces; i++){
            System.out.print(" ");
        }
        for (int i = 0; i < 2*height - 1; i++){
            System.out.print("*");
        }
        System.out.println();
    }

}

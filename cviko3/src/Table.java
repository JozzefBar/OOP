public class Table {
    public static void print(char[][] table){
        for (int row = 0; row < table.length; row++ ) {
            for (int column = 0; column < table[row].length; column++) {
                System.out.print(table[row][column] + " ");
            }
            System.out.println();
        }
    }
}

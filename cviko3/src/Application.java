import org.tinylog.Logger;
import java.util.Arrays;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        for(int i = 0; i < args.length; i++) {
            System.out.format("args[%d] = %s\n", i, args[i]);
            Logger.debug("args[{}] = {}", i, args[i]);
        }
        int[] key = {4, 2, 1, 0, 3};
        String message = "Boli ste odhaleny. Utecte zadnym vychodom";

        if(args.length >= 1){
            key = Application.parseKey(args[0]);  //Application sa moze vynechat ked to je v rámci tej istej triedy
        }

        if (args.length >= 2) {
            message = args[1];
        }
        System.out.format("key: %s%n", Arrays.toString(key));
        System.out.format("message: %s%n", message);

        String encrypted = encrypt(message, key);   //tu sme vynechali názov
        System.out.format("encrypted: %s%n", encrypted);
    }

    private static String encrypt(String message, int[] key){
        int numRows = Math.ceilDiv(message.length(), key.length);
        System.out.format("message.length(): %s%n", message.length());
        System.out.format("key.length: %d%n", key.length);
        System.out.format("numRows: %d%n", numRows);

        char[][] table = new char[numRows][key.length];
        int index = 0;
        for(int row = 0; row < numRows; row++){
            for(int column = 0; column < key.length; column++){
                if (index < message.length()){
                    table[row][column] = message.charAt(index);
                    ++index;
                }
                else{
                    table[row][column] = Application.generateRandomLetter(); //'?';
                }
            }
        }

        Table.print(table);

        char[] encrypted = new char[numRows * key.length];
        int encryptedIndex = 0;

        for(int i = 0; i < key.length; i++){
            int column = Vectors.findIndexOfFirst(key, i);
            for(int row = 0; row < numRows; row ++){
                encrypted[encryptedIndex] = table[row][column];
                ++encryptedIndex;
            }
        }

        return new String(encrypted);
    }

    private static char generateRandomLetter(){
        String letters = "abcdefghijklmnopqrstuvwxyz";
        Random generator = new Random();
        int index = generator.nextInt(letters.length());
        return letters.charAt(index);
    }

    private static int [] parseKey(String keyAsString){
        int[] key = new int[keyAsString.length()];
        for (int i = 0; i < keyAsString.length(); i++) {
            char letter = keyAsString.charAt(i);
            int number = Character.getNumericValue(letter);
            key[i] = number;
        }

        return key;
    }
}

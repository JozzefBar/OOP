// https://sk.wikipedia.org/wiki/Transpoz%C3%ADcia_(kryptol%C3%B3gia)
// - Stĺpcová transpozícia

import org.tinylog.Logger; // org.tinylog:tinylog-impl:2.8.0-M1

import java.util.Arrays;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        // vypis argumentov
        for (int i = 0; i < args.length; i++) {
            Logger.debug("args[{}]: {}", i, args[i]); // System.out.format("args[%d]: %s%n", i, args[i]);
        }

        // predvolene hodnoty: kluc  a sprava
        int[] key = {4, 2, 1, 0, 3};
        String message = "Boli ste odhaleny. Utecte zadnym vychodom";

        // nastavenie kluca a spravy ak su definovane ako parametre programu
        if (args.length >= 1) {
            key = parseKey(args[0]);
        }
        if (args.length >= 2) {
            message = args[1];
        }
        Logger.debug("key: {}", Arrays.toString(key)); // System.out.format("key: %s%n", Arrays.toString(key));
        Logger.debug("message: {}", message); // System.out.format("message: %s%n", message);

        // sifrovanie a vypis
        String encrypted = encrypt(message, key);
        Logger.debug("encrypted: {}", encrypted); // System.out.format("encrypted: %s%n", encrypted);
    }

    private static String encrypt(String message, int[] key) {
        final int numRows = Math.ceilDiv(message.length(), key.length);  // Math.ceil message.length() / key.length
        Logger.debug("message.length: {}", message.length()); // System.out.format("message.length: %d%n", message.length());
        Logger.debug("numRow: {}", numRows); // System.out.format("numRow: %d%n", numRows);

        char[][] table = new char[numRows][key.length];
        int index = 0;
        for (int row = 0; row < numRows; ++ row) {
            for (int column = 0; column < key.length; ++ column) {
                if (index < message.length()) {
                    table[row][column] = message.charAt(index);
                }
                else {
                    table[row][column] = generateRandomLetter(); // '?';
                }
                ++ index;
            }
        }

        Tables.print(table);

        char[] encrypted = new char[numRows * key.length];
        int encryptIndex = 0;
        for (int keyIndex = 0; keyIndex < key.length; ++ keyIndex) {
            int column = Vectors.findIndexOfFirst(key, keyIndex);
            for (int row = 0; row < numRows; ++ row) {
                encrypted[encryptIndex] = table[row][column];
                ++ encryptIndex;
            }
        }

        return new String(encrypted);
    }

    private static char generateRandomLetter() {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        // Math.random() vracia double
        Random generator = new Random();
        int index = generator.nextInt(letters.length());
        return letters.charAt(index);
    }

    private static int[] parseKey(String keyAsText) {
        int[] key = new int[keyAsText.length()];
        for (int i = 0; i < keyAsText.length(); ++ i) {
            char letter = keyAsText.charAt(i);
            int number = Character.getNumericValue(letter);
            if (number < 0) {
                Logger.error("parsovanie sifrovacieho kluca"); // System.err.println("chyba: pri parsovani sifrovacieho kluca");
                System.exit(1);
            }
            key[i] = number;
        }
        return key;
    }
}

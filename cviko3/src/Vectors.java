import org.tinylog.Logger;

import java.util.Arrays;

public class Vectors {
    public static int findIndexOfFirst(int[] vector, int value) {
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == value) {
                return i;
            }
        }
        Logger.error("nenajdena hodnota {} vo vektore {}", value, Arrays.toString(vector)); // System.err.format("chyba: nenajdena hodnota %d vo vektore %s%n", value, Arrays.toString(vector));
        System.exit(1);
        return -1;
    }
}

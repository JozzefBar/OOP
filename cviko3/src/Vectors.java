import java.util.Arrays;

public class Vectors {
    public static int findIndexOfFirst(int[] vector, int value){
        for(int i = 0; i < vector.length; i++){
            if(vector[i] == value){
                return i;
            }
        }
        System.err.format("chyba: nenajdene %d v %s%n", value, Arrays.toString(vector));
        System.exit(1);
        return -1;
    }
}

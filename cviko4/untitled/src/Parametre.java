import java.util.Arrays;

public class Parametre {
    public static void main(String[] args) {
        int number = 10;
        String str = "abcd";
        int[] arr = {10, 20, 30};
        StringBuilder builder = new StringBuilder("prvy");
    
        met1(number);
        System.out.println("met1: number = " + number);

        met2(str);
        System.out.println("met2: text = " + str);

        met3(arr);
        System.out.println("met3: arr = " + Arrays.toString(arr));

        met4(builder);
        System.out.println("met3: builder = " + builder.toString());
    }

    private static void met1(int number){
        ++number;
        System.out.println("met1: number = " + number);
    }

    private static void met2(String text){
        text = "pocitac";
        text = new String("pocitac");
        System.out.println("met1: number = " + text);
    }

    private static void met3(int[] array){
        array[1] = 200;
        System.out.println("met3: array = " + Arrays.toString(array));
    }

    private static void met4(StringBuilder b){
        b.append(" druhy");
        System.out.println("met4: b = " + b.toString());
    }

}


public class ForEach {
    public static void main(String[] args) {
        int[] data = {10, 20, 30, 40};
        for(int i = 0; i<data.length; i++){
            System.out.println(i + ": " + data[i] + ", ");
        }
        System.out.println();

        for(int element: data){
            System.out.println(element + ", ");
        }
        System.out.println();
    }
}
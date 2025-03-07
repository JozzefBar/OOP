package random;  //lebo je to v inom packagy

public class Argumenty {
    public static void main(String[] args){
        System.out.println("random.Argumenty:");

        for(int i = 0; i < args.length; i++){
            System.out.println(i + ": " + args[i]);
        }
    }
}

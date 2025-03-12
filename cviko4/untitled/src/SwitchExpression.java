public class SwitchExpression {
    public static void main(String[] args) {
        int option = 1;

        switch(option){
            case 1:
                System.out.println("jeden");
                break;
            case 2:
            case 3:
                System.out.println("dva alebo tri");
                break;
            case 4:
                System.out.println("styri");
                break;
            default:
                System.out.println("ani jeden specialny pripad");
        }

        String text = switch(option){
            case 1 -> "jeden";
            case 2, 3 -> "dva alebo tri";
            case 4 -> "styri";
            default -> "ani jeden specialny pripad";
        };
        System.out.println(text);
    }
}

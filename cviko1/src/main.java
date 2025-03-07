import random.Drawer; //lebo Drawer je v inom packagy, treba inport

public class main {
    public static void main(String[] args) {
        System.out.println("prvý riadok");
        System.out.print("Neodriadkovaný");
        System.out.println("Odriadkovaný");
        printHeader("medved");
        Drawer drawer = new Drawer();
        drawer.drawRectangle(); //lebo to nie je static, treba inicializovat objekt
        //musis vytvorit objekt aby si s nim pracoval
        Drawer.drawRTriangle(); //lebo to je static tak to funguje
        //nemusis vytvarat static
        Drawer drawer2 = new Drawer();
    }

    private static void printHeader(String header){
        System.out.println("==========================");
        System.out.println(header);
        System.out.println("==========================");

        int headerLength = header.length();
        for(int i = 0; i < headerLength; i++){
            System.out.print("=");
        }

        System.out.println();
    }
}
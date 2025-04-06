import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SuboryZapis {
    public static void main(String[] args) {
        // 1. riesenie
        try (FileWriter writer = new FileWriter("subor.txt")) {
            writer.write("zapisujem do suboru");
        }
        catch (IOException exception) {
            System.err.println(exception);
        }

        // 2. riesenie s pouzitim formatovania
        try (FileWriter fileWriter = new FileWriter("subor2");
            PrintWriter printWriter = new PrintWriter(fileWriter)
        ) {
            printWriter.format("produkt: %s, cena: %d", "pocitac", 1000);
        }
        catch (IOException exception) {
            System.out.println(exception);
        }
    }
}

import java.io.IOException;
import java.net.SocketException;
import java.rmi.RemoteException;

public class AutoCloseableExample {
    public static void main(String[] args) {
//        Transmitter t = null;
//        try {
//            t = new Transmitter("https://oop.uim.fei.stuba.sk");
        try (Transmitter t = new Transmitter("https://oop.uim.fei.stuba.sk")) {
            t.send("cau");
            t.send("stretneme sa v jedalni");
            t.send("potom pojdeme na vylet");
//            t.close();
        }
        catch (IOException exception) {
            System.err.println(exception);
        }
//        finally {
//            if (t != null) {
//                t.close();
//            }
//        }
    }
}

class Transmitter implements AutoCloseable {
    public Transmitter(String address) throws SocketException {
        System.out.println("otvaram komunikaciu: " + address);
//        throw new SocketException("chyba pri nadvazovani komunikacie");
    }

    public void send(String message) throws RemoteException {
        System.out.println("vysielam: " + message);
//        throw new RemoteException("chyba pri vysielani");
    }

    public void close() {
        System.out.println("vypinam vysielac");
    }
}

//               IOException
//                  ⃤
//        ┌──────────┴─────────┐
// SocketException      RemoteException

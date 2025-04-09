package vnorenetypy;

public class WindowStarter implements Runnable{
    @Override
    public void run(){
        Window window = new Window();
        window.setVisible(true);
    }
}

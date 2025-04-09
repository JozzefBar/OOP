package vnorenetypy;

import javax.swing.*;

public class VnoreneTypyAplikacia {
    public static void main(String[] args){
        //Window window = new Window();
        //window.setVisible(true);

        WindowStarter starter = new WindowStarter();
        SwingUtilities.invokeLater(starter);
    }
}

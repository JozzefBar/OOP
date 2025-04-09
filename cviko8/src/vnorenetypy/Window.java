package vnorenetypy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame{
    private JLabel label;

    public Window() throws HeadlessException {
        super("Pocitadlo");
        //super.setTitle("Pocitadlo");  //-netreba pisat
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container pane = super.getContentPane();
        BoxLayout layout = new BoxLayout(pane, BoxLayout.Y_AXIS);
        pane.setLayout(layout);

        this.label = new JLabel("pocet stlaceni: 0");
        pane.add(this.label);
        JButton button = new JButton("stlac ma");
        int buttonHeight = button.getPreferredSize().height;
        Dimension buttonSize = new Dimension(Integer.MAX_VALUE, buttonHeight);
        button.setMaximumSize(buttonSize);
        pane.add(button);

        super.pack(); //super.setSize(500,400);

        button.addActionListener(new ClickListener());
    }

    private class ClickListener implements ActionListener{
        private int counter = 0;

        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("tlacidlo stlacene");
            ++counter;
            Window.this.label.setText("pocet stlaceni: " + counter);
            Window.this.pack();
        }
    }
}

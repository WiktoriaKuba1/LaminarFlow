import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Keyboard extends JFrame implements KeyListener {
    JLabel closeLabel = new JLabel("Press the \"x\" key to close me!");
    
    public Keyboard() {
        super("Close me!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        closeLabel.addKeyListener(this);
        closeLabel.setFocusable(true);
        add(closeLabel);
        pack();
        setVisible(true);
    }

    public void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ESCAPE) System.exit(0);
    }

    public void keyPressed(KeyEvent txt) {
        //do nothing
    }

    public void keyReleased(KeyEvent txt) {
        //do nothing
    }
}
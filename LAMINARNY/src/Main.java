import javax.swing.*;

public class Main {
    public static void main(String args[]) {
        JFrame frame = new JFrame(); //nowe okno

        frame.setSize(1700, 1200); //wymiary okna
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //konczy program po nacisnieciu EXIT
        frame.setResizable(false); // brak mozliwosci zmieniania rozmiaru okna

        MainPanel mainPanel = new MainPanel(0, 0, 850, 600); // tworze klase mainPanel
        frame.setContentPane(mainPanel); //ustawiam klase mainPanel jako domyslna w oknie frame
        frame.setVisible(true); // widoczny -> YES
    }
}


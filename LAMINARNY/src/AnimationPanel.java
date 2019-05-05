import javax.swing.*;
import java.awt.*;

public class AnimationPanel extends JPanel {

    private int x;
    private int y;
    private int sc = 40; //szerokosc cylindra
    private int wc = 80; // wysokosc cylindra
    private int rk = 30; // rozmiar kulki
    private int gk = 50; // gestosc kulki
    private Color color;


    public AnimationPanel(int x, int y, int width, int height) {
        this.setLayout(null);
        this.setBounds(x, y, width, height);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));

        g.setColor(new Color(0x66FFC8CF, true));
        g.fillRect(0,0,399,299); // tło


        g.setColor(new Color(0x0500FF));
        g.fillOval(200 - rk/2, y + 20 , rk, rk); // kulka
        g2.setStroke(new BasicStroke(1));

        g2.setStroke(new BasicStroke(3));
        g.setColor(color);
        g.fillRect(200 - sc/2 + 1,280 - wc, sc -1, wc); // ciecz

        g.setColor(new Color(0xFF000000, true));
        g.drawRect(0, 0, 399, 299); // obramówka

        g.drawLine(200 - sc/2,280,200 + sc/2,280); // dol cylindra
        g.drawLine(200 - sc/2,280 - wc,200 - sc/2,280); // bok cylindra
        g.drawLine(200 + sc/2,280 - wc,200 + sc/2,280); // bok cylindra

        g2.setStroke(new BasicStroke(1));
        g.drawLine(200, y + 20 + rk/2, 230, y + rk/2 );
        g.drawLine(230, y + rk/2 , 280, y + rk/2 ); // wskaznik
        g.drawString("a = " + y, 245, y + rk/2 - 3);
        g.drawString("v = " + (y+ 30), 247, y + rk/2 + 12);


    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        if(y + 20 + rk <= 280)
        this.y = y;
    }

    public void setSc(int sc) {
        this.sc = sc;
    }

    public void setWc(int wc) {
        this.wc = wc;
    }

    public void setRk(int rk) {
        this.rk = rk;
    }

    public void setGk(int gk) {
        this.gk = gk;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}


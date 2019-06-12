import javax.swing.*;
import java.awt.*;

public class AnimationPanel extends JPanel {

    private int x;
    private int y;
    private int cylinderWidth = 40; //szerokosc cylindra
    private int cylinderHeight = 80; // wysokosc cylindra
    private int ballRadius = 30; // rozmiar kulki
    private int ballDensity = 50; // gestosc kulki
    private Color color;


    public AnimationPanel(int x, int y, int width, int height) {
        this.setLayout(null);
        this.setBounds(x, y, width, height);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setStroke(new BasicStroke(3)); //ustawienie grubosci linii
        g.setColor(new Color(0x66FFC8CF, true));
        g.fillRect(0,0,900,450); // tło


        g.setColor(new Color(0x0500FF));
        g.fillOval(450 - ballRadius/2, y + 40 , ballRadius, ballRadius); // kulka
        

        g2.setStroke(new BasicStroke(3));
        g.setColor(color);  
        g.fillRect(450 - cylinderWidth/2 + 1,425 - cylinderHeight, cylinderWidth -1, cylinderHeight); // ciecz

        g.setColor(new Color(0xFF000000, true));
        g.drawRect(0, 0, 900, 450); // obramówka

        g.drawLine(450 - cylinderWidth/2,425,450 + cylinderWidth/2,425); // dol cylindra
        g.drawLine(450 - cylinderWidth/2,425 - cylinderHeight,450 - cylinderWidth/2,425); // bok cylindra
        g.drawLine(450 + cylinderWidth/2,425 - cylinderHeight,450 + cylinderWidth/2,425); // bok cylindra

        g2.setStroke(new BasicStroke(1));
        g.drawLine(450, y + 40 + ballRadius/2, 525, y + ballRadius/2 );
        g.drawLine(525, y + ballRadius/2 , 600, y + ballRadius/2 ); // wskaznik
        g.drawString("a = " + y, 540, y + ballRadius/2 -3);
        g.drawString("v = " + (y+ 30), 540, y + ballRadius/2 +11);
    }

    
    
    
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        if(y + 20 + ballRadius <= 405)
        this.y = y;
    }

    public void setCylinderWidth(int sc) {
        this.cylinderWidth = sc;
    }

    public void setCylinderHeight(int wc) {
        this.cylinderHeight = wc;
    }

    public void setBallRadius(int rk) {
        this.ballRadius = rk;
    }

    public void setBallDensity(int gk) {
        this.ballDensity = gk;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}


import javax.swing.*;
import java.awt.*;

public class MainPanelPl extends JPanel {

    private AnimationPanel animationPanel;
    private JComboBox planetList;
    private JComboBox liquidList;
    private JButton newButton;
    private JButton openButton;
    private JButton saveButton;
    private JButton startButton;
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JTextField field4;


    String[] planets = {"Ziemia", "Mars", "KsiÍŅyś", "Wenus", "Jowisz", "Uran"};
    String[] liquids = {"woda", "oliwa", "gliceryna", "miůd", "rtÍś", "krew"};
	private JTextField field11;
	private JTextField field22;
	private JTextField field33;
	private JTextField field44;

    public MainPanelPl(int x, int y, int width, int height) {
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        this.setBackground(new Color(124, 180, 111));

        this.animationPanel = new AnimationPanel(50, 50, 400, 300);

        this.planetList = new JComboBox(planets);
        this.planetList.setBounds(600,80,150,35);

        this.liquidList = new JComboBox(liquids);
        this.liquidList.setBounds(600,180,150,35);

        this.newButton = new JButton("NEW");
        this.newButton.setBounds(50, 370, 100, 50);

        this.openButton = new JButton("OPEN");
        this.openButton.setBounds(200, 370, 100, 50);

        this.saveButton = new JButton("SAVE");
        this.saveButton.setBounds(350, 370, 100, 50);

        this.startButton = new JButton("START / STOP");
        this.startButton.setBounds(600, 450, 150, 80);

        //////////////////////////////////////////
        this.field11 = new JTextField("   ");
        this.field11.setBounds(90, 473, 92, 22);

        this.field22 = new JTextField("   ");
        this.field22.setBounds(90, 523, 92, 22);

        this.field33 = new JTextField("   ");
        this.field33.setBounds(287, 473, 92, 22);

        this.field44 = new JTextField("   ");
        this.field44.setBounds(287, 523, 92, 22);
        
        //////////////////////////////////////////
        this.field1 = new JTextField("   ");
        this.field1.setBounds(575, 290, 92, 22);

        this.field2 = new JTextField("   ");
        this.field2.setBounds(575, 350, 92, 22);

        this.field3 = new JTextField("   ");
        this.field3.setBounds(695, 290, 92, 22);

        this.field4 = new JTextField("   ");
        this.field4.setBounds(695, 350, 92, 22);

        this.add(animationPanel);
        this.add(planetList);
        this.add(liquidList);
        this.add(newButton);
        this.add(openButton);
        this.add(saveButton);
        this.add(startButton);
        this.add(field1);
        this.add(field2);
        this.add(field3);
        this.add(field4);
        this.add(field11);
        this.add(field22);
        this.add(field33);
        this.add(field44);


    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g); //potrzebne do nadpisania obrazu
        Graphics2D g2 = (Graphics2D) g; //magane do nast linii/precyzyjne rysowanie prostokatow
        g2.setStroke(new BasicStroke(3)); //grubosc linii prostokata 

        g2.setStroke(new BasicStroke(1));   //
        g2.setFont(new Font("Sans Serif", Font.BOLD, 12));  //pogrubiona czcionka

        g2.drawString("Gestosc wybranego plynu:", 54, 464);
        g2.drawString("Lepkosc wybranego plynu:", 54, 514);
        g2.drawString("Predkosc graniczna:", 254, 464);
        g2.drawString("Czas relaksacji:", 254, 514);

        g2.drawString("Promien kulki:", 575, 284);
        g2.drawString("Promien cylindra:", 575, 344);
        g2.drawString("Gestosc kulki:", 695, 284);
        g2.drawString("Wysokosc:", 695, 344);

        g2.drawString("Lista cialā niebieskich:", 603, 70);
        g2.drawString("Lista wyboru cieczy:", 603, 170);

    }

}

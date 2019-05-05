import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {

    private AnimationPanel animationPanel;
    private JComboBox planetList;
    private JComboBox liquidList;
    private JButton newButton;
    private JButton openButton;
    private JButton saveButton;
    private JButton startButton;
    private JButton addValuesButton;
    private JButton langButton;
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JTextField field4;
    private int xx = 0;
    private int yy = 0;
    private boolean isStartPressed = false;
    private boolean isExperinetStarted = false;
    private boolean langPL = true;
    private Color color;

    String[] planets = {"Earth", "Mars", "Moon", "Venus", "Jupiter", "Uranus"};
    String[] liquids = {"water", "olive oil", "glycerine", "honey", "quicksilver"}; //deklaracja wszystkich zmiennych

    public MainPanel(int x, int y, int width, int height) {
        this.setLayout(null); // kierunek rozkladu elementow
        this.setBounds(x, y, width, height); // ustawiam wymiary okna
        this.setBackground(new Color(124, 180, 111)); // kolor tla

        this.animationPanel = new AnimationPanel(50, 50, 400, 300); // wywolanie konstruktora AnimationPanel (tworzymy kalse)

        this.planetList = new JComboBox(planets);
        this.planetList.setBounds(1150,80,150,35);

        this.liquidList = new JComboBox(liquids);
        this.liquidList.setBounds(1150,180,150,35);

        this.newButton = new JButton("NEW");
        this.newButton.setBounds(50, 550, 100, 50);

        this.addValuesButton = new JButton("ADD VALUES");
        this.addValuesButton.setBounds(1125, 380, 215, 20);

        this.openButton = new JButton("OPEN");
        this.openButton.setBounds(200, 550, 100, 50);

        this.saveButton = new JButton("SAVE");
        this.saveButton.setBounds(350, 550, 100, 50);

        this.startButton = new JButton("START / STOP");
        this.startButton.setBounds(1150, 450, 150, 80);

        this.langButton = new JButton("PL/EN");
        this.langButton.setBounds(1350, 10, 80, 20);

        this.field1 = new JTextField();
        this.field1.setBounds(1100, 290, 92, 22);

        this.field2 = new JTextField();
        this.field2.setBounds(1250, 350, 92, 22);

        this.field3 = new JTextField();
        this.field3.setBounds(1250, 290, 92, 22);

        this.field4 = new JTextField();
        this.field4.setBounds(1100, 350, 92, 22);

        this.add(animationPanel);
        this.add(planetList);
        this.add(addValuesButton);
        this.add(liquidList);
        this.add(newButton);
        this.add(openButton);
        this.add(saveButton);
        this.add(startButton);
        this.add(langButton);
        this.add(field1);
        this.add(field2);
        this.add(field3);
        this.add(field4);                                           //dodanie WSZYSTKICH elementów (przyciski etc);
        this.addValuesButton.addActionListener(this);           // dodanie action listnera do przycisku add values

        this.startButton.addActionListener( e -> {
            this.isStartPressed = !isStartPressed;
            this.isExperinetStarted = true; // po nacisnieciu przycisku start zmienia wartosc logiczna na przeciwna (potrzebne do dzialania niektorych metod w programie)
                }
                );

        this.langButton.addActionListener( e -> {
                    this.langPL = !langPL;
                }
        );


        Thread thread = new Thread(() -> { //tworze nowy watek
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (isStartPressed) {
                    xx++;
                    yy++;
                    this.animationPanel.setX(xx);
                    this.animationPanel.setY(yy);
                    repaint();
                }
                if(!isExperinetStarted) {
                    switch ((String) this.liquidList.getSelectedItem()) {
                        case "water":
                            color = new Color(0, 156, 255, 151);
                            break;
                        case "olive oil":
                            color = new Color(29, 72, 17, 147);
                            break;
                        case "glycerine":
                            color = new Color(183, 255, 212, 147);
                            break;
                        case "honey":
                            color = new Color(251, 203, 21, 147);
                            break;
                        case "quicksilver":
                            color = new Color(66, 67, 70, 147);
                            break;
                        default:
                            color = new Color(255, 0, 40, 151);
                            break;                                              // tworze nowy kolor w zaleznosci od wybranej cieczy
                    }
                    this.animationPanel.setColor(color);                        // wysylam kolor do klasy AnimationPanel
                    repaint();
                }
            }
        });
        thread.start();

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));

        g2.drawRect(50, 635, 200, 20);
        g2.drawRect(50, 685, 200, 20);
        g2.drawRect(250, 635, 200, 20);
        g2.drawRect(250, 685, 200, 20);
        g2.drawRect(1250, 290, 92, 22);
        g2.drawRect(1100, 350, 92, 22);
        g2.drawRect(1100, 290, 92, 22);
        g2.drawRect(1250, 350, 92, 22);
        g2.setStroke(new BasicStroke(1));
        g2.setFont(new Font("Sans Serif", Font.BOLD, 12));

        g2.drawString("Gęstość wybranego płynu:", 54, 650);
        g2.drawString("Lepkość wybranego płynu:", 54, 700);
        g2.drawString("Prędkość graniczna:", 254, 650);
        g2.drawString("Czas relaksacji:", 254, 700);

        g2.drawString("Promień kulki:", 1100, 284);
        g2.drawString("Promień cylindra:", 1100, 344);
        g2.drawString("Gęstość kulki:", 1250, 284);
        g2.drawString("Wysokość:", 1250, 344);

        g2.drawString("Lista ciał niebieskich:", 1150, 70);
        g2.drawString("Lista wyboru cieczy:", 1150, 170);


    }

    public void actionPerformed(ActionEvent e) {
        if(!isExperinetStarted && e.getSource() == addValuesButton) { // jezeli symulacja nie wystartowala i nacisne add values button to pobieram dane z okienek (promien kulki etc.)
            String s1 = field1.getText();                              // program sie wysypuje jak zostawimy puste pola i nacisniemy add values ( w przyszlosci naprawie to)
            String s2 = field2.getText();
            String s3 = field3.getText();
            String s4 = field4.getText(); // przypisuje do stringa wartosc z okienka
            int a = Integer.parseInt(s1);
            int b = Integer.parseInt(s2);
            int c = Integer.parseInt(s3);
            int d = Integer.parseInt(s4); // zamieniam wartosc z okienka (string) na int
            this.animationPanel.setRk(a);
            this.animationPanel.setGk(c);
            this.animationPanel.setSc(b);
            this.animationPanel.setWc(d); // wysylam wartosc do klasy AnimationPanel
            repaint();                    // odswiezam obraz

        }
    }
}

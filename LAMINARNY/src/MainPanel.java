import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainPanel extends JPanel implements ActionListener {


	private String[] inputArray;
    private AnimationPanel animationPanel;
    private JComboBox planetList;
    private JComboBox liquidList;
    private JButton newButton;
    private JButton openButton;
    private JButton saveButton;
    private JButton startButton;
    private JButton addValuesButton;
    private JButton langButton;
    private JTextField ballRadiusField;
    private JTextField cylinderRadiusField;
    private JTextField ballDensityField;
    private JTextField cylinderHeightField;
    private int xx = 0;
    private int yy = 0;
    private boolean isStartPressed = false;
    private boolean isExperinetStarted = false;
    private boolean langPL = true;
    private Color color;
    private double acceleration=9.81;
    private double density=999.8;
    private double stickiness=0.00089;
    private double velocity;
    private double time;
    private JMenuBar menuBar;
    private JMenu menu, menu2;

    private Locale enLocale = new Locale("en", "US");
    private Locale plLocale = new Locale("pl", "PL");
    
    private ResourceBundle strings = ResourceBundle.getBundle("Strings", enLocale);  //domyslnie ustawia ang
    String[] planets = {strings.getString("planet1"), strings.getString("planet2"), strings.getString("planet3"), strings.getString("planet4"), strings.getString("planet5"), strings.getString("planet6")};
    String[] liquids = {strings.getString("liquid1"), strings.getString("liquid2"), strings.getString("liquid3"), strings.getString("liquid4"), strings.getString("liquid5")}; 
    //deklaracja wszystkich zmiennych
    
    
    public MainPanel(int x, int y, int width, int height) {
        this.setLayout(null); // kierunek rozkladu elementow
        this.setBounds(x, y, width, height); // ustawiam wymiary okna
        this.setBackground(new Color(124, 180, 111)); // kolor tla

        this.animationPanel = new AnimationPanel(50, 50, 900, 450); // wywolanie konstruktora AnimationPanel (tworzymy kalse)

        
        this.planetList = new JComboBox<>();
        this.planetList.setModel(new DefaultComboBoxModel(planets));
        this.planetList.setBounds(1150,80,150,35);
        this.planetList.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		switch(planetList.getSelectedIndex()) {
        		case 0: 
        			acceleration = 9.81;
        			break;
        		case 1: 
        			acceleration = 3.70;
        			break;
        		case 2:
        			acceleration = 1.622;
        			break;
        		case 3:
        			acceleration = 8.9;
        			break;
        		case 4:
        			acceleration = 23.1;
        			break;
        		case 5:
        			acceleration = 8.7;
        			break;
        		default:
        			acceleration = 9.81;
        			break;
        		}
        	}
        });

        
        this.liquidList = new JComboBox<>();
        this.liquidList.setModel(new DefaultComboBoxModel(liquids));
        this.liquidList.setBounds(1150,180,150,35);

        this.newButton = new JButton(strings.getString("newButton"));
        this.newButton.setBounds(50, 550, 100, 50);

        this.addValuesButton = new JButton(strings.getString("addValuesButton"));
        this.addValuesButton.setBounds(1125, 380, 215, 20);

        this.openButton = new JButton(strings.getString("openButton"));
        this.openButton.setBounds(200, 550, 100, 50);

        this.saveButton = new JButton(strings.getString("saveButton"));
        this.saveButton.setBounds(350, 550, 100, 50);

        this.startButton = new JButton("START / STOP");
        this.startButton.setBounds(1150, 450, 150, 80);

        this.langButton = new JButton("PL/EN");
        this.langButton.setBounds(1350, 10, 80, 20);

        this.ballRadiusField = new JTextField();
        this.ballRadiusField.setBounds(1100, 290, 92, 22);

        this.cylinderRadiusField = new JTextField();
        this.cylinderRadiusField.setBounds(1250, 350, 92, 22);

        this.ballDensityField = new JTextField();
        this.ballDensityField.setBounds(1250, 290, 92, 22);

        this.cylinderHeightField = new JTextField();
        this.cylinderHeightField.setBounds(1100, 350, 92, 22);

        this.add(animationPanel);
        this.add(planetList);
        this.add(addValuesButton);
        this.add(liquidList);
        this.add(newButton);
        this.add(openButton);
        this.add(saveButton);
        this.add(startButton);
        this.add(langButton);
        this.add(ballRadiusField);
        this.add(cylinderRadiusField);
        this.add(ballDensityField);
        this.add(cylinderHeightField);            //dodanie WSZYSTKICH elementów (przyciski etc);
        this.addValuesButton.addActionListener(this);// dodanie action listnera do przycisku add values

        
        this.startButton.addActionListener( e -> {
            this.isStartPressed = !isStartPressed;
            this.isExperinetStarted = true; // po nacisnieciu przycisku start zmienia wartosc logiczna na przeciwna (potrzebne do dzialania niektorych metod w programie)
                }
                );

        this.langButton.addActionListener( e -> {
                    this.langPL = !langPL;
                    if(this.langPL==false) {
        	        	strings = ResourceBundle.getBundle("Strings", plLocale);
        	        	
        	        	liquids[0]=strings.getString("liquid1");
        	        	liquids[1]=strings.getString("liquid2");
        	        	liquids[2]=strings.getString("liquid3");
        	        	liquids[3]=strings.getString("liquid4");
        	        	liquids[4]=strings.getString("liquid5");
        	        	liquidList.setModel(new DefaultComboBoxModel(liquids));  //ustawia wg kolejnosci 
        	        	
        	        	planets[0]=strings.getString("planet1");
        	        	planets[1]=strings.getString("planet2");
        	        	planets[2]=strings.getString("planet3");
        	        	planets[3]=strings.getString("planet4");
        	        	planets[4]=strings.getString("planet5");
        	        	planets[5]=strings.getString("planet6");
        	        	planetList.setModel(new DefaultComboBoxModel(planets));
        	        	
        	        	newButton.setText(strings.getString("newButton"));
        	        	saveButton.setText(strings.getString("saveButton"));
        	        	openButton.setText(strings.getString("openButton"));
        	        	addValuesButton.setText(strings.getString("addValuesButton"));
                	} else {
                		strings = ResourceBundle.getBundle("Strings", enLocale);
        	        	
        	        	liquids[0]=strings.getString("liquid1");
        	        	liquids[1]=strings.getString("liquid2");
        	        	liquids[2]=strings.getString("liquid3");
        	        	liquids[3]=strings.getString("liquid4");
        	        	liquids[4]=strings.getString("liquid5");
        	        	liquidList.setModel(new DefaultComboBoxModel(liquids));
        	        	
        	        	planets[0]=strings.getString("planet1");
        	        	planets[1]=strings.getString("planet2");
        	        	planets[2]=strings.getString("planet3");
        	        	planets[3]=strings.getString("planet4");
        	        	planets[4]=strings.getString("planet5");
        	        	planets[5]=strings.getString("planet6");
        	        	planetList.setModel(new DefaultComboBoxModel(planets));
        	        	 
        	        	newButton.setText(strings.getString("newButton"));
        	        	saveButton.setText(strings.getString("saveButton"));
        	        	openButton.setText(strings.getString("openButton"));
        	        	addValuesButton.setText(strings.getString("addValuesButton"));
                	}
                
                	
                });
        
        

        Thread thread = new Thread(() -> { //tworze nowy watek
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (isStartPressed) {
                	//xx++;
                	yy++;
                    // this.animationPanel.setX(xx);
                    this.animationPanel.setY(yy);
                    repaint();
                }
                
                
                
                if(!isExperinetStarted) {
                    switch (this.liquidList.getSelectedIndex()) {
                        case 0:
                            color = new Color(0, 156, 255, 151);
                            density = 999.8;
                            stickiness = 0.00089;
                            break;
                        case 1:
                            color = new Color(29, 72, 17, 147);
                            density = 920;
                            stickiness = 2;
                            break;
                        case 2:
                            color = new Color(183, 255, 212, 147);
                            density = 1260;
                            stickiness = 0.934;
                            break;
                        case 3:
                            color = new Color(251, 203, 21, 147);
                            density = 1400;
                            stickiness = 6;
                            break;
                        case 4:
                            color = new Color(66, 67, 70, 147);
                            density = 13546;
                            stickiness = 0.001554;
                            break;
                        default:
                            color = new Color(0, 156, 255, 151);
                            density = 999.8;
                            stickiness = 0.00089;
                            break;                           // tworze nowy kolor w zaleznosci od wybranej cieczy
                    }
                    this.animationPanel.setColor(color);         // wysylam kolor do klasy AnimationPanel
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

        g2.drawString(strings.getString("liquidDensity") + " " + density, 54, 650);//wypisuje Gestosc wybranego plynu
        g2.drawString(strings.getString("liquidStickiness") + " " + stickiness, 54, 700);//wypisuje Lepkosc wybranego plynu
        g2.drawString(strings.getString("terminalVelocity") + " " + velocity, 254, 650);//wypisuje Predkosc graniczna
        g2.drawString(strings.getString("relaxationTime") + " " + time, 254, 700);//wypisuje Czas relaksacji

        g2.drawString(strings.getString("ballRadius"), 1100, 284);//rysuje string Promien kulki nad 
        g2.drawString(strings.getString("cylinderHeight"), 1100, 344);//Promien cylindra nad 
        g2.drawString(strings.getString("ballDensity"), 1250, 284);//Gestosc kulki nad 
        g2.drawString(strings.getString("cylinderRadius"), 1250, 344);//Wysokosc nad 

        g2.drawString(strings.getString("astralBodiesList"), 1150, 70);//Lista cial niebieskich nad 
        g2.drawString(strings.getString("liquidList"), 1150, 170);//Lista wyboru cieczy nad 
    }
    

    public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
        case "save": {
            File workingDirectory = new File(System.getProperty("user.dir"));
            JFileChooser chooser = new JFileChooser(workingDirectory);
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Text files only", "txt");
            chooser.setFileFilter(filter);
            int returnValue = chooser.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                try {
                    File outputFile = new File(chooser.getSelectedFile().getAbsolutePath() + ".txt");
                    OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(outputFile), Charset.forName("UTF-8").newEncoder());
                    osw.write("Ball radius: " + ballRadiusField.getText() + " \n");
                    osw.write("Ball density: " + ballDensityField.getText()+ " \n");
                    osw.write("Cylinder radius: " + cylinderRadiusField.getText() + " \n");
                    osw.write("Cylinder height: " + cylinderHeightField.getText() + " \n");
                    osw.close();
                } catch (IOException error) {
                    error.printStackTrace();
                }
            }
            break;
        }
        case "open": {
            File workingDirectory = new File(System.getProperty("user.dir"));
            JFileChooser chooser = new JFileChooser(workingDirectory);
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Text files only", "txt");
            chooser.setFileFilter(filter);
            int returnValue = chooser.showOpenDialog(null);
            /*
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                try {
                	
                    String text = "";
                    
                    File inputFile = new File(chooser.getSelectedFile().getAbsolutePath());
                    InputStreamReader isr = new InputStreamReader((inputFile), Charset.forName("UTF-8").newDecoder());
                    int data = isr.read();
                    while (data != -1) {
                        char theChar = (char) data;
                        text += theChar;
                        data = isr.read();
                    }
                    isr.close();
//                    inputArray = text.split("\\s");
                    
                } catch (IOException error) {
                    error.printStackTrace();
                }
               
            }
            break;
            */
        }
        case "new": {
        	
        	
        	break;
        }
        
        case "add": {
        	 if(!isExperinetStarted && e.getSource() == addValuesButton) { // jezeli symulacja nie wystartowala i nacisne add values button to pobieram dane z okienek (promien kulki etc.)
                 String s1 = ballRadiusField.getText();                              // program sie wysypuje jak zostawimy puste pola i nacisniemy add values (w przyszlosci naprawie to)
                 String s2 = cylinderRadiusField.getText();
                 String s3 = ballDensityField.getText();
                 String s4 = cylinderHeightField.getText(); // przypisuje do stringa wartosc z okienka
                 int a = Integer.parseInt(s1);
                 int b = Integer.parseInt(s2);
                 int c = Integer.parseInt(s3);
                 int d = Integer.parseInt(s4); // zamieniam wartosc z okienka (string) na int
                 this.animationPanel.setBallRadius(a);
                 this.animationPanel.setBallDensity(c);
                 this.animationPanel.setCylinderHeight(b);
                 this.animationPanel.setCylinderWidth(d); // wysylam wartosc do klasy AnimationPanel
                 repaint();                    // odswiezam obraz
             
             calculateVelocity();
             calculateTime();
             }
        	
        	break;
        }
	}
	}
    
    public double calculateTime() {
		double ballRadius = Double.parseDouble(ballRadiusField.getText());
        double ballDensity =  Double.parseDouble(ballDensityField.getText());
        double ballVolume = (4/3)*(Math.PI*Math.pow(ballRadius/2, 3));
		
		time = (ballVolume*ballDensity)/(3*Math.PI*stickiness*ballRadius);
		return time;
	}

	public double calculateVelocity() {
		double ballRadius = Double.parseDouble(ballRadiusField.getText());
        double cylinderRadius =  Double.parseDouble(cylinderRadiusField.getText());
        double ballDensity =  Double.parseDouble(ballDensityField.getText());
        double cylinderHeight =  Double.parseDouble(cylinderHeightField.getText());
		double velocityBellow;
		double velocityTop;
		double time;
		
		velocityTop = ((1/2)*ballRadius*ballRadius*acceleration*(ballDensity-density));
		velocityBellow = 9*stickiness*(1+2.4*(ballRadius/(2*cylinderRadius)))*(1+3.1*(ballRadius/(2*cylinderHeight)));
		velocity = velocityTop/velocityBellow;
		
		return velocity;
	}
	

}

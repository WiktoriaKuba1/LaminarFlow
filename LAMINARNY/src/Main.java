


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.*;

public class Main implements KeyListener {
    public static void main(String args[]) {
    	SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				JFrame frame = new JFrame(); //nowe okno
//    	    JFrame.setDefaultLookAndFeelDecorated(true);
//				JMenuBar menuBar = new JMenuBar();
//				JMenu fileMenu = new JMenu("File");
//				JMenuItem openFile = new JMenuItem("Open");
//				JMenuItem saveFile = new JMenuItem("Save");
//				JMenuItem newFile = new JMenuItem("New");
//				openFile.setActionCommand("open");
//				openFile.addActionListener(null);
//				saveFile.setActionCommand("save");
//				saveFile.addActionListener(null);
//				newFile.setActionCommand("new");
//				newFile.addActionListener(null);
//	     
//				fileMenu.add(openFile);
//				fileMenu.add(saveFile);
//				fileMenu.add(newFile);
//				menuBar.add(fileMenu);
//				frame.setJMenuBar(menuBar);
			
        
				
				frame.setSize(850, 600); //wymiary okna
				frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //konczy program po nacisnieciu EXIT
				frame.setResizable(false); // brak mozliwosci zmieniania rozmiaru okna

				MainPanel mainPanel = new MainPanel(0, 0, 850, 600); // tworze klase mainPanel
				frame.setContentPane(mainPanel); //ustawiam klase mainPanel jako domyslna w oknie frame
				frame.setVisible(true); // widoczny -> YES
//				ExecutorService exec = Executors.newSingleThreadExecutor();
//				exec.execute(null);
				
			}
		});
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyChar();
		if(key == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		switch (e.getActionCommand()) {
//        case "save": {
//            File workingDirectory = new File(System.getProperty("user.dir"));
//            JFileChooser chooser = new JFileChooser(workingDirectory);
//            FileNameExtensionFilter filter = new FileNameExtensionFilter(
//                    "Text files only", "txt");
//            chooser.setFileFilter(filter);
//            int returnValue = chooser.showSaveDialog(null);
//            if (returnValue == JFileChooser.APPROVE_OPTION) {
//                try {
//                    File outputFile = new File(chooser.getSelectedFile().getAbsolutePath() + ".txt");
//                    OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(outputFile), Charset.forName("UTF-8").newEncoder());
//                    
//                    osw.close();
//                } catch (IOException error) {
//                    error.printStackTrace();
//                }
//            }
//            break;
//        }
//        case "open": {
//            File workingDirectory = new File(System.getProperty("user.dir"));
//            JFileChooser chooser = new JFileChooser(workingDirectory);
//            FileNameExtensionFilter filter = new FileNameExtensionFilter(
//                    "Text files only", "txt");
//            chooser.setFileFilter(filter);
//            int returnValue = chooser.showOpenDialog(null);
//            if (returnValue == JFileChooser.APPROVE_OPTION) {
//                try {
//                    String text = "";
//                    File inputFile = new File(chooser.getSelectedFile().getAbsolutePath());
//                    InputStreamReader isr = new InputStreamReader(new FileInputStream(inputFile), Charset.forName("UTF-8").newDecoder());
//                    int data = isr.read();
//                    while (data != -1) {
//                        char theChar = (char) data;
//                        text += theChar;
//                        data = isr.read();
//                    }
//                    isr.close();
////                    inputArray = text.split("\\s");
//                } catch (IOException error) {
//                    error.printStackTrace();
//                }
//            }
//            break;
//        }
//        case "new": {
//        	
//        	
//        	break;
//        }
//		
//	}
//}
}

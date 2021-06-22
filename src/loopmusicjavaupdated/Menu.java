package loopmusicjavaupdated;

import java.awt.*;
import java.awt.event.*;
import javax.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Pokemon Card Match Memory Game");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(640,480);
		JPanel panel = new JPanel();
		frame.add(panel);
		JButton button1 = new JButton("Easy Mode");
		button1.setSize(300, 300);
		button1.setLocation(10, 10);
		panel.add(button1);
		button1.addActionListener(new Action());
        frame.setLocationRelativeTo(null);
		
        /*
   		String filepath = ("C:\\Users\\aaron\\eclipse-workspace\\CardMatchMemoryGame\\src\\Poketheme.wav");
		musicStuff musicObject = new musicStuff();
		musicObject.playMusic(filepath);
		*/
}
	
		public static class Action implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
				/*
				JFrame frame2 = new JFrame("Clicked");
				frame2.setVisible(true);
				frame2.setSize(200,200);
				JLabel label = new JLabel("You clicked me!");
				JPanel panel = new JPanel();
				frame2.add(panel);
				panel.add(label);
				*/
                GUI.run();
			}
		}
		
		
	}
	
	
	

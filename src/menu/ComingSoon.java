package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComingSoon extends JFrame {
	public ComingSoon(){
		this.setSize(540,378);
		JButton okButton = new closingButton("Coming Soon");
		okButton.setOpaque(true);
		this.setContentPane(okButton);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);
		this.setFocusableWindowState(false);
		okButton.addActionListener(new Closing());
		this.setVisible(true);
	}
	
	public class closingButton extends JButton implements MouseListener {
		public closingButton(String name){
			super(name);
			this.setFont(new Font("Times New Roman",Font.ITALIC,30));
			this.setBackground(Color.BLACK);
			this.addMouseListener(this);
		}
		
		public void mouseClicked(MouseEvent event){}

		public void mouseEntered(MouseEvent event){}

		public void mouseExited(MouseEvent event){}

		public void mousePressed(MouseEvent event) { }

		public void mouseReleased(MouseEvent event) { }  

	}
	
	public class Closing implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			ComingSoon.this.dispose();
		}
	}
}

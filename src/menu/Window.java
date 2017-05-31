package menu;

import java.awt.Color; 

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Window extends JFrame {
  
	int i = 0;
	CardLayout cardLayout = new CardLayout();
	JPanel menu = new JPanel();

	public Window() {
		Background screenMenu = ScreenMenu.getScreenMenu(this);
		this.setContentPane(screenMenu);

	}
}
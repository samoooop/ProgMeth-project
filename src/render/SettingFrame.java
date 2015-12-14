package render;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.Configuration;
import util.DrawingUtility;

public class SettingFrame extends JFrame {
	public SettingFrame(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 JPanel set = new JPanel();
		 set.setPreferredSize(new Dimension(600, 400));
		 set.setLayout(new BorderLayout());
	  	
		
	//north
		   JLabel title = new JLabel("SETTING", JLabel.CENTER);
			title.setFont(DrawingUtility.drawFont);
			title.setBackground(Color.black);
			title.setOpaque(true);
			title.setForeground(Color.gray);
			this.add(title, BorderLayout.NORTH);
	
	//set screensize
			JPanel sizepanel = new JPanel();
	
			sizepanel.setLayout(new FlowLayout (FlowLayout.CENTER, 15, 3));
			sizepanel.setBackground(Color.gray);
	
			JLabel w = new JLabel("WIDTH");
			JLabel h = new JLabel("HEIGHT");
			JTextField wt = new JTextField(String.format("%s", Configuration.screenWidth));
			wt.setPreferredSize(new Dimension(100,20));
			JTextField ht = new JTextField(String.format("%s", Configuration.screenHeight));
			ht.setPreferredSize(new Dimension(100,20));
			JButton apply = new JButton("Apply");
			JPanel a1 = new JPanel();
			JPanel a2 = new JPanel();
			a1.add(w);
			a1.add(wt);
			a2.add(h);
			a2.add(ht);
	
	        sizepanel.add(a1);
	        sizepanel.add(a2);
	
	        sizepanel.add(apply);
	
	this.add(sizepanel, BorderLayout.CENTER);
	//easy normal hard select
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}

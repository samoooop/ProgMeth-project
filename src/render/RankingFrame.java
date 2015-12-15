package render;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import util.Configuration;
import util.DrawingUtility;


public class  RankingFrame extends JFrame{
	public RankingFrame(String rank) {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		 JLabel title = new JLabel("======= Top 10 players =======", JLabel.CENTER);
			title.setPreferredSize(new Dimension(800, 100));
		   title.setFont(DrawingUtility.drawFont);
			title.setBackground(Color.black);
			title.setOpaque(true);
			title.setForeground(Color.gray);
	     	this.add(title, BorderLayout.NORTH);
		
		
		
		   
		
		  JPanel top10 = new JPanel();
		  top10.setPreferredSize(new Dimension(800, 800));
		  top10.setLayout(new BorderLayout());
		  Label taking = new Label();
		  taking.setFont(DrawingUtility.drawFont);
		  
		  taking.setText(rank);
		  
		  
		  
		  
		  top10.add(taking);
		  this.add(top10,BorderLayout.CENTER);
		   this.pack();
		   this.setVisible(true);
		   this.setResizable(false);
	}

	

}

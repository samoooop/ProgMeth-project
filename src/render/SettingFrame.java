package render;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.Configuration;
import util.DrawingUtility;

@SuppressWarnings("serial")
public class SettingFrame extends JFrame {
	public SettingFrame(){
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Setting"); 
		JPanel set = new JPanel();
		 set.setPreferredSize(new Dimension(600,200));
		 set.setLayout(new BorderLayout());
	  	
		
	//north
		   JLabel title = new JLabel("SETTING", JLabel.CENTER);
			title.setPreferredSize(new Dimension(600, 100));
		   title.setFont(DrawingUtility.drawFont);
			title.setBackground(Color.black);
			title.setOpaque(true);
			title.setForeground(Color.gray);
			set.add(title, BorderLayout.NORTH);
	
	//set screensize
			JPanel sizepanel = new JPanel();
			sizepanel.setPreferredSize(new Dimension(600, 50));
			sizepanel.setLayout(new FlowLayout (FlowLayout.CENTER, 15, 8));
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
	         
	        
	        
	        
	        
	        
	        
	        
	        
	       set.add(sizepanel, BorderLayout.CENTER);
	//easy normal hard select
	
	JPanel setdifficult = new JPanel();
	sizepanel.setPreferredSize(new Dimension(600, 50));
	setdifficult.setLayout(new FlowLayout (FlowLayout.CENTER, 15,20));
	/*
	 JRadioButton easy = new JRadioButton("easy");
     JRadioButton normal = new JRadioButton("normal");
     JRadioButton hard = new JRadioButton("hard");
     ButtonGroup bG = new ButtonGroup();
     bG.add(easy);
     bG.add(normal);
     bG.add(hard);
    
     setdifficult.add(easy);
     setdifficult.add(normal);
     setdifficult.add(hard);
    */
	
	set.add(setdifficult,BorderLayout.SOUTH);
	
	
	this.add(set);
	this.pack();
	this.setVisible(true);
	this.setResizable(false);
	apply.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//GameManager.resizeScreen();
			try {
				Configuration.screenWidth = Integer.parseInt(wt.getText());
				Configuration.screenHeight = Integer.parseInt(ht.getText());
				String text = "Apply\n";
				text += "screenWidth = "+ wt.getText() +"\n"+"screenHeight = "+ ht.getText() ;
                JOptionPane.showMessageDialog(null, text);
                
                Title.wind.setSizeImidiate();
			     
			}
			
			        catch(NumberFormatException e1){
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			                  }
	 	             
		
		
		
		
		}
	             
     
     
     
     });

	
	}

}

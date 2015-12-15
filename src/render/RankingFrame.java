package render;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.DrawingUtility;
import util.HighScoreUtility;
import util.HighScoreUtility.HighScoreRecord;

@SuppressWarnings("serial")
public class RankingFrame extends JFrame {
	public RankingFrame() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JLabel title = new JLabel("== Top 10 players ==", JLabel.CENTER);
		title.setPreferredSize(new Dimension(900, 100));
		title.setFont(DrawingUtility.drawFont);
		title.setBackground(Color.black);
		title.setOpaque(true);
		title.setForeground(Color.gray);
		this.add(title, BorderLayout.NORTH);

		JPanel top10 = new JPanel();
		top10.setPreferredSize(new Dimension(800, 800));
		top10.setLayout(new BoxLayout(top10,BoxLayout.Y_AXIS));
		top10.setBackground(Color.BLACK);
		Label taking = new Label();
		taking.setFont(DrawingUtility.drawFont.deriveFont(20f));
		String msg = "";
		int rank = 1;
		for (HighScoreRecord record : HighScoreUtility.highScoreRecord) {
			top10.add(rankLabel(record,""+rank),BorderLayout.CENTER);
			rank ++;
		}

		taking.setText(msg);

		top10.add(taking);
		this.add(top10, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
	}
	private JLabel rankLabel(HighScoreRecord r,String rank){
		JLabel l = new JLabel("Rank "+rank + " " +r.getRecord(),JLabel.CENTER);
		l.setPreferredSize(new Dimension(900,75));
		l.setFont(DrawingUtility.drawFont.deriveFont(40f));
		l.setBackground(Color.black);
		l.setOpaque(true);
		l.setForeground(Color.gray);
		return l;
	}
}
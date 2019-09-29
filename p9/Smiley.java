import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
class DrawSmiley extends JPanel
{
	protected void paintComponent(Graphics gg)
	{
		super.paintComponent(gg);
		Graphics2D g = (Graphics2D)gg;
		g.setStroke(new BasicStroke(5));
		g.setColor(Color.YELLOW);
		g.fill(new Ellipse2D.Float(50,30,80,80));
		g.setColor(Color.black);
		g.draw(new Ellipse2D.Float(45,25,90,90));
		g.setStroke(new BasicStroke(10));
		g.draw(new Line2D.Float(75,65,75,65));
		g.draw(new Line2D.Float(105,65,105,65));
		g.draw(new Arc2D.Float(65,65,60,35,-70,-60,Arc2D.OPEN));
	}
}

class Smiley {
	JLabel jlab;
	DrawSmiley ds;
	Smiley()
	{
		JFrame jf = new JFrame("Swing Smiley");
		//jf.getContentPane().setBackground(Color.black);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(new BorderLayout());
		jf.setSize(200,200);
		jlab = new JLabel("Smiley :-)");
		jf.add(jlab,BorderLayout.NORTH);
		ds = new DrawSmiley();
		jf.add(ds);
		jf.setVisible(true);
	}
	public static void main(String []args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run() 
			{new Smiley();}
		});
	}
}
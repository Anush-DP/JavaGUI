import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

class DrawShapePanel extends JPanel
{
	ArrayList<Shape> rectList;
	DrawShapePanel()
	{
		rectList = new ArrayList<Shape>();
	}
	protected void paintComponent(Graphics shapeGraphics)
	{
		super.paintComponent(shapeGraphics);
		Graphics2D mainGraphics = (Graphics2D) shapeGraphics;
		mainGraphics.setStroke(new BasicStroke(5));
		
		//rectList.add(new Rectangle(100,110,100,100));
		for(Shape rect: rectList)
		{
			int r=(int)(Math.random()*256);
			int g=(int)(Math.random()*256);
			int b=(int)(Math.random()*256);
			mainGraphics.setColor(new Color(r,g,b));
			mainGraphics.draw(rect);
		}
	}
	public void addRectangle(){
		int x = (int)(Math.random()*getWidth());
		int y = (int)(Math.random()*getHeight());
		int width = (int)(Math.random()*100);
		int height = (int)(Math.random()*100);
		rectList.add(new RoundRectangle2D.Float(x,y,width,height,15,15));
		repaint();
	}
	public void addSquare(){
		int x = (int)(Math.random()*getWidth());
		int y = (int)(Math.random()*getHeight());
		int width = (int)(Math.random()*100);
		rectList.add(new RoundRectangle2D.Float(x,y,width,width,15,15));
		repaint();
	}

}

class SquaresAndRectangles {
	DrawShapePanel dp;
	JButton addRect;
	JButton addSqr;
	JLabel jlab;
	SquaresAndRectangles()
	{
		JFrame jf = new JFrame("Drawing Squares And Rectangles");
		//jf.getContentPane().setBackground(Color.black);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(new BorderLayout());
		jf.setSize(800,800);
		dp = new DrawShapePanel();
		dp.setBackground(Color.DARK_GRAY);
		jlab = new JLabel("This program adds random rounded Rectangles and Squares");

		addRect = new JButton("Add Rectangle");
		addRect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				dp.addRectangle();
			}
		});
		addSqr = new JButton("Add Square");
		addSqr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				dp.addSquare();
			}
		});
		jf.add(jlab,BorderLayout.NORTH);
		dp.add(addRect);
		dp.add(addSqr);
		jf.add(dp);
		jf.setVisible(true);
	}
	public static void main(String []args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run() 
			{new SquaresAndRectangles();}
		});
	}
}
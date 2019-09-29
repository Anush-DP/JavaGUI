import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

class DrawShapePanel extends JPanel
{
	ArrayList<Shape> shapeList;
	DrawShapePanel()
	{
		shapeList = new ArrayList<Shape>();
	}
	protected void paintComponent(Graphics shapeGraphics)
	{
		super.paintComponent(shapeGraphics);
		Graphics2D mainGraphics = (Graphics2D) shapeGraphics;
		mainGraphics.setStroke(new BasicStroke(5));
		
		//rectList.add(new Rectangle(100,110,100,100));
		for(Shape shape: shapeList)
		{
			int r=(int)(Math.random()*256);
			int g=(int)(Math.random()*256);
			int b=(int)(Math.random()*256);
			mainGraphics.setColor(new Color(r,g,b));
			mainGraphics.draw(shape);
		}
	}
	public void addRectangle(){
		int x = (int)(Math.random()*getWidth());
		int y = (int)(Math.random()*getHeight());
		int width = (int)(Math.random()*100);
		int height = (int)(Math.random()*100);
		shapeList.add(new Rectangle(x,y,width,height));
		repaint();
	}
	public void addSquare(){
		int x = (int)(Math.random()*getWidth());
		int y = (int)(Math.random()*getHeight());
		int width = (int)(Math.random()*100);
		shapeList.add(new Rectangle(x,y,width,width));
		repaint();
	}
	public void addLine(){
		int x = (int)(Math.random()*800);
		int y = (int)(Math.random()*800);
		int x2 = (int)(Math.random()*800);
		int y2 = (int)(Math.random()*800);
		shapeList.add(new Line2D.Float(x,y,x2,y2));
		repaint();
	}
	public void addArc(){
		int x = (int)(Math.random()*getWidth());
		int y = (int)(Math.random()*getHeight());
		int width = (int)(Math.random()*100);
		int height = (int)(Math.random()*100);
		int st = (int)(Math.random()*360);
		int ex = (int)(Math.random()*360);
		shapeList.add(new Arc2D.Float(x,y,height,width,st,ex,Arc2D.OPEN));
		repaint();
	}
	public void addOval(){
		int x = (int)(Math.random()*getWidth());
		int y = (int)(Math.random()*getHeight());
		int width = (int)(Math.random()*100);
		int height = (int)(Math.random()*100);
		shapeList.add(new Ellipse2D.Float(x,y,width,height));
		repaint();
	}
	public void addTr(){
		int xP[] = new int[3];
		int yP[] = new int[3];
		xP[0] = (int)(Math.random()*getWidth());
		xP[1] = (int)(Math.random()*getWidth());
		xP[2] = (int)(Math.random()*getWidth());
		yP[0] = (int)(Math.random()*getHeight());
		yP[1] = (int)(Math.random()*getHeight());
		yP[2] = (int)(Math.random()*getHeight());
		Polygon triangle = new Polygon(xP,yP,3);
		shapeList.add(triangle);
		repaint();
	}
	public void clearScreen()
	{
		shapeList.clear();
		repaint();
	}

}

class Shapes {
	DrawShapePanel dp;
	JButton addRect;
	JButton addSqr,addLine,addArc,addTr,addOval,clearScreen;
	JLabel jlab;
	Shapes()
	{
		JFrame jf = new JFrame("Drawing Shapes");
		//jf.getContentPane().setBackground(Color.black);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(new BorderLayout());
		jf.setSize(800,800);
		dp = new DrawShapePanel();
		dp.setBackground(Color.DARK_GRAY);
			
		setupViews();
		setupListeners();

		jf.add(jlab,BorderLayout.NORTH);
		dp.add(addRect);
		dp.add(addSqr);
		dp.add(addLine);
		dp.add(addTr);
		dp.add(addArc);
		dp.add(addOval);
		dp.add(clearScreen);
		
		jf.add(dp);
		jf.setVisible(true);
	}
	private void setupViews()
	{
		jlab = new JLabel("This program adds random shapes");
		addRect = new JButton("Add Rectangle");
		addSqr = new JButton("Add Square");
		addLine = new JButton("Add Line");
		addArc = new JButton("Add Arc");
		addTr = new JButton("Add Triangle");
		addOval = new JButton("Add Oval");
		clearScreen = new JButton("Clear Screen");
	}
	private void setupListeners()
	{
		clearScreen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				dp.clearScreen();
			}
		});
		addRect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				dp.addRectangle();
			}
		});
		
		addSqr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				dp.addSquare();
			}
		});
		addLine.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				dp.addLine();
			}
		});
		addArc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				dp.addArc();
			}
		});
		addTr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				dp.addTr();
			}
		});
		addOval.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				dp.addOval();
			}
		});

	}
	public static void main(String []args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run() 
			{new Shapes();}
		});
	}
}
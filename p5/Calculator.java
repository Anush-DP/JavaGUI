import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

class TextInputPanel extends JPanel
{
	
}
class ButtonPanel extends JPanel
{

}
class Calculator {
	TextInputPanel tp;
	ButtonPanel bp;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
	JButton plus,minus,prod,div,dpoint,equals,clear,del;
	JLabel jlab;
	Calculator()
	{
		JFrame jf = new JFrame("Swing Calculator");
		//jf.getContentPane().setBackground(Color.black);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(new BorderLayout());
		jf.setSize(800,800);
			
		setupViews();
		setupListeners();

		jf.add(jlab,BorderLayout.NORTH);
		
		jf.add(tp,BorderLayout.NORTH);
		jf.add(bp,BorderLayout.SOUTH);
		jf.setVisible(true);
	}
	private void setupViews()
	{
		
	}
	private void setupListeners()
	{
		clearScreen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				dp.clearScreen();
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
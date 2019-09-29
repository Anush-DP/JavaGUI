import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.applet.*;
/*
<applet code="DateProg" width=180 height=100>
</applet>
*/
public class DateProg extends Applet implements Runnable
{
	Date date;
	Formatter fmt;
	Thread t;
	boolean flag;
	String day,month,time,d;
	public void init()
	{
		setBackground(Color.DARK_GRAY);
		setForeground(Color.WHITE);
	}
	public void start()
	{
		t=new Thread(this);
		flag=false;
		t.start();
	}
	public void run()
	{
		for(;;)
		{
			try{
				date=new Date();
				fmt=new Formatter();
				fmt.format("%tA",date);
				day=fmt.toString();
				fmt=new Formatter();
				fmt.format("%tB",date);
				month=fmt.toString();
				fmt=new Formatter();
				fmt.format("%tr",date);
				time=fmt.toString();
				fmt=new Formatter();
				fmt.format("%tD",date);
				d=fmt.toString();
				repaint();
				if(flag)
					break;
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
		}
	}
	public void stop()
	{
		flag=true;
		t=null;
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.drawString("Date : "+d,30,20);
		g.drawString("Day : "+day,30,40);
		g.drawString("Month : "+month,30,60);
		g.drawString("Time : "+time,30,80);
		showStatus("My Digital Clock");
	}
}
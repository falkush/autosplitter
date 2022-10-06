//made by falkush
//https://twitch.tv/falkush
package autosplitter;
import java.util.Random;
import java.awt.AWTException;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.MouseInfo;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class setup extends JPanel implements KeyListener {
	public char c;
	public int ci=1;
	static public int[] c1 = {0,0}; 
	static public int[] c2 = {0,0}; 
	public static int ti=0;
	static public boolean flag=false;

	
	public setup() {
        this.setPreferredSize(new Dimension(290, 200));
        addKeyListener(this);
    }
	
	public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        g.drawString("-Open OBS", 10, 10);
        g.drawString("-Put this window visible on top with focus", 10, 30);
        g.drawString("-Press q on those two corners of canvas (interior)", 10, 50);
        g.drawString("1-------", 10, 75);
        g.drawString("|          |", 10, 90);
        g.drawString("|          |", 10, 100);
        g.drawString("-------2", 13, 115);
        g.drawString("-Press w on each transition screens", 10, 150);
        
        g.drawString("c1:("+c1[0]+","+c1[1]+")", 75, 85);
        g.drawString("c2:("+c2[0]+","+c2[1]+")", 75, 105);
        
        g.setColor(new Color(11,1,98));
        g.drawString("made by falkush", 190, 190);
        
        if(ci<3) {
        g.setColor(Color.RED);
        g.drawString("Please select all corners first", 60, 170);
        }
        else if(ti==0)
        {
        g.setColor(new Color(16,200,16));
        g.drawString("Select Reset Screen (w)", 80, 170);
        }
        else if(ti==1)
        {
        	g.setColor(new Color(16,200,16));
            g.drawString("Select Start Screen (w)", 80, 170);
        }
        else
        {
        	g.setColor(new Color(16,200,16));
            g.drawString("Select Split number: " + (ti-1), 80, 170);
        }
    }

    public void keyPressed(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }
    public void keyTyped(KeyEvent e) {
        c = e.getKeyChar();
        if(c=='q' && ci==1)
        {
        	c1[0]=MouseInfo.getPointerInfo().getLocation().x;
        	c1[1]= MouseInfo.getPointerInfo().getLocation().y;
        	ci++;
        } else if (c=='q' && ci==2) 
        {
        	c2[0]=MouseInfo.getPointerInfo().getLocation().x;
        	c2[1]= MouseInfo.getPointerInfo().getLocation().y;
        	ci++;
        }
        
        if(c=='w' && ci==3)
        {
        	ti++;
        	flag=true;
        }
        repaint();
    }
	
	public static void main(String args[]) throws AWTException, InterruptedException
    {
		int rx,ry,cr,cg,cb,i;
		Random random = new Random();
		Color color;
		final Robot robot = new Robot();
	    //robot.setAutoDelay(200);
		JFrame f = new JFrame();
        f.getContentPane().add(new setup());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        
	    while(true)
	    {
	    	if(flag)
	    	{
	    		for(i=0;i<5;i++) {
	    		rx=random.nextInt(c2[0] + 1 - c1[0]) + c1[0];
	    		ry=random.nextInt(c2[1] + 1 - c1[1]) + c1[1];
	    		color = robot.getPixelColor(rx, ry);
	    		cr=color.getRed();
	    		cg=color.getGreen();
	    		cb=color.getBlue();
	    		
	    		System.out.println("pos["+(ti-1)+"]["+i+"]=new int[] {"+rx+","+ry+","+cr+","+cg+","+cb+"};");
	    		}
	    		flag=false;
	    	}
        Thread.sleep(10);
	    }
    }
	
}

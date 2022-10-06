//made by falkush
//https://twitch.tv/falkush
package autosplitter;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JFrame;

public class autosplit {
	public static void main(String args[]) throws AWTException, InterruptedException
	{
		int[][][] pos = new int[100][5][5];

		/// insert pos here ///
		pos[0][0]=new int[] {1313,531,128,129,184};
		pos[0][1]=new int[] {1336,601,31,15,0};
		pos[0][2]=new int[] {1362,650,151,110,0};
		pos[0][3]=new int[] {1328,532,127,129,177};
		pos[0][4]=new int[] {1294,545,18,20,34};
		
		for(int j=1;j<=14;j++) {
		pos[j][0]=new int[] {688,101,36,15,0};
		pos[j][1]=new int[] {686,101,36,16,0};
		pos[j][2]=new int[] {712,97,37,15,2};
		pos[j][3]=new int[] {700,96,34,15,0};
		pos[j][4]=new int[] {682,96,39,18,0};
		}
		
		pos[15][0]=new int[] {955,333,255,255,255};
		pos[15][1]=new int[] {964,333,255,255,255};
		pos[15][2]=new int[] {987,321,255,255,255};
		pos[15][3]=new int[] {985,327,255,255,255};
		pos[15][4]=new int[] {1029,369,255,255,255};
		/// end pos ///////////
		
		
		
		
		
		Color color;
		int rx,ry,cr,cg,cb,i,ti=1;
		boolean runf=false;
		final Robot robot = new Robot();
        
	    while(true)
	    {
	    	for(i=0;i<5;i++)
	    	{
	    		color = robot.getPixelColor(pos[ti][i][0], pos[ti][i][1]);
	    		cr=color.getRed();
	    		cg=color.getGreen();
	    		cb=color.getBlue();
	    		if(compare(cr,cg,cb,pos[ti][i][2],pos[ti][i][3],pos[ti][i][4])) i=6;
	    	}
	    	if(i==5)
	    	{
	    		if(ti==1) runf=true;
	    		robot.keyPress(KeyEvent.VK_NUMPAD1);
	    		robot.keyRelease(KeyEvent.VK_NUMPAD1);
	    		Thread.sleep(8000);
	    		System.out.println(ti-1);
	    		i=0;
	    		ti++;
	    	}
	    	else if(runf) //reset
	    	{
	    		for(i=0;i<5;i++)
		    	{
		    		color = robot.getPixelColor(pos[0][i][0], pos[0][i][1]);
		    		cr=color.getRed();
		    		cg=color.getGreen();
		    		cb=color.getBlue();
		    		if(compare(cr,cg,cb,pos[0][i][2],pos[0][i][3],pos[0][i][4])) i=6;
		    	}
	    		if(i==5)
	    		{
	    			runf=false;
	    			System.out.println("reset");
	    			robot.keyPress(KeyEvent.VK_NUMPAD3);
	    			robot.keyRelease(KeyEvent.VK_NUMPAD3);
	    			ti=1;
	    			i=0;
	    		}
	    	}
	    	Thread.sleep(10);
	    }
    }
	
	public static boolean compare(int a, int b, int c, int d, int e, int f)
	{
		boolean flag=false;
		if(Math.abs(a-d)>13) flag=true;
		if(Math.abs(b-e)>13) flag=true;
		if(Math.abs(c-f)>13) flag=true;
		return flag;
	}
}

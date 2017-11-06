
import java.awt.*;
import javax.swing.*;  
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.event.*;


public class Operation {

	public void Sum(List<JButton> buttonlist,JButton button)
	{
		   Random random=new Random(); 
		   Integer a =random.nextInt(9);
		   int i=0;
		   for(JButton butt:buttonlist)
		    {  
		      Random rand=new Random();
		      Integer c=rand.nextInt(100);
		      butt.setText(c.toString());
		      if(i==a)
		      { 
		    	  int x=Integer.parseInt(butt.getText());
		    	  int y=rand.nextInt(x);
		    	  int z=x-y;
		    	  button.setText(z+"+"+y+"=?");
		    	  
		      }
		     
		      i++;
		    }
		
	}
	
	public void Substract(List<JButton> buttonlist,JButton button)
	 { 
		
		Random random = new Random();
		   Integer a =random.nextInt(9);
		   int i=0;
		   for(JButton butt:buttonlist)
		    {  
		      Random rand = new Random();
		      Integer c=rand.nextInt(100);
		      butt.setText(c.toString());
		      if(i==a)
		      { 
		    	  int x = Integer.parseInt(butt.getText());
		    	  int y = rand.nextInt(x);
		    	  int z = x+y;
		    	  button.setText(z+"-"+y+"=?");
		    	  
		      }
		     
		      i++;
		    }
	 }
	
	public void Divide(List<JButton> buttonlist,JButton button)
	{ 
		
		Random random=new Random(); 
		   Integer a =random.nextInt(9);
		   int i=0;
		   for(JButton butt:buttonlist)
		    {  
		      Random rand=new Random();
		      Integer c=rand.nextInt(20);
		      butt.setText(c.toString());
		      if(i==a)
		      { 
		    	  int x=Integer.parseInt(butt.getText());
		    	  int y=rand.nextInt(x);
		    	  int z=x*y;
		    	  button.setText(z+"/"+y+"=?");
		    	  
		      }
		     
		      i++;
		    }
	 }
	
	public void Multiply(List<JButton> buttonlist,JButton button)
	{
		Random random=new Random(); 
		   int a =random.nextInt(9);
		   int i=0;
		   for(JButton butt:buttonlist)
		    {  
		      Random rand=new Random();
		      Integer c=rand.nextInt(100);
		      butt.setText(c.toString());
		      if(i==a)
		      { 
		    	  int x=Integer.parseInt(butt.getText());
		    	  int y=rand.nextInt(x);
		    	  if(y==0)
		    	   {
		    	    y=1;
		    	   }
		    	  while(x%y!=0)
		    	  {
		    	   
		    		 y--;  
		    	  }
		    	  int z=x/y;
		    	  button.setText(z+"*"+y+"=?");
		    	  
		      }
		     
		      i++;
		    }
	}
	
}

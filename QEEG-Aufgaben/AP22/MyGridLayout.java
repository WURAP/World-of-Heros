
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;  
import java.util.*;
import java.util.List;


public class MyGridLayout{  
JFrame f; 
ArrayList<JButton> buttonList;



MyGridLayout(){  
	 
        
    f=new JFrame();  
    JPanel p1=new JPanel(new GridLayout(1,1));
    JPanel p2=new JPanel(new GridLayout(3,3));
    JPanel p3=new JPanel(new GridLayout(1,2));
    JButton question=new JButton("1+2");
        p1.add(question);
    

    JButton answer1=new JButton("1");
    p2.add(answer1);
    JButton answer2=new JButton("2");
    p2.add(answer2);
    JButton answer3=new JButton("3");
    p2.add(answer3);
    JButton answer4=new JButton("4");
    p2.add(answer4);
    JButton answer5=new JButton("5");
    p2.add(answer5);
    JButton answer6=new JButton("6");
    p2.add(answer6);
    JButton answer7=new JButton("7");
    p2.add(answer7);
    JButton answer8=new JButton("8");
    p2.add(answer8);
    JButton answer9=new JButton("9");
    p2.add(answer9);
    JButton Next=new JButton("Next");
   
    p3.add(Next);
   List<JButton> buttonList=new ArrayList<>();

   buttonList.add(answer1);
   buttonList.add(answer2);
   buttonList.add(answer3);
   buttonList.add(answer4);
   buttonList.add(answer5);
   buttonList.add(answer6);
   buttonList.add(answer7);
   buttonList.add(answer8);
   buttonList.add(answer9);
  Random random = new Random();
  int a=random.nextInt(4);
  Operation op=new Operation();
  switch(a)
  {
  case 0:
	 op.Sum(buttonList,question); 
	 break;
  case 1:
		 op.Substract(buttonList,question); 
		 break;
  case 2:
		 op.Divide(buttonList,question); 
		 break;
  case 3:
		 op.Multiply(buttonList,question); 
		 break;
  }
  Next.addActionListener(new NextAction(question,buttonList));

   for(JButton button:buttonList)
   {
		 button.addActionListener(new Correct(button,question));
   }
   
    
    f.add(p1,BorderLayout.NORTH);
    f.add(p2);
    f.add(p3,BorderLayout.SOUTH);
   
    f.pack();
    f.setVisible(true);
    Font d =new Font("Arial",Font.PLAIN,25);
    question.setFont(d);
    
    for(JButton button:buttonList)
    {
    	
    	button.setFont(d);
    	
    }
    Next.setFont(d);
   }
    

public static void main(String[] args) {  
    new MyGridLayout();  
}  
}  
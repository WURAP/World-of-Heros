import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;



public class TrafficLight extends JFrame {

      Signal green = new Signal(Color.green);
      Signal yellow = new Signal(Color.yellow);
      Signal red = new Signal(Color.red);
      
    public TrafficLight(){
        super("Traffic Light");
        getContentPane().setLayout(new GridLayout(2, 1));

        green.turnOn(false);
        yellow.turnOn(false);
        red.turnOn(true);
        JPanel p1 = new JPanel(new GridLayout(3,1));
        p1.add(red);
        p1.add(yellow);
        p1.add(green);

        getContentPane().add(p1);
        pack();
        }

    class Signal extends JPanel{
        Color on;
        int radius = 40;
        int border = 10;
        boolean change;
        Signal(Color color){
            on = color;
            change = true;
        }
        public void turnOn(boolean a){
            change = a;
            repaint();        
        }
        public Dimension getPreferredSize(){
            int size = (radius+border)*2;
            return new Dimension( size, size );
        }
        public void paintComponent(Graphics g){
            g.setColor( Color.black );
            g.fillRect(0,0,getWidth(),getHeight());
            if (change){
                g.setColor( on );
            } else {
                g.setColor( on.darker().darker().darker() );
            }
            g.fillOval( border,border,2*radius,2*radius );
        }
    }

    
    public double[] convert(String path,String delim, int column) {
    	double arr[];
    	arr = new double[999999];

        String csvFile = path;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = delim;

        try {

            br = new BufferedReader(new FileReader(csvFile));
            int k=0;

            while ((line = br.readLine()) != null) {
            	
               
                String[] table = line.split(cvsSplitBy);
                arr[k]= Double.parseDouble(table[column]);
                k++;
               

    

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    

		
		return arr;
		
	}
    
    
 public void testen(double[] impedanceArray)  {
	 int n = 0;
	 
	 double sum=0;
        
        for(int i = 0; i < impedanceArray.length; i++){
        	n++;

            
              double kadjustedImpedance = impedanceArray[i]/2.0;
              sum += kadjustedImpedance;
              
              if (n%200==0) {
              
              
              double adjustedImpedance = sum/200;
          
            
              if(adjustedImpedance <= 0){ //no data yet...
                  green.turnOn(false);            
                  yellow.turnOn(false);
                  red.turnOn(true);
              } else if(adjustedImpedance > 0 && adjustedImpedance <= 10){ //very good signal quality
                  red.turnOn(false);            
                  yellow.turnOn(false);
                  green.turnOn(true);
              } else if(adjustedImpedance > 10 && adjustedImpedance <= 50){ //good signal quality
                  red.turnOn(false);            
                  yellow.turnOn(false);
                  green.turnOn(true);
              } else if(adjustedImpedance > 50 && adjustedImpedance <= 100){ //acceptable signal quality
                  yellow.turnOn(true);            
                  green.turnOn(false);
                  red.turnOn(false);
              } else if(adjustedImpedance > 100 && adjustedImpedance <= 150){ //questionable signal quality
                  yellow.turnOn(true);            
                  green.turnOn(false);
                  red.turnOn(false);
              } else if(adjustedImpedance > 150){ //bad signal quality
                  green.turnOn(false);            
                  yellow.turnOn(false);
                  red.turnOn(true);
                  
        }
              sum =0;
              try {
              Thread.sleep(500);}
              
        catch(InterruptedException e){
            System.out.println("thread 2 interrupted");
        }}
    
 }
    
  
}  
 
 



public static void main(String[] args){

    TrafficLight tl = new TrafficLight();        
    tl.setVisible(true);
    
    String delimiter= ";";
    String filePath = "/Users/GanglionGut.csv";
    String filePath2 = "/Users/GB.csv";
    String filePath1 = "/Users/GanglionSGut1234.csv";
    
    double[] TA= tl.convert(filePath, delimiter , 1);
    double[] TA1= tl.convert(filePath1, delimiter , 1);
    double[] TA2= tl.convert(filePath2, delimiter , 1);
            
            

          
            tl.testen(TA2);
}   }



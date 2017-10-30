public class XY
{
	
public static int punktevergeben(double[] tatsaechlicheFluglinie, double[] vorhandeneFluglinie) 

{

    double Bandbreite; 
    int Punkte = 0;
    
 for (int i=0; i<vorhandeneFluglinie.length; i++) {
 Bandbreite = (1/vorhandeneFluglinie[i]) * tatsaechlicheFluglinie[i];
 
 Bandbreite = Math.abs(Bandbreite - 1);
 
 if  (Bandbreite < 0.2 && Bandbreite >= 0) {
     Punkte += 3;
     }
 else if (Bandbreite < 0.5 && Bandbreite >= 0.2) {
      Punkte += 2;
      }
 else if (Bandbreite < 0.8 && Bandbreite >= 0.5) {
      Punkte += 1;
  }
  else {
      Punkte = 0;
   }


 } 
  return Punkte; 

}


public static void main  (String[] args) {

	
	double [] x = {1,2,3,4,5};
	double [] y = {1,2,3,4,5};
	int z;
	
	z = punktevergeben(x,y);
	System.out.println(z);
			
}}
package stat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Player {
	private int ID;
	private List<Performance> performance = new ArrayList<Performance>();

	
		public void addPerformance(int performanceScore) 
		{
			Performance temp = new Performance();
				temp.date = new Date();
				temp.score = performanceScore;
			this.performance.add(temp);			
		}
		
		
		
		//FOR TESTING ONLY
		public void addPerformancesRandom(int count) {
			
			for (int i=0; i<count; i++) 
			{
				Performance temp = new Performance();
				Date currentTime = new Date();
				
				long tempL = currentTime.getTime()-(long)(Math.random()*200)*24*60*60*1000;			//subtracts (0.00 to 1.00 * 200) days
				temp.date = new Date(tempL);
				temp.score = (int)(Math.random()*100);
				this.performance.add(temp);	
			}
		}
		
		
		public Performance[] getPerformance(){
			Performance[] temp = new Performance[performance.size()];
			return this.performance.toArray(temp);
		}
		
		
}

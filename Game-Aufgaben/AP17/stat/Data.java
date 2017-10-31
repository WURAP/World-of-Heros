package stat;

import java.awt.Point;
import org.primefaces.model.chart.LineChartSeries;


public class Data
{
	

	private static boolean random = Config.randomValues;
	private static int randomArrayLength = Config.randomArrayLength;
		
	private static Point[] preset = generateRandom(randomArrayLength);
	private static Point[] actual = generateRandom(randomArrayLength);
	

	
	//PRESET FLIGHT PATH
    public static Point[] getPreset() 
    {
    	if (random == true) 
    	{
            Point[] preset = generateRandom(randomArrayLength);
            return preset;
    	}
    	   	else {return preset;}
    }

    
    //ACTUAL FLIGHT PATH
    public static Point[] getActual() 
    {
    	if (random == true) 
    	{
            Point[] actual = generateRandom(randomArrayLength);
            return actual;
    	}
    	else {return actual;}	
    }
    
    
	//PERFORMANCE LINE
    public static Point[] getPerformance() {
    Point[] performance = new Point[Data.getPreset().length]; 										//Calculates Performance Score    
    
    	for (int i = 0; i<performance.length; i++) 
	    {
	        Point temp = new Point();
	    	temp.x = i;
	    	temp.y = (Config.yMax/2 - Math.abs(Data.getPreset()[i].y - Data.getActual()[i].y));
	    		if (temp.y<0) {temp.y=0;}															//If performance score is below 0, set it to 0
	    	performance[i] = temp;
	    }
    return performance;
    }
    
    
    //AVERAGE PERFORMANCE LINE
    public static Point[] getAverage() {
	    Point [] averageSet = new Point [Data.getPerformance().length];
	    int total = 0;
	    
	        for (int i = 0; i < Data.getPerformance().length; i++) 
	        {
	        	total = total + Data.getPerformance()[i].y;
	    	}
	        
	    int average = total/Data.getPerformance().length;
	    
		    for (int i = 0; i < averageSet.length; i++) 
		    {
		    	Point temp = new Point();
			    	temp.x = i;
			    	temp.y = average;
		    	averageSet[i]=temp;
		    }
	return averageSet;
    }
    
    
    //ARRAY TO CHART SERIES
    public static LineChartSeries toChartSeries(LineChartSeries targetSeries, Point[] arrayInput)
    { 
        for (int i = 0; i<arrayInput.length; i++) 
        {
        	targetSeries.set(arrayInput[i].x, arrayInput[i].y);
        }
    	return targetSeries;
    }

       
    	//	Creates a random Array of specified length for testing purposes
    public static Point[] generateRandom(int arrayLength) 
    {
    	int lastNumber = (int) (Config.yMax*0.5);
    	Point[] randomSet = new Point[arrayLength];        
			for (int i = 0; i<randomSet.length; i++) 
			{
			    Point temp = new Point();
				temp.x = i;
				if (Math.random() < 0.5&&lastNumber<(Config.yMax*0.75)) 
					{
					temp.y = (int) (lastNumber*(((Config.yMax*Config.randomValueSmoothing)+Math.random())/(Config.yMax*Config.randomValueSmoothing)));
					}
				else 
					{
					temp.y = (int) (lastNumber*(((Config.yMax*Config.randomValueSmoothing)-Math.random())/(Config.yMax*Config.randomValueSmoothing)));	
					}		
				lastNumber = temp.y;	
				randomSet[i] = temp;
			}
		return randomSet;
	}	
    
}
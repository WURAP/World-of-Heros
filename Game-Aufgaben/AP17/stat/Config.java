package stat;

public class Config 
{
	
	
	//RANDOM VALUES FOR TESTING PURPOSES
	public final static boolean randomValues = false;
		public final static int randomArrayLength = 20;
		public final static double randomValueSmoothing = 0.02;
	
	//DEFINE LINE SHAPE
	public final static boolean showMarker = false;
	public final static boolean smoothLine = true;
	public final static boolean lineAverage = true;

	
	//GRAPH DIMENSIONS
	public final static int yMin = 0;
	public final static int yMax = 200;
	
	public final static int xMin = 0;
	public final static int xMax = roundTicks(Data.getPreset().length);

	
	

	/* 
	 * PrimeFaces divides the maximum x-value through 6 to get data ticks along the x-axis.
	 * This method rounds up to get better looking integers at the cost of unused space.
	 */
	
	private static int roundTicks(int i) 
	{ 
		if(i%6 != 0) 
		{
			int temp = i / 6;
			i = 6 * (temp + 1);
		}
		return i;
		
	}

    
}

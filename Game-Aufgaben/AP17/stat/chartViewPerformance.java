package stat;
 
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
 
@ManagedBean
public class chartViewPerformance implements Serializable 
{
 
    private LineChartModel lineModel1;

     
    @PostConstruct
    public void init() 
    {
        createLineModels();
    }
 
    public LineChartModel getLineModel1() 
    {
        return lineModel1;
    }
 

    private void createLineModels() 
    {
    	//DEFINE GRAPH
        lineModel1 = initLinearModel();
        lineModel1.setTitle("Game Performance");
        lineModel1.setLegendPosition("e");
        
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
	        yAxis.setMin(0);
	        yAxis.setMax(Config.yMax/2);

    }
     
    
    
    private LineChartModel initLinearModel() 
    
    {
        
    	
    	LineChartModel model = new LineChartModel();
 
        
    	//PERFORMANCE OVER TIME
        LineChartSeries performanceSeries = new LineChartSeries();
	        performanceSeries.setLabel("Performance");
	        performanceSeries.setShowMarker(false);
	    
	        
	    //FOR TESTING PURPOSES ONLY    
        Player currentPlayer = new Player();										//Creates new Player and assigns random values
        currentPlayer.addPerformancesRandom(20);	
		Performance [] performanceSet = currentPlayer.getPerformance().clone();
	

        for (int i = 0; i<performanceSet.length; i++) 								//Array to Series
        {
            SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd"); 				//Converts Date to usable format
        	String tempDate = sm.format(performanceSet[i].date);   	
        	performanceSeries.set(tempDate, performanceSet[i].score);
        }
     

        
        DateAxis dateAxis = new DateAxis("Time");
        model.getAxes().put(AxisType.X, dateAxis);
        model.getAxis(AxisType.X).setTickFormat("%b %#d, %y");
        
        
        model.addSeries(performanceSeries);

        
        return model;
    }
     
    
 
}
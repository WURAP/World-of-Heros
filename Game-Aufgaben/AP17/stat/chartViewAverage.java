package stat;
 
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
 
@ManagedBean
public class chartViewAverage implements Serializable 
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
	        yAxis.setMin(Config.yMin);
	        yAxis.setMax(Config.yMax/2);
        Axis xAxis = lineModel1.getAxis(AxisType.X);
	        xAxis.setMin(Config.xMin);
	        xAxis.setMax(Config.xMax);
    }
     
    
    
    private LineChartModel initLinearModel() 
    
    {
    	
    	//PERFORMANCE
        LineChartSeries performanceSeries = new LineChartSeries();
	        performanceSeries.setLabel("Performance");
	        performanceSeries.setShowMarker(Config.showMarker);
	        performanceSeries.setSmoothLine(Config.smoothLine);
                   
	    Data.toChartSeries(performanceSeries, Data.getPerformance());
        

        //AVERAGE
        LineChartSeries averageSeries = new LineChartSeries();
	        averageSeries.setLabel("Average");
	        averageSeries.setShowMarker(false);
   
	    Data.toChartSeries(averageSeries, Data.getAverage());
        
   
        LineChartModel model = new LineChartModel();        
	        model.addSeries(performanceSeries);
	        model.addSeries(averageSeries);     
        return model;
        

    }
     
    
 
}
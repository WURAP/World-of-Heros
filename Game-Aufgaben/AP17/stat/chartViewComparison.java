package stat;
 
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
 
@ManagedBean
public class chartViewComparison implements Serializable 
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
	        yAxis.setMax(Config.yMax);
        Axis xAxis = lineModel1.getAxis(AxisType.X);
	        xAxis.setMin(Config.xMin);
	        xAxis.setMax(Config.xMax);
    }
    
    
      
    private LineChartModel initLinearModel() 
  
    {     
    	
    	//FLIGHT PATH
    	LineChartSeries pathSeries = new LineChartSeries();
    		pathSeries.setLabel("Flight Path");
		    pathSeries.setShowMarker(Config.showMarker);
		    pathSeries.setSmoothLine(Config.smoothLine);
	                 
		Data.toChartSeries(pathSeries, Data.getActual());
	        
	        
	        
	    //PRESET PATH
	    LineChartSeries presetSeries = new LineChartSeries();
	    	presetSeries.setLabel("Preset Path");
		    presetSeries.setShowMarker(Config.showMarker);
		    presetSeries.setSmoothLine(Config.smoothLine);
		
		Data.toChartSeries(presetSeries, Data.getPreset());
	      
	        
	    LineChartModel model = new LineChartModel();    
			model.addSeries(pathSeries);
			model.addSeries(presetSeries);
		return model;
		
    }
     
    
 
}
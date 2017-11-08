package org.primefaces.examples;

	import javax.annotation.PostConstruct;
	import java.io.Serializable;
	import javax.faces.bean.ManagedBean;
	import org.primefaces.model.chart.Axis;
	import org.primefaces.model.chart.AxisType;
	import org.primefaces.model.chart.CategoryAxis;
	import org.primefaces.model.chart.LineChartModel;
	import org.primefaces.model.chart.ChartSeries;
	import org.primefaces.model.chart.LineChartSeries;
	
	 
	@ManagedBean
	public class ChartView implements Serializable {
	 
	    private LineChartModel lineModel1;
	    private LineChartModel lineModel2;
	     
	    @PostConstruct
	    public void init() {
	        createLineModels();
	    }
	 
	    public LineChartModel getLineModel1() {
	        return lineModel1;
	    }
	 
	    public LineChartModel getLineModel2() {
	        return lineModel2;
	    }
	     
	    private void createLineModels() {
	        lineModel1 = initLinearModel();
	        lineModel1.setTitle("Flugkurven");
	        lineModel1.setLegendPosition("e");
	        lineModel1.getAxes().put(AxisType.X, new CategoryAxis("Time"));
	        Axis yAxis = lineModel1.getAxis(AxisType.Y);
	        yAxis.setMin(0);
	        yAxis.setMax(10);
	        Axis xAxis = lineModel1.getAxis(AxisType.X);
	        xAxis.setMin(0);
	        xAxis.setMax(6);
	         
	        lineModel2 = initCategoryModel();
	        lineModel2.setTitle("Flugkurven");
	        lineModel2.setLegendPosition("e");
	        lineModel2.setShowPointLabels(true);
	        lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Time"));
	        yAxis = lineModel2.getAxis(AxisType.Y);
//	        yAxis.setLabel("Births");
	        yAxis.setMin(0);
	        yAxis.setMax(200);
	        xAxis = lineModel2.getAxis(AxisType.X);
	        xAxis.setMin(0);
	        xAxis.setMax(6);
	        
	    }
	     
	    private LineChartModel initLinearModel() {
	        LineChartModel model = new LineChartModel();
	 
	        LineChartSeries series1 = new LineChartSeries();
	        series1.setLabel("vorgegebene Flugkurve");
	        series1.set(0, 5);
	        series1.set(1, 2);
	        series1.set(2, 1);
	        series1.set(3, 3);
	        series1.set(4, 6);
	        series1.set(5, 8);
	        
	 
	        LineChartSeries series2 = new LineChartSeries();
	        series2.setLabel("tatsächliche Flugkurve");
	        series2.set(0, 5);
	        series2.set(1, 6);
	        series2.set(2, 3);
	        series2.set(3, 2);
	        series2.set(4, 7);
	        series2.set(5, 9);
	        series2.set(10, 7.5);
	 
	        model.addSeries(series1);
	        model.addSeries(series2);
	         
	        return model;
	    }
	     
	    private LineChartModel initCategoryModel() {
	        LineChartModel model = new LineChartModel();
	 
	        ChartSeries Kurve1 = new ChartSeries();
	        Kurve1.setLabel("vorgegebene Flugkurve");
	        Kurve1.set("0", 100);
	        Kurve1.set("1", 120);
	        Kurve1.set("2", 100);
	        Kurve1.set("3", 44);
	        Kurve1.set("4", 150);
	        Kurve1.set("5", 25);
	        Kurve1.set("6", 50);
	 
	        ChartSeries Kurve2 = new ChartSeries();
	        Kurve2.setLabel("tatsächliche Flugkurve");
	        Kurve2.set("0", 100);
	        Kurve2.set("1", 52);
	        Kurve2.set("2", 60);
	        Kurve2.set("3", 110);
	        Kurve2.set("4", 90);
	        Kurve2.set("5", 120);
	        Kurve2.set("6", 100);
	 
	        model.addSeries(Kurve1);
	        model.addSeries(Kurve2);
	         
	        return model;
	    }
	 
}

import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;







@ManagedBean
public class chartView3 implements Serializable {
	private BarChartModel barModel;
    private HorizontalBarChartModel horizontalBarModel;
 
    @PostConstruct
    public void init() {
        createBarModels();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }
 
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries spiel1 = new ChartSeries();
        spiel1.setLabel("Buchstabenspiel");
        spiel1.set("25.10.2017", 120);
        spiel1.set("26.10.2017", 100);
        spiel1.set("27.10.2017", 44);
        spiel1.set("28.10.2017", 150);
        spiel1.set("29.10.2017", 25);
 
        ChartSeries spiel2 = new ChartSeries();
        spiel2.setLabel("Textspiel");
        spiel2.set("25.10.2017", 52);
        spiel2.set("26.10.2017", 60);
        spiel2.set("27.10.2017", 110);
        spiel2.set("28.10.2017", 135);
        spiel2.set("29.10.2017", 120);
 
        ChartSeries spiel3 = new ChartSeries();
        spiel3.setLabel("Super Hero");
        spiel3.set("25.10.2017", 52);
        spiel3.set("26.10.2017", 60);
        spiel3.set("27.10.2017", 110);
        spiel3.set("28.10.2017", 135);
        spiel3.set("29.10.2017", 120);
        
        LineChartSeries average = new LineChartSeries();
        average.setLabel("Durchschnitt");

        average.set("25.10.2017", 52);
        average.set("26.10.2017", 60);
        average.set("27.10.2017", 110);
        average.set("28.10.2017", 135);
        average.set("29.10.2017", 120);
        
        model.addSeries(spiel1);
        model.addSeries(spiel2);
        model.addSeries(spiel3);
        model.addSeries(average);
        
         
        return model;
    }
    

     
    private void createBarModels() {
        createBarModel();
        //createHorizontalBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Ergebnisse");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Datum");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Punkte");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
     
    /*private void createHorizontalBarModel() {
        horizontalBarModel = new HorizontalBarChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 50);
        boys.set("2005", 96);
        boys.set("2006", 44);
        boys.set("2007", 55);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 82);
        girls.set("2007", 35);
        girls.set("2008", 120);
 
        horizontalBarModel.addSeries(boys);
        horizontalBarModel.addSeries(girls);
         
        horizontalBarModel.setTitle("Horizontal and Stacked");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
         
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("Births");
        xAxis.setMin(0);
        xAxis.setMax(200);
         
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("Gender");        
    }*/

}
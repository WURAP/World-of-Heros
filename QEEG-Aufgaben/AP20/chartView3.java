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
        
        int i1=120;
        int i2=100;
        int i3=44;
        int i4=150;
        int i5=25;
        
        int i6=52;
        int i7=60;
        int i8=110;
        int i9=135;
        int i10=120;
        
        int i11=52;
        int i12=60;
        int i13=110;
        int i14=135;
        int i15=120;
        
        int avg1=(i1+i6+i11)/3;
        int avg2=(i2+i7+i12)/3;
        int avg3=(i3+i8+i13)/3;
        int avg4=(i4+i9+i14)/3;
        int avg5=(i5+i10+i15)/3;
 
        ChartSeries spiel1 = new ChartSeries();
        spiel1.setLabel("Buchstabenspiel");
        spiel1.set("25.10.2017", i1);
        spiel1.set("26.10.2017", i2);
        spiel1.set("27.10.2017", i3);
        spiel1.set("28.10.2017", i4);
        spiel1.set("29.10.2017", i5);
 
        ChartSeries spiel2 = new ChartSeries();
        spiel2.setLabel("Textspiel");
        spiel2.set("25.10.2017", i6);
        spiel2.set("26.10.2017", i7);
        spiel2.set("27.10.2017", i8);
        spiel2.set("28.10.2017", i9);
        spiel2.set("29.10.2017", i10);
 
        ChartSeries spiel3 = new ChartSeries();
        spiel3.setLabel("Super Hero");
        spiel3.set("25.10.2017", i11);
        spiel3.set("26.10.2017", i12);
        spiel3.set("27.10.2017", i13);
        spiel3.set("28.10.2017", i14);
        spiel3.set("29.10.2017", i15);
        
        LineChartSeries average = new LineChartSeries();
        average.setLabel("Durchschnitt");

        average.set("25.10.2017", avg1);
        average.set("26.10.2017", avg2);
        average.set("27.10.2017", avg3);
        average.set("28.10.2017", avg4);
        average.set("29.10.2017", avg5);
        
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
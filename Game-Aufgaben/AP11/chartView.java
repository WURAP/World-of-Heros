import javax.annotation.PostConstruct;
import java.awt.Point;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;







@ManagedBean
public class chartView implements Serializable {
private LineChartModel lineModel1;
@PostConstruct
public void init() {
createLineModels();
}
public LineChartModel getLineModel1() {
return lineModel1;
}
private void createLineModels() {
lineModel1 = initLinearModel();
lineModel1.setTitle("Game Performance");
lineModel1.setLegendPosition("e");
Axis yAxis = lineModel1.getAxis(AxisType.Y);
yAxis.setMin(0);
yAxis.setMax(10);
}
private LineChartModel initLinearModel() {
LineChartModel model = new LineChartModel();
LineChartSeries series1 = new LineChartSeries();
series1.setLabel("Flugline");
Point[] set1 = new Point[11];
for (int i = 0; i<set1.length; i++) {
Point temp = new Point();
temp.x = i;
temp.y = (int) (Math.random()*10);
set1[i] = temp;
}
for (int i = 0; i<set1.length; i++) {
series1.set(set1[i].x,set1[i].y);
}
System.out.println(series1);
LineChartSeries series2 = new LineChartSeries();
series2.setLabel("Vorgabe");series2.set(0, 3);
series2.set(1, 6);
series2.set(2, 3);
series2.set(3, 2);
series2.set(4, 5);
series2.set(5, 8);
series2.set(6, 4);
series2.set(7, 5);
series2.set(8, 3);
series2.set(9, 7);
series2.set(10, 6);
model.addSeries(series1);
model.addSeries(series2);
return model;
}
}
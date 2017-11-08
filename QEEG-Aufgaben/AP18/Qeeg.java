
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException; 
import java.text.SimpleDateFormat; 
import java.util.Date;
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities;

public class Qeeg extends ApplicationFrame { 
   
	public Qeeg() {
        
		super("Qeeg");
        XYDataset datenset = datenErzeugung(); //rufe die Methode datenErzeugung() auf. Die Variable datenset zeigt auf die gesamten Daten
        JFreeChart chart  = createChart(datenset); //rufe die Methode createChart() auf und übergebe ihr die Daten um ein Diagramm zu erzeugen
        ChartPanel chartPanel = new ChartPanel(chart); //stelle das Diagramm in einem Fenster dar
        chartPanel.setSize(2000,1000); //stellt die Größe ein. 2000 Pixel breit/1000 Pixel hoch
        setContentPane(chartPanel); //zeigt das Diagramm im Fenster an
    }
    
	//Methode, um die Daten der 16 Kanälen zu erzeugen und zurückzugeben
	public XYSeriesCollection datenErzeugung() {
    	
		//erzeugt eine Kollektionsobjekt von Daten (beinhaltet alle 16 Kanäle)
		XYSeriesCollection datenset = new XYSeriesCollection();
    	
		//erzeugt 16 Objekte, die jeweils einen Kanal repräsentieren
    	XYSeries Kanal1 = new XYSeries("Kanal 1"); 
        XYSeries Kanal2 = new XYSeries("Kanal 2");
        XYSeries Kanal3 = new XYSeries("Kanal 3"); 
        XYSeries Kanal4 = new XYSeries("Kanal 4");
        XYSeries Kanal5 = new XYSeries("Kanal 5"); 
        XYSeries Kanal6 = new XYSeries("Kanal 6");
        XYSeries Kanal7 = new XYSeries("Kanal 7"); 
        XYSeries Kanal8 = new XYSeries("Kanal 8");
        XYSeries Kanal9 = new XYSeries("Kanal 9"); 
        XYSeries Kanal10 = new XYSeries("Kanal 10");
        XYSeries Kanal11 = new XYSeries("Kanal 11"); 
        XYSeries Kanal12 = new XYSeries("Kanal 12");
        XYSeries Kanal13 = new XYSeries("Kanal 13"); 
        XYSeries Kanal14 = new XYSeries("Kanal 14");
        XYSeries Kanal15 = new XYSeries("Kanal 15"); 
        XYSeries Kanal16 = new XYSeries("Kanal 16");
        
        
        
        try (BufferedReader lese = new BufferedReader(new FileReader("/home/h1350859/SR/Documents/Kanal1.csv"))) {          
            
        	
        	SimpleDateFormat formatiere = new SimpleDateFormat("hh:mm:ss.SSS"); 
            String s = null;
            
            //setze den Zeiger "s" auf die nächste Linie. Solange "s" auf etwas zeigt, befolge die while-Schleife
            //Erstelle ein Array von String Objekten und teile es dort, wo ein Beistrich vorkommt
            //Formatiere das erste Objekt in der Zeile nach den zuvor definirten Formatierregeln
            //Entferne mittels trim() Leerzeichen vor und nach dem String
            //Ermittle mittels valueOf() den Wert des Stringobjekts und mach daraus ein Integer Objekt
            //Füge dem ersten Kanal die x- und y-Werte bei.
            while ((s = lese.readLine()) != null) {
                String[] a = s.split(",");
                Date d = formatiere.parse(a[0]);
                int v = Integer.valueOf(a[1].trim());
                Kanal1.add(d.getTime(), v);
            }
        }	//fängt zwei Mögliche Exceptions, die auftreten können
        	catch (IOException | ParseException e) {
        		e.printStackTrace(); //zeigt an, in welcher Zeile ein Fehler aufgetreten ist
        } 
        
        try(BufferedReader lese = new BufferedReader(new FileReader("/home/h1350859/SR/Documents/Kanal2.csv"))) {
     
            SimpleDateFormat formatiere = new SimpleDateFormat("hh:mm:ss.SSS"); 
            String s = null;
            
            while ((s = lese.readLine()) != null) {
                String[] a = s.split(",");   
                Date d = formatiere.parse(a[0]);
                int v = Integer.valueOf(a[1].trim());
                Kanal2.add(d.getTime(), v);
            }
        }
        	catch (IOException | ParseException e) {
        		e.printStackTrace();
        }    
        
        try (BufferedReader lese = new BufferedReader(new FileReader("/home/h1350859/SR/Documents/Kanal3.csv"))) {
                      
            SimpleDateFormat formatiere = new SimpleDateFormat("hh:mm:ss.SSS"); 
            String s = null;
            
            while ((s = lese.readLine()) != null) {
                String[] a = s.split(",");
                Date d = formatiere.parse(a[0]);
                int v = Integer.valueOf(a[1].trim());
                Kanal3.add(d.getTime(), v);
            }
        }
        	catch (IOException | ParseException e) {
        		e.printStackTrace();
        }    
        
        try (BufferedReader lese = new BufferedReader(new FileReader("/home/h1350859/SR/Documents/Kanal4.csv"))) {
                        
            SimpleDateFormat formatiere = new SimpleDateFormat("hh:mm:ss.SSS"); 
            String s = null;
            
            while ((s = lese.readLine()) != null) {
                String[] a = s.split(",");
                Date d = formatiere.parse(a[0]);
                int v = Integer.valueOf(a[1].trim());
                Kanal4.add(d.getTime(), v);
            }
        }
        	catch (IOException | ParseException e) {
        		e.printStackTrace();
        }    
        
        try (BufferedReader lese = new BufferedReader(new FileReader("/home/h1350859/SR/Documents/Kanal5.csv"))) {
                       
            SimpleDateFormat formatiere = new SimpleDateFormat("hh:mm:ss.SSS"); 
            String s = null;
            
            while ((s = lese.readLine()) != null) {
                String[] a = s.split(",");
                Date d = formatiere.parse(a[0]);
                int v = Integer.valueOf(a[1].trim());
                Kanal5.add(d.getTime(), v);
            }
        }
        	catch (IOException | ParseException e) {
        		e.printStackTrace();
        }    
        
        try (BufferedReader lese = new BufferedReader(new FileReader("/home/h1350859/SR/Documents/Kanal6.csv"))) {
            
            SimpleDateFormat formatiere = new SimpleDateFormat("hh:mm:ss.SSS"); 
            String s = null;
            
            while ((s = lese.readLine()) != null) {
                String[] a = s.split(",");
                Date d = formatiere.parse(a[0]);
                int v = Integer.valueOf(a[1].trim());
                Kanal6.add(d.getTime(), v);
            }
        }
        	catch (IOException | ParseException e) {
        		e.printStackTrace();
        }   
            
        try (BufferedReader lese = new BufferedReader(new FileReader("/home/h1350859/SR/Documents/Kanal7.csv"))) {
            
            SimpleDateFormat formatiere = new SimpleDateFormat("hh:mm:ss.SSS"); 
            String s = null;
            
            while ((s = lese.readLine()) != null) {
                String[] a = s.split(",");
                Date d = formatiere.parse(a[0]);
                int v = Integer.valueOf(a[1].trim());
                Kanal7.add(d.getTime(), v);
            }
        }
        	catch (IOException | ParseException e) {
        		e.printStackTrace();
        }   
   
        try (BufferedReader lese = new BufferedReader(new FileReader("/home/h1350859/SR/Documents/Kanal8.csv"))) {
            
            SimpleDateFormat formatiere = new SimpleDateFormat("hh:mm:ss.SSS"); 
            String s = null;
            
            while ((s = lese.readLine()) != null) {
                String[] a = s.split(",");
                Date d = formatiere.parse(a[0]);
                int v = Integer.valueOf(a[1].trim());
                Kanal8.add(d.getTime(), v);
            }
        }
        	catch (IOException | ParseException e) {
        		e.printStackTrace();
        }   
        
        try (BufferedReader lese = new BufferedReader(new FileReader("/home/h1350859/SR/Documents/Kanal9.csv"))) {
        	
            SimpleDateFormat formatiere = new SimpleDateFormat("hh:mm:ss.SSS"); 
            String s = null;
            
            while ((s = lese.readLine()) != null) {
                String[] a = s.split(",");
                Date d = formatiere.parse(a[0]);
                int v = Integer.valueOf(a[1].trim());
                Kanal9.add(d.getTime(), v);  
            }
        }
        	catch (IOException | ParseException e) {
        		e.printStackTrace();
        }    
        
        try (BufferedReader lese = new BufferedReader(new FileReader("/home/h1350859/SR/Documents/Kanal10.csv"))) {
     
            SimpleDateFormat formatiere = new SimpleDateFormat("hh:mm:ss.SSS"); 
            String s = null;
           
            while ((s = lese.readLine()) != null) {
                String[] a = s.split(",");
                Date d = formatiere.parse(a[0]);
                int v = Integer.valueOf(a[1].trim());
                Kanal10.add(d.getTime(), v); 
            }
        }
        	catch (IOException | ParseException e) {
        		e.printStackTrace();
        }    
        
        try (BufferedReader lese = new BufferedReader(new FileReader("/home/h1350859/SR/Documents/Kanal11.csv"))) {
            
            SimpleDateFormat formatiere = new SimpleDateFormat("hh:mm:ss.SSS"); 
            String s = null;
            
            while ((s = lese.readLine()) != null) {
                String[] a = s.split(",");
                Date d = formatiere.parse(a[0]);
                int v = Integer.valueOf(a[1].trim());
                Kanal11.add(d.getTime(), v);  
            }
        }
        	catch (IOException | ParseException e) {
        		e.printStackTrace();
        }    
        
        try (BufferedReader lese = new BufferedReader(new FileReader("/home/h1350859/SR/Documents/Kanal12.csv"))) {
            
            SimpleDateFormat formatiere = new SimpleDateFormat("hh:mm:ss.SSS"); 
            String s = null;
            
            while ((s = lese.readLine()) != null) {
                String[] a = s.split(",");
                Date d = formatiere.parse(a[0]);
                int v = Integer.valueOf(a[1].trim());
                Kanal12.add(d.getTime(), v);
            }
        }
        	catch (IOException | ParseException e) {
        		e.printStackTrace();
        }    
        
        try (BufferedReader lese = new BufferedReader(new FileReader("/home/h1350859/SR/Documents/Kanal13.csv"))) {
            
            SimpleDateFormat formatiere = new SimpleDateFormat("hh:mm:ss.SSS"); 
            String s = null;
            
            while ((s = lese.readLine()) != null) {
                String[] a = s.split(",");
                Date d = formatiere.parse(a[0]);
                int v = Integer.valueOf(a[1].trim());
                Kanal13.add(d.getTime(), v);
            }
        }
        	catch (IOException | ParseException e) {
        		e.printStackTrace();
        }    
        
        try (BufferedReader lese = new BufferedReader(new FileReader("/home/h1350859/SR/Documents/Kanal14.csv"))) {
            
            SimpleDateFormat formatiere = new SimpleDateFormat("hh:mm:ss.SSS"); 
            String s = null;
            
            while ((s = lese.readLine()) != null) {
                String[] a = s.split(",");
                Date d = formatiere.parse(a[0]);
                int v = Integer.valueOf(a[1].trim());
                Kanal14.add(d.getTime(), v);
            }
        }
        	catch (IOException | ParseException e) {
        		e.printStackTrace();
        }   
            
        try (BufferedReader lese = new BufferedReader(new FileReader("/home/h1350859/SR/Documents/Kanal15.csv"))) {
            
            SimpleDateFormat formatiere = new SimpleDateFormat("hh:mm:ss.SSS"); 
            String s = null;
            
            while ((s = lese.readLine()) != null) {
                String[] a = s.split(",");
                Date d = formatiere.parse(a[0]);
                int v = Integer.valueOf(a[1].trim());
                Kanal15.add(d.getTime(), v);
            }
        }
        	catch (IOException | ParseException e) {
        		e.printStackTrace();
        }   
   
        try (BufferedReader lese = new BufferedReader(new FileReader("/home/h1350859/SR/Documents/Kanal16.csv"))) {
            
            SimpleDateFormat formatiere = new SimpleDateFormat("hh:mm:ss.SSS"); 
            String s = null;
            
            while ((s = lese.readLine()) != null) {
                String[] a = s.split(",");
                Date d = formatiere.parse(a[0]);
                int v = Integer.valueOf(a[1].trim());
                Kanal16.add(d.getTime(), v);
            }
        }
        	catch (IOException | ParseException e) {
        		e.printStackTrace();
        }     
        
        //füge die einzelnen Kanäle dem Kollektionsobjekt bei. 
        datenset.addSeries(Kanal1);
        datenset.addSeries(Kanal2);
        datenset.addSeries(Kanal3);
        datenset.addSeries(Kanal4);
        datenset.addSeries(Kanal5);
        datenset.addSeries(Kanal6);
        datenset.addSeries(Kanal7);
        datenset.addSeries(Kanal8);
        datenset.addSeries(Kanal9);
        datenset.addSeries(Kanal10);
        datenset.addSeries(Kanal11);
        datenset.addSeries(Kanal12);
        datenset.addSeries(Kanal13);
        datenset.addSeries(Kanal14);
        datenset.addSeries(Kanal15);
        datenset.addSeries(Kanal16);
        
        //gib das Kollektionsobjekt (16 Kanäle) zurück
        return datenset;
    } 
    
		//erzeuge, formatiere und gib das Diagramm zurück
    public JFreeChart createChart(XYDataset daten) {
        JFreeChart qeeg = ChartFactory.createTimeSeriesChart("QEEG Zeitreihe","Zeit", "Mikrovolt", daten);
        return qeeg;
    }
    
    public static void main(String[] args) {
    	Qeeg obj = new Qeeg();
        obj.pack(); //stelle das Fenster in die angegebene Größe
        RefineryUtilities.centerFrameOnScreen(obj); //stell das Fenster in die Mitte des Bildschirms
        obj.setVisible(true); //lass das Fenster anzeigen
    }
}

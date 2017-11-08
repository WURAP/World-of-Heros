import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

// Die Libaries, die für die Datenbankanbindung notwendig sind

import java.sql.Connection;			
import java.sql.DriverManager;		
import java.sql.ResultSet;			
import java.sql.SQLException;
import java.sql.Statement;




@ManagedBean
public class chartView3 implements Serializable {
	private BarChartModel barModel;
    private HorizontalBarChartModel horizontalBarModel;
    
    // SQL-TEIL-Anfang
    
    //Variablen für die Datenbankanbindung
    // Das sind die globale Variablen, damit wir aus jeder Funktion auf die Variablen zugreifen können (Histogamme)
    private static Connection con = null; // Eine Variable zum Verbinden mit dem Datebank-Server
    private static String dbHost = "localhost"; // Hostname (kann auch eine IP-Adresse sein, wie z.B. IP-Adresse des Datenbank-Servers
    private static String dbPort = "3306";      // Port -- Standard: 3306 ==> Portnummer des Database-Servers
    private static String dbName = "worldofheroes";   // Datenbankname
    private static String dbUser = "root";     // Datenbankuser (Standard in Localhost)
    private static String dbPass = "";      // Datenbankpasswort (Standard in Localhost)
    private static String Spielername, Datum, Spiel; // Die globale Variablen, wo die Datenbankwerte geladen werden.
    private static Integer Punkte; // Da Punkte Zahlenwerte sind, werden sie als Integer deklariert
    
    
    @PostConstruct
    public void init() {
        
        try {
        Class.forName("com.mysql.jdbc.Driver"); // Datenbanktreiber für JDBC Schnittstellen laden.
 
        // Verbindung zur JDBC-Datenbank herstellen.
        con = DriverManager.getConnection("jdbc:mysql://"+dbHost+":"+ dbPort+"/"+dbName+"?"+"user="+dbUser+"&"+"password="+dbPass); 
    } catch (ClassNotFoundException e) {
        System.out.println("Treiber nicht gefunden");
    } catch (SQLException e) {
        System.out.println("Verbindung nicht moglich"); //Mögliche Fehlerausgaben, die vorkommen können
        System.out.println("SQLException: " + e.getMessage()); 
        System.out.println("SQLState: " + e.getSQLState()); 
        System.out.println("VendorError: " + e.getErrorCode()); 
    }
        Statement query;  // SQL-Anfrage von Java
        try {
          query = con.createStatement();
 
          // Tabelle anzeigen
          // Hier wird auf die jeweilige Tabellen zugegriffen, aus denen wir ein Histogramm erstellen bzw. die Ergebnisse auswerten wollen.
          String sql =
                "SELECT score.Sitzungsteilnehmer as Spielername, score.Wert, score.Sitzungsdatum as Datum, "
                  + "spieltyp.Spieltyp_Name as Spielname from score JOIN spielstufe ON "
                  + "score.Level_ID=spielstufe.Level_ID JOIN spiel ON spielstufe.Spiel_ID=spiel.Spiel_ID JOIN "
                  + "spieltyp ON spiel.Spieltyp_ID=spieltyp.Spieltyp_ID WHERE score.Sitzungsteilnehmer='Christian Aigner'";
          
          
          
          ResultSet result = query.executeQuery(sql); // Das Ergebnis also die Anfrage an SQL Server wird in Variable "Result" geladen.
 
        // Ergebnisstabelle durchforsten
         // Mit der While-Schleife werden die Ergebnisse von der Datenbank durchgegangen und in die globalen Variablen abgeschpeichert.
          while (result.next()) {
          Spielername = result.getString("Spielername");
          Punkte = result.getInt("Wert");
          Datum = result.getString("Datum");
          Spiel = result.getString("Spielname");          
          String info = Spielername + ", " + Punkte + ", " + Datum + ", " + Spiel;
         
          System.out.println(info);
          
          }
          
          // Zwischen try und catch wurde das Programm geschrieben. Die Befehle zwischen try und catch werden auf Fehler geprüft.
      } catch (SQLException e) {
        e.printStackTrace();		// Fehlerausgabe
        
        
        // Zwischen try und catch wurde das Programm geschrieben. Die Befehle zwischen try und catch werden auf Fehler geprüft.
        
        
        //SQL-Teil-Ende
        
        
      }
    
        
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
        spiel1.setLabel(Spiel);
        spiel1.set(Datum, Punkte);
      
        ChartSeries spiel2 = new ChartSeries();
        spiel2.setLabel(Spiel);
        
        LineChartSeries average = new LineChartSeries();
        average.setLabel("Durchschnitt");
        average.set(Datum, Punkte);
        
        
        model.addSeries(spiel1);
        
        model.addSeries(average);
        
         
        return model;
    }
    

     
    private void createBarModels() {
        createBarModel();
        //createHorizontalBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle(Spielername);
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Datum");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Punkte");
        yAxis.setMin(0);
        yAxis.setMax(9000);
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
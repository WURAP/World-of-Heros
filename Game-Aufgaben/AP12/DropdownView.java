import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
 
@ManagedBean
@ViewScoped
public class DropdownView implements Serializable {
     
    private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
    private String country; 
    private String city;  
    private String pant;
    private Map<String,String> countries;
    private Map<String,String> cities;
    private Map<String,String> pants;
     
    @PostConstruct
    public void init() {
        countries  = new HashMap<String, String>();
        countries.put("Junge", "Junge");
        countries.put("Mädchen", "Mädchen");
         
        Map<String,String> map = new HashMap<String, String>();
        /*map.put("New York", "New York");
        map.put("San Francisco", "San Francisco");
        map.put("Denver", "Denver");
        data.put("USA", map);*/
         
        map = new HashMap<String, String>();
        map.put("Grün", "Grün");
        map.put("Blau", "Blau");
        map.put("Schwarz", "Schwarz");
        data.put("Junge", map);
         
        map = new HashMap<String, String>();
        map.put("Weiß", "Weiß");
        map.put("Lila", "Lila");
        map.put("Grün", "Grün");
        data.put("Mädchen", map);
        
        Map<String,String> map1 = new HashMap<String, String>();
        map1 = new HashMap<String, String>();
        map1.put("Schwarz", "Schwarz");
        map1.put("Braun", "Braun");
        data.put("Mächen", map1);
        
        
        map1 = new HashMap<String, String>();
        map1.put("Grün", "Grün");
        map1.put("Blau", "Blau");
        map1.put("Schwarz", "Schwarz");
        data.put("Junge", map1);
        
        
    }
 
    public Map<String, Map<String, String>> getData() {
        return data;
    }
 
    public String getCountry() {
        return country;
    }
 
    public void setCountry(String country) {
        this.country = country;
    }
 
    public String getCity() {
        return city;
    }
    public String getPant() {
    	return pant;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
    public void setPant(String pant) {
    	this.pant = pant;
    }
 
    public Map<String, String> getCountries() {
        return countries;
    }
 
    public Map<String, String> getCities() {
        return cities;
    }
    public Map<String, String> getPants() {
    	return pants;
    }
 
    public void onCountryChange() {
        if(country !=null && !country.equals("")) {
            cities = data.get(country);
        	pants = data.get(country);}
        else {
            cities = new HashMap<String, String>();
        	pants = new HashMap<String, String>();}
    }
     
    public void displayLocation() {
        FacesMessage msg;
        if(city != null && country != null)
            msg = new FacesMessage("Ausgewählt", "T-Shirt " + city + "," + " Hose " + pant);
        else
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Outfit nicht ausgesucht."); 
             
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
}
package Motion;

import java.util.Timer;
import java.util.TimerTask;

public class WaveHandler {
	
	Timer wavehandler;
	public WaveHandler() {
		wavehandler = new Timer();
		wavehandler.scheduleAtFixedRate(new TimerTask() {

			public void run() {
				
				//Hier werden die aktuellen Gehirn-Wellen eingebettet - Input von Schnittstelle benötigt!
				double data[]= {2,-2,2,-2,2,2,2,-2,2,2,2,2,2,2,2,2,-2,-2,-2,-2,-2,-2,-2,-2,2,2,2,2,2,2,2,2,2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2};
				
				for(int i=0; i<data.length;i++) {
					
					if (data[i]<EffektivWert.wert) {
						if (Var.y > 0) {
						Var.y-=Var.speedup;
						System.out.println("Aktuelle Gerhinwelle über Effektivwert: "+data[i]+" von "+EffektivWert.wert);
						
						}}
						
					 else if (data[i]>EffektivWert.wert)  {
						 if (Var.y <= 540) {
						Var.y+=Var.speeddown;
					System.out.println("Aktuelle Gehrinwelle unter Effektivwert: "+data[i]+" von "+EffektivWert.wert);
				
						 }}
				}

			}

		}, 10, 500);
		
		
		
	}
}


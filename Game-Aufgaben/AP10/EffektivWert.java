package Motion;

public class EffektivWert {
	public static double wert;

	public EffektivWert() {
		// Hier wird der Effektivwert berechnet - Input von Schnittstelle benötigt!
		double initdata[] = { 1.8, 1.8, 1.1, 1.1 };
		double sum = 0;
		double wert = 1.45;

		for (int counter = 0; counter < initdata.length; counter++) {
			sum += initdata[counter];
			wert = sum / initdata.length;

			System.out.println("Summe: " + sum);
			System.out.println("Effektiv " + wert);
		}

	}
}
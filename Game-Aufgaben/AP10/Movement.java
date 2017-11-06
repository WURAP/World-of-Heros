package Motion;

import java.util.Timer;
import java.util.TimerTask;

public class Movement {

	Timer movement;

	public Movement() {
		movement = new Timer();
		movement.scheduleAtFixedRate(new TimerTask() {
			public void run() {

				// Start der links nach rechts Bewegung wenn Effektivwert geliefert wird
				Var.x += Var.linksnachrechts;

			}

		}, 0, 10);

	}

}

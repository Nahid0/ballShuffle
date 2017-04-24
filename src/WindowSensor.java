import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class WindowSensor extends WindowAdapter {
	public void windowClosing(WindowEvent we) {
		System.out.println("Window is closing");
		System.exit(0);
	}
}
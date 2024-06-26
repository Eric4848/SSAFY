import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Lighting;
import org.opentutorials.iot.Security;

public class OkJavaGoingHome {

	public static void main(String[] args) {
		
		String id = "Java APT 507";
		
		// Elevator Call
		Elevator myElevator = new Elevator(id);
		myElevator.callForUp(1);
		
		// Security Off
		Security mySecurity = new Security(id);
		mySecurity.off();
		
		// Lights On
		Lighting hallLamp = new Lighting("Java APT 507 / Hall Lamp");
		hallLamp.on();

		Lighting floorLamp = new Lighting(id+" / Floor Lamp");
		floorLamp.on();

	}

}

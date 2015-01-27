package phoenix.patterns;

import phoenix.patterns.p07Adapter.ClassPowerAdapter;
import phoenix.patterns.p07Adapter.IThreeHoles;
import phoenix.patterns.p07Adapter.ObjectPowerAdapter;
import phoenix.patterns.p07Adapter.ObjectThreeHoles;

public class AdapterPatternTest {

	public static void main(String[] args) {
		IThreeHoles th = new ClassPowerAdapter();
		th.threeHolesRequest();

		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");

		// use object-type
		ObjectThreeHoles othr = new ObjectPowerAdapter();
		othr.SpecificRequest();
	}

}

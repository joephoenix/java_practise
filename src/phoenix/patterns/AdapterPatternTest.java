package phoenix.patterns;

import phoenix.patterns.p08Adapter.IThreeHoles;
import phoenix.patterns.p08Adapter.ClassPowerAdapter;
import phoenix.patterns.p08Adapter.ObjectPowerAdapter;
import phoenix.patterns.p08Adapter.ObjectThreeHoles;

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

package phoenix.patterns;

import phoenix.patterns.p09Bridge.ChangHong;
import phoenix.patterns.p09Bridge.ConcreteRemote;
import phoenix.patterns.p09Bridge.RemoteControl;
import phoenix.patterns.p09Bridge.Samsung;

public class BridgeTest {

	public static void main(String[] args) {
		RemoteControl rc = new ConcreteRemote();
		rc.setImplementor(new ChangHong());
		rc.On();
		rc.SetChannel();
		rc.Off();

		System.out.println();
		System.out.println("------change to another Televersion-------");
		System.out.println();

		rc.setImplementor(new Samsung());
		rc.On();
		rc.SetChannel();
		rc.Off();
	}

}

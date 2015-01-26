package phoenix.patterns.p09Bridge;

public class ConcreteRemote extends RemoteControl {

	@Override
	public void SetChannel() {
		System.out.println("-----------------------");
		super.SetChannel();
		System.out.println("-----------------------");
	}

}

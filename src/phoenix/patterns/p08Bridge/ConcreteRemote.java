package phoenix.patterns.p08Bridge;

public class ConcreteRemote extends RemoteControl {

	@Override
	public void SetChannel() {
		System.out.println("-----------------------");
		super.SetChannel();
		System.out.println("-----------------------");
	}

}

package phoenix.patterns.p09Bridge;

public class RemoteControl {

	private Televersion implementor;

	public Televersion getImplementor() {
		return implementor;
	}

	public void setImplementor(Televersion implementor) {
		this.implementor = implementor;
	}

	public void On() {
		implementor.On();
	}

	public void Off() {
		implementor.Off();
	}

	public void SetChannel() {
		implementor.turnChannel();
	}

}

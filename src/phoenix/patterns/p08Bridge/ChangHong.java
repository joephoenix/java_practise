package phoenix.patterns.p08Bridge;

public class ChangHong extends Televersion {

	@Override
	public void On() {
		System.out.println("Chang Hong TV is open!");
	}

	@Override
	public void Off() {
		System.out.println("Chang Hong TV is close!");
	}

	@Override
	public void turnChannel() {
		System.out.println("Chang Hong TV is change channel!");
	}

}

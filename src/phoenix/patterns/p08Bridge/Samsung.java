package phoenix.patterns.p08Bridge;

public class Samsung extends Televersion {

	@Override
	public void On() {
		System.out.println("Samsung TV is open!");
	}

	@Override
	public void Off() {
		System.out.println("Samsung TV is close!");
	}

	@Override
	public void turnChannel() {
		System.out.println("Samsung TV is change channel!");
	}

}

package phoenix.patterns.p02SimpleFactory;

public class ShreddedPorkWithPotatoes extends Food {

	@Override
	public void cookFood() {
		System.out.println("Cut the potatoes into many shreds");
		System.out.println("Put the shreddedPotatoes into "
				+ "halloware and scramble them");
		System.out.println("After shreddedPotatoes had done, "
				+ "put the shreddedpork into");
		System.out.println("The food is done, Gain them out");
	}

}

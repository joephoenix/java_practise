package phoenix.patterns.p08Adapter;

public class ObjectPowerAdapter extends ObjectThreeHoles {
	public ObjectTwoHoles oth = new ObjectTwoHoles();

	@Override
	public void SpecificRequest() {
		super.SpecificRequest();
		System.out.println("change three holes to three holes with adapter");
		oth.SpecificRequest();
	}
}

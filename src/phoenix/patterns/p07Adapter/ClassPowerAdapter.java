package phoenix.patterns.p07Adapter;

public class ClassPowerAdapter extends ClassTwoHoles implements IThreeHoles {
	@Override
	public void threeHolesRequest() {
		System.out.println("Here is the base with three holes");
		this.SpecificRequest();
		System.out.println("three holes worked like two holes");
	}

}

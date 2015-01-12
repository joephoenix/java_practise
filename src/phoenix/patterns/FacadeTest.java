package phoenix.patterns;

import phoenix.patterns.p11Facade.RegistrationFacade;

public class FacadeTest {

	private static RegistrationFacade facade = new RegistrationFacade();

	public static void main(String[] args) {
		if (facade.RegisterCourse("Mathematics", "john smith")) {
			System.out.println("choose class successfully!");
		} else {
			System.out.println("choose class failed!");
		}
	}

}

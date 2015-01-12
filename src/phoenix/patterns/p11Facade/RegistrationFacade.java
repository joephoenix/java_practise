package phoenix.patterns.p11Facade;

public class RegistrationFacade {

	private RegisterCourse rc;
	private NotifyStudent ns;

	public RegistrationFacade() {
		rc = new RegisterCourse();
		ns = new NotifyStudent();
	}

	public boolean RegisterCourse(String courseName, String studentName) {
		if (!rc.checkAvailable(courseName)) {
			return false;
		}

		return ns.notify(studentName);
	}
}

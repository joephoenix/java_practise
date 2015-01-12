package phoenix.patterns.p11Facade;

public class NotifyStudent {

	public boolean notify(String studentName) {
		System.out.println("send the message to student " + studentName);
		return true;
	}
}

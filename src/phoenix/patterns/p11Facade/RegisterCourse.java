package phoenix.patterns.p11Facade;

import java.util.HashMap;
import java.util.Map;

public class RegisterCourse {

	private Map<String, Integer> classInfo = new HashMap<String, Integer>();

	public RegisterCourse() {
		classInfo.put("Design Pattern", 11);
		classInfo.put("Mathematics", 7);
	}

	public boolean checkAvailable(String courseName) {
		if (classInfo.get(courseName) == null) {
			System.out.println("The course " + courseName
					+ " you wanted to attend is not avialable!");
			System.out.println();
			return false;
		} else if (classInfo.get(courseName) > 10) {
			System.out.println("check the course " + courseName
					+ " is have enough student");
			System.out.println();
			return false;
		} else {
			System.out.println("Check the course " + courseName
					+ " is that you could be attendance");
			chooseClass(courseName);
			System.out.println();
			System.out.println("The course " + courseName + " had "
					+ classInfo.get(courseName) + " students now!");
			System.out.println();
			return true;
		}
	}

	public void chooseClass(String courseName) {
		if (classInfo.get(courseName) == null) {
			classInfo.put(courseName, 1);
		} else {
			int persons = classInfo.get(courseName);
			classInfo.put(courseName, persons + 1);
		}
	}

}

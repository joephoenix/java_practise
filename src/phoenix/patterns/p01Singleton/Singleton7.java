package phoenix.patterns.p01Singleton;

public class Singleton7 {

	private volatile static Singleton7 singleton;

	private Singleton7() {
	}

	public static Singleton7 getSingleton() {
		if (singleton == null) {
			synchronized (Singleton7.class) {
				if (singleton == null) {
					singleton = new Singleton7();
				}
			}
		}
		return singleton;
	}

	/*** Servlet访问的解决 ***/
	@SuppressWarnings("unused")
	private static Class getClass(String classname)
			throws ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();

		if (classLoader == null) {
			classLoader = Singleton7.class.getClassLoader();
			return (classLoader.loadClass(classname));
		} else {
			return null;
		}
	}
}

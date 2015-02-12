package phoenix.patterns.p01Singleton;

/***
 * singleton的序列化
 */
public class Singleton8 implements java.io.Serializable {

	public static Singleton8 INSTANCE = new Singleton8();

	protected Singleton8() {

	}

	private Object readResolve() {
		return INSTANCE;
	}

}

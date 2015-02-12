package phoenix.patterns.p01Singleton;

/*** 枚举的方式 ***/
public enum Singleton6 {
	INSTANCE;

	public Singleton6 getInstance() {
		return Singleton6.INSTANCE;
	}
}

/***
 * 这种方式是Effective Java作者Josh Bloch
 * 提倡的方式，它不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象，可谓是很坚强的壁垒啊
 ***/

package phoenix.patterns.p01Singleton;

/*** 静态内部类 ***/
public class Singleton5 {

	private static class SingletonHolder {
		private static final Singleton5 INSTANCE = new Singleton5();
	}

	private Singleton5() {
	}

	public static final Singleton5 getInstance() {
		return SingletonHolder.INSTANCE;
	}

}

/***
 * 这种方式同样利用了classloder的机制来保证初始化instance时只有一个线程，它跟第三种和第四种方式不同的是（很细微的差别）：
 * 
 * 第三种和第四种方式是只要Singleton类被装载了，那么instance就会被实例化（没有达到lazy
 * loading效果），而这种方式是Singleton类被装载了，instance不一定被初始化。
 * 
 * 因为SingletonHolder类没有被主动使用，只有显示通过调用getInstance方法时，才会显示装载SingletonHolder类，
 * 从而实例化instance。
 ***/

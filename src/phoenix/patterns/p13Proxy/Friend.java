package phoenix.patterns.p13Proxy;

/**
 * 代理角色
 * 
 * @author joephoenix
 *
 */
public class Friend extends Person {

	RealBuyPerson reality;

	@Override
	public void BuyProduct() {
		System.out.println("access real entry's function with proxy object");

		if (reality == null) {
			reality = new RealBuyPerson();
		}
		// 代理的操作
		this.preBuyProduct();
		// 真实主题类的操作方法
		reality.BuyProduct();
		// 代理的操作
		this.postBuyProduct();
	}

	/**
	 * 代理角色执行的操作，买之前
	 */
	public void preBuyProduct() {
		System.out.println("I had been afraid for boring, so had write a list");
		System.out.println("A:camera");
		System.out.println("B:Iphone");
	}

	/**
	 * 代理角色执行的操作，买之后
	 */
	public void postBuyProduct() {
		System.out.println("I have buying finished,should to orginaze them.");
		System.out.println("camera is A's");
		System.out.println("Iphone is B's");
	}

}

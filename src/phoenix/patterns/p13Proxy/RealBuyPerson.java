package phoenix.patterns.p13Proxy;

/**
 * 真是主题角色
 * 
 * @author joephoenix
 *
 */
public class RealBuyPerson extends Person {

	@Override
	public void BuyProduct() {
		System.out.println();
		System.out.println("help me buy iphone and Mac");
		System.out.println();
	}

}

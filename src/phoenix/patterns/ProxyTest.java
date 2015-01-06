package phoenix.patterns;

import phoenix.patterns.p13Proxy.Friend;
import phoenix.patterns.p13Proxy.Person;

public class ProxyTest {

	public static void main(String[] args) {
		Person proxy = new Friend();
		proxy.BuyProduct();
	}

}

package phoenix.patterns;

import phoenix.patterns.p06Prototype.ConcretePrototype;
import phoenix.patterns.p06Prototype.MonkeyKingPrototype;

public class PrototypeTest {

	public static void main(String[] args) {
		MonkeyKingPrototype pmk = new ConcretePrototype("qitiandasheng");
		MonkeyKingPrototype hair1 = pmk.command();
		System.out.println("the first monkey form hair " + hair1.getId());
		System.out.println("----------------------------------");
		MonkeyKingPrototype hair2 = pmk.command();
		System.out.println("the second monkey form hair " + hair2.getId());
		System.out.println("----------------------------------");
	}
}

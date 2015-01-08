package phoenix.patterns;

import phoenix.patterns.P12Flyweight.ConcreteFlyweight;
import phoenix.patterns.P12Flyweight.Flyweight;
import phoenix.patterns.P12Flyweight.FlyweightFactory;

public class FlyweightTest {

	public static void main(String[] args) {
		int externalState = 10;
		FlyweightFactory factory = new FlyweightFactory();
		Flyweight fwa = factory.GetFlyweight("A");
		if (fwa != null) {
			fwa.operation(--externalState);
		}
		Flyweight fwb = factory.GetFlyweight("B");
		if (fwb != null) {
			fwb.operation(--externalState);
		}
		Flyweight fwc = factory.GetFlyweight("C");
		if (fwc != null) {
			fwc.operation(--externalState);
		}
		Flyweight fwd = factory.GetFlyweight("D");
		if (fwd != null) {
			fwd.operation(--externalState);
		} else {
			ConcreteFlyweight d = new ConcreteFlyweight("D");
			factory.flyweights.put("D", d);
		}
	}

}

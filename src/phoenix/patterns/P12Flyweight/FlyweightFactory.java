package phoenix.patterns.P12Flyweight;

import java.util.Hashtable;

/**
 * 享元工厂，负责创建和管理享元
 * 
 * @author joephoenix
 *
 */
public class FlyweightFactory {
	//
	public Hashtable<String, Flyweight> flyweights = new Hashtable<String, Flyweight>();

	public FlyweightFactory() {
		flyweights.put("A", new ConcreteFlyweight("A"));
		flyweights.put("B", new ConcreteFlyweight("B"));
		flyweights.put("C", new ConcreteFlyweight("C"));
	}

	// 返回享元对象
	public Flyweight GetFlyweight(String key) {
		Flyweight fw = (Flyweight) flyweights.get(key);
		if (fw == null) {
			System.out.println("there are no String in the memory -- " + key);
			fw = new ConcreteFlyweight(key);
			return fw;
		} else {
			return fw;
		}
	}

}

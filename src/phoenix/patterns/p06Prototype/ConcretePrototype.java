package phoenix.patterns.p06Prototype;

public class ConcretePrototype extends MonkeyKingPrototype {

	public ConcretePrototype(String id) {
		super(id);
	}

	@Override
	public MonkeyKingPrototype command() {

		return (MonkeyKingPrototype) new ConcretePrototype(id);
	}

}

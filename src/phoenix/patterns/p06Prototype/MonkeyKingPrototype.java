package phoenix.patterns.p06Prototype;

public abstract class MonkeyKingPrototype {
	public String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MonkeyKingPrototype(String id) {
		this.id = id;
	}

	public abstract MonkeyKingPrototype command();
}

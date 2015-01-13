package phoenix.patterns.p10Composite;

public abstract class Graphics {
	public String name;
	public String parent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public Graphics(String name, String parent) {
		this.name = name;
		this.parent = parent;
	}

	public abstract void Draw();

	// public abstract void Add(Graphics g);

	// public abstract void Remove(Graphics g);
}

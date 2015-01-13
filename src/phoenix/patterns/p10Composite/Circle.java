package phoenix.patterns.p10Composite;

public class Circle extends Graphics {

	public Circle(String name, String parent) {
		super(name, parent);
	}

	@Override
	public void Draw() {
		System.out.println("Draw " + name + " in graphics " + parent);
	}
}

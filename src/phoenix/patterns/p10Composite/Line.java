package phoenix.patterns.p10Composite;

public class Line extends Graphics {

	public Line(String name, String parent) {
		super(name, parent);
	}

	@Override
	public void Draw() {
		System.out.println("Draw " + name + " in graphics " + parent);
	}
}

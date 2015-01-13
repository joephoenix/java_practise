package phoenix.patterns.p10Composite;

import java.util.ArrayList;
import java.util.List;

public class ComplexGraphics extends Graphics {

	public List<Graphics> complexGraphicsList = new ArrayList<Graphics>();

	public ComplexGraphics(String name, String parent) {
		super(name, parent);
	}

	@Override
	public void Draw() {
		for (Graphics g : complexGraphicsList) {
			g.Draw();
		}
	}

	public void Add(Graphics g) {
		complexGraphicsList.add(g);
	}

	public void Remove(Graphics g) {
		complexGraphicsList.remove(g);
	}

}

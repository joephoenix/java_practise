package phoenix.patterns;

import phoenix.patterns.visitor.ConcreteVisitor;
import phoenix.patterns.visitor.Element;
import phoenix.patterns.visitor.ObjectStructure;

public abstract class VisitorTest {

	public static void main(String[] args) {
		// 访问者模式测试
		ObjectStructure os = new ObjectStructure();
		for (Element e : os.getElements()) {
			e.Accept(new ConcreteVisitor());
		}
	}

}

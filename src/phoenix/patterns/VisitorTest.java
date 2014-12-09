package phoenix.patterns;

import phoenix.patterns.p22Visitor.ConcreteVisitor;
import phoenix.patterns.p22Visitor.Element;
import phoenix.patterns.p22Visitor.ObjectStructure;

public abstract class VisitorTest {

	public static void main(String[] args) {
		// 访问者模式测试
		ObjectStructure os = new ObjectStructure();
		for (Element e : os.getElements()) {
			e.Accept(new ConcreteVisitor());
		}
	}

}

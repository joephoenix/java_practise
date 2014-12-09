package phoenix.patterns.p22Visitor;

public class ConcreteVisitor implements IVisitor {

	@Override
	public void Visitor(ElementA a) {
		a.Print();
	}

	@Override
	public void Visitor(ElementB b) {
		b.Print();
	}

}

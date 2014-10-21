package phoenix.patterns.visitor;

public class ElementA extends Element {

	@Override
	public void Print() {
		System.out.println("I'm element A");
	}

	@Override
	public void Accept(IVisitor visitor) {
		visitor.Visitor(this);
	}

}

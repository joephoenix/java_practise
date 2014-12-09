package phoenix.patterns.p22Visitor;

public class ElementB extends Element {

	@Override
	public void Print() {
		System.out.println("I'm element B");
	}

	@Override
	public void Accept(IVisitor visitor) {
		visitor.Visitor(this);
	}

}

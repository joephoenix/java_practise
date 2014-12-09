package phoenix.patterns.p22Visitor;

public abstract class Element {
	public abstract void Accept(IVisitor visitor);

	public abstract void Print();
}

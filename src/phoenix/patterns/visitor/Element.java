package phoenix.patterns.visitor;

public abstract class Element {
	public abstract void Accept(IVisitor visitor);

	public abstract void Print();
}

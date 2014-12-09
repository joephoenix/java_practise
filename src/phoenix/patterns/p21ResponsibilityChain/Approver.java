package phoenix.patterns.p21ResponsibilityChain;

public abstract class Approver {

	public Approver next;

	public String name;

	public Approver(String name) {
		this.name = name;
	}

	public abstract void ProcessRequest(PurchaseRequest req);

	public Approver getNext() {
		return next;
	}

	public void setNext(Approver next) {
		this.next = next;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

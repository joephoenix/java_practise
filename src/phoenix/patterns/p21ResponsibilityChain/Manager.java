package phoenix.patterns.p21ResponsibilityChain;

public class Manager extends Approver {

	public Manager(String name) {
		super(name);
	}

	@Override
	public void ProcessRequest(PurchaseRequest req) {
		if (req.amout < 10000) {
			System.out.println(this.name + " approver the request of purshing "
					+ req.getProductName());
		} else {
			if (this.next != null) {
				this.next.ProcessRequest(req);
			} else {
				System.out.println("We Need a conference to discuss!");
			}
		}
	}

}

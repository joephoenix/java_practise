package phoenix.patterns.ResponsibilityChain;

public class VicePresident extends Approver {

	public VicePresident(String name) {
		super(name);
	}

	@Override
	public void ProcessRequest(PurchaseRequest req) {
		if (req.amout < 25000) {
			System.out.println(this.name + " approver the request of purshing "
					+ req.getProductName());
		} else {
			if (next != null) {
				next.ProcessRequest(req);
			} else {
				System.out.println("We Need a conference to discuss!");
			}
		}
	}

}

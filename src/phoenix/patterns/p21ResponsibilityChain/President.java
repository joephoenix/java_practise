package phoenix.patterns.p21ResponsibilityChain;

public class President extends Approver {

	public President(String name) {
		super(name);
	}

	@Override
	public void ProcessRequest(PurchaseRequest req) {
		if (req.amout < 100000) {
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

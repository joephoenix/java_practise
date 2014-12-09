package phoenix.patterns.p21ResponsibilityChain;

public class RespnosiblityChain {

	public void chainProccess() {
		PurchaseRequest telephone = new PurchaseRequest(4000, "Telephone");
		PurchaseRequest softwares = new PurchaseRequest(10000, "Softwares");
		PurchaseRequest computers = new PurchaseRequest(40000, "Computers");
		PurchaseRequest workhorse = new PurchaseRequest(400000, "workhorse");

		// set the responsibility chain
		Approver manager = new Manager("Joe Smith");
		Approver vicePre = new VicePresident("Tony Max");
		Approver mainPre = new President("John Gerdon");
		manager.next = vicePre;
		vicePre.next = mainPre;

		// deal the request
		manager.ProcessRequest(telephone);
		manager.ProcessRequest(softwares);
		manager.ProcessRequest(computers);
		manager.ProcessRequest(workhorse);
	}

}

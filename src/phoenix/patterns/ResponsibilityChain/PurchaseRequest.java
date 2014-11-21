package phoenix.patterns.ResponsibilityChain;

public class PurchaseRequest {
	public double amout;

	public String productName;

	public PurchaseRequest(double amout, String pn) {
		this.amout = amout;
		this.productName = pn;
	}

	public double getAmout() {
		return amout;
	}

	public void setAmout(double amout) {
		this.amout = amout;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}

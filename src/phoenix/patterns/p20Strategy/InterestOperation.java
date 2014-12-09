package phoenix.patterns.p20Strategy;

public class InterestOperation {

	private ITaxStrategy st_tax;

	public InterestOperation(ITaxStrategy its) {
		this.st_tax = its;
	}

	public double GetTax(double income) {
		return st_tax.CalculateTax(income);
	}
}

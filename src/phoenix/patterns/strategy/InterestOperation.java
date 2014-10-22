package phoenix.patterns.strategy;

public class InterestOperation {

	private ITaxStrategy st_tax;

	public InterestOperation(ITaxStrategy its) {
		this.st_tax = its;
	}

	public double GetTax(double income) {
		return st_tax.CalculateTax(income);
	}

	public static void main(String[] args) {
		InterestOperation iop = new InterestOperation(new PersonalTaxStrategy());
		System.out.println(iop.GetTax(5000));

		InterestOperation ioe = new InterestOperation(
				new EnterpriseTaxStrategy());
		System.out.println(ioe.GetTax(50000));
	}

}

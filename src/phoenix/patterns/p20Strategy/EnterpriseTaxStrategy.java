package phoenix.patterns.p20Strategy;

public class EnterpriseTaxStrategy implements ITaxStrategy {

	@Override
	public double CalculateTax(double income) {
		return income * 0.12;
	}

}

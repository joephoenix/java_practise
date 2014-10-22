package phoenix.patterns.strategy;

public class EnterpriseTaxStrategy implements ITaxStrategy {

	@Override
	public double CalculateTax(double income) {
		return income * 0.12;
	}

}

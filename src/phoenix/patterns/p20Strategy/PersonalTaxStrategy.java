package phoenix.patterns.p20Strategy;

public class PersonalTaxStrategy implements ITaxStrategy {

	@Override
	public double CalculateTax(double income) {
		return (income - 3500) > 0 ? (income - 3500) * 0.045 : 0.0;
	}

}

package phoenix.patterns;

import phoenix.patterns.p20Strategy.EnterpriseTaxStrategy;
import phoenix.patterns.p20Strategy.InterestOperation;
import phoenix.patterns.p20Strategy.PersonalTaxStrategy;

public class StrategyTest {

	public static void main(String[] args) {
		// 策略模式测试
		InterestOperation iop = new InterestOperation(new PersonalTaxStrategy());
		System.out.println(iop.GetTax(5000));

		InterestOperation ioe = new InterestOperation(
				new EnterpriseTaxStrategy());
		System.out.println(ioe.GetTax(50000));
	}

}

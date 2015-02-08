package phoenix.patterns;

import phoenix.patterns.p04AbstractFactory.AbstractFactory;
import phoenix.patterns.p04AbstractFactory.HuNanFactory;
import phoenix.patterns.p04AbstractFactory.NanChangeFactory;
import phoenix.patterns.p04AbstractFactory.ShangHaiFactory;
import phoenix.patterns.p04AbstractFactory.YaBo;
import phoenix.patterns.p04AbstractFactory.YaJia;

public class AbstractFactoryTest {

	public static void main(String[] args) {

		// factory in nanchang
		AbstractFactory ncfactory = new NanChangeFactory();
		YaBo ncYaBo = ncfactory.createYaBo();
		ncYaBo.yanzhi();
		YaJia ncYaJia = ncfactory.createYaJia();
		ncYaJia.baoTang();

		// --------------------------------------------
		System.out.println("***************************************");
		System.out.println("create yazi in another factory!");
		System.out.println("***************************************");
		// ---------------------------------------------

		// factory in shanghai
		AbstractFactory shfactory = new ShangHaiFactory();
		YaBo shYaBo = shfactory.createYaBo();
		shYaBo.yanzhi();
		YaJia shYaJia = shfactory.createYaJia();
		shYaJia.baoTang();

		// --------------------------------------------
		System.out.println("***************************************");
		System.out.println("create yazi in middle china factory!");
		System.out.println("***************************************");
		// ---------------------------------------------

		// factory in changsha
		AbstractFactory csfactory = new HuNanFactory();
		YaBo hnYaBo = csfactory.createYaBo();
		hnYaBo.yanzhi();
		YaJia hnYaJia = csfactory.createYaJia();
		hnYaJia.baoTang();
	}
}

package phoenix.patterns;

import phoenix.patterns.p05Builder.Builder;
import phoenix.patterns.p05Builder.Computer;
import phoenix.patterns.p05Builder.ConcreteBuilderA;
import phoenix.patterns.p05Builder.ConcreteBuilderB;
import phoenix.patterns.p05Builder.Director;

public class BuilderTest {

	public static void main(String[] args) {
		// 构造指挥者和构造者
		Director director = new Director();

		Builder b1 = new ConcreteBuilderA();
		Builder b2 = new ConcreteBuilderB();

		// composite the first computer
		director.Construct(b1);

		// complete and show the first computer
		Computer c1 = b1.getComputer();
		c1.show();

		System.out.println("----------------------");
		System.out.println("----------------------");

		// composite the seconde computer
		director.Construct(b2);
		Computer c2 = b2.getComputer();
		c2.show();

	}
}

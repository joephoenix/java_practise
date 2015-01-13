package phoenix.patterns;

import phoenix.patterns.p10Composite.Circle;
import phoenix.patterns.p10Composite.ComplexGraphics;
import phoenix.patterns.p10Composite.Line;

public class CompositeTest {

	public static void main(String[] args) {
		ComplexGraphics cg1 = new ComplexGraphics(
				"a Complex Graphics that had " + "a cg and two lines", "cg1");
		cg1.Add(new Line("Line A", "cg1"));
		ComplexGraphics cg2 = new ComplexGraphics(
				"a Complex Graphics that had " + "a line and a circle", "cg2");
		cg2.Add(new Line("Line B", "cg2"));
		cg2.Add(new Circle("Circle A", "cg2"));
		cg1.Add(cg2);
		Line lc = new Line("Line C", "cg1");
		cg1.Add(lc);

		// 显示复杂图形的画法
		System.out.println("-------------------------------");
		cg1.Draw();
		System.out.println("-------------------------------");

		System.out.println();
		System.out.println();
		// 移除一个组件并画出复杂图形
		System.out.println("-------------------------------");
		cg1.Remove(lc);
		cg1.Draw();
		System.out.println("-------------------------------");
	}

}

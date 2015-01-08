package phoenix.patterns.P12Flyweight;

/**
 * 具体享元类，实现抽象享元类提供方法，减少方法的声明操作
 * 
 * @author joephoenix
 *
 */
public class ConcreteFlyweight extends Flyweight {

	private String intrinsicstate;

	// 构造函数
	public ConcreteFlyweight(String innerState) {
		this.intrinsicstate = innerState;
	}

	@Override
	public void operation(int extrinsicstate) {
		System.out.println("Concrete class : intrinsicstate " + intrinsicstate
				+ ", extrinsicstate : " + extrinsicstate);
	}

}

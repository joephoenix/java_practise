package phoenix.InheritanceTest;

/**
 * 如果存在一种IS-A的关系（比如Bee“是一个”Insect），并且一个类需要向另一个类暴露所有的方法接口，那么更应该用继承的机制。
 * 如果存在一种HAS-A的关系（比如Bee“有一个”attack功能），那么更应该运用组合。
 * 总结来说，继承和组合都有他们的用处。只有充分理解各对象和功能之间的关系，才能充分发挥这两种机制各自的优点。
 * 
 * @author chenxianxun
 *
 */
public class InheritanceVSComposition {
	public static void main(String[] args) {
		Bee a = new Bee(1, "green", new AttackImpl("fly", "move"));
		a.attack();

		// if you need another implementation of move()
		// there is no need to change Insect,
		// we can quickly use new method to attack

		Bee b = new Bee(2, "red", new AttackImpl("fly", "Sting"));
		b.attack();
	}
}

package phoenix.InheritanceTest;

/**
 * �������һ��IS-A�Ĺ�ϵ������Bee����һ����Insect��������һ������Ҫ����һ���౩¶���еķ����ӿڣ���ô��Ӧ���ü̳еĻ��ơ�
 * �������һ��HAS-A�Ĺ�ϵ������Bee����һ����attack���ܣ�����ô��Ӧ��������ϡ�
 * �ܽ���˵���̳к���϶������ǵ��ô���ֻ�г����������͹���֮��Ĺ�ϵ�����ܳ�ַ��������ֻ��Ƹ��Ե��ŵ㡣
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

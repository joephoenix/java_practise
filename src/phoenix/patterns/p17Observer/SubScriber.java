package phoenix.patterns.p17Observer;

/**
 * 订阅者
 * 
 * @author chenxianxun
 *
 */
public class SubScriber implements IObserver {
	public String name;

	public SubScriber(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void ReceiveAndPrint(Company com) {
		System.out.println("Notified: Hi, dear player " + name + " of "
				+ com.symbol + ", " + com.symbol + " " + com.info);
	}
}

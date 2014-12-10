package phoenix.patterns.p17Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Company {
	// 订阅者列表
	private List<IObserver> obs = new ArrayList<IObserver>();

	// 订阅信息
	public String symbol;
	public String info;

	public Company(String symbol, String info) {
		this.symbol = symbol;
		this.info = info;
	}

	// 添加订阅者
	public void addObserver(IObserver ob) {
		obs.add(ob);
	}

	// 移除订阅者
	public void removeObserver(IObserver ob) {
		obs.remove(ob);
	}

	// 更新订阅通知
	public void update() {
		for (IObserver ob : obs) {
			if (ob != null) {
				ob.ReceiveAndPrint(this);
			}
		}
	}
}

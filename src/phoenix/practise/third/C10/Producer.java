package phoenix.practise.third.C10;

/**
 * 生产者类，提供多线程的处理，可以并发生产
 * 
 * @author joephoenix
 * 
 */
public class Producer extends Thread {
	// 定义一个Queue队列
	private Queue queue;

	// 初始化queue
	Producer(Queue queue) {
		this.queue = queue;
	}

	// 实现Thread的run()方法
	public void run() {
		while (true) {
			// 建立一个message，并为message初始化
			Message message = new Message();
			message.setId(++Message.id);
			message.setContent("food" + Message.id);
			// 调用队列中的生产方法，生产产品，不可中断
			queue.produce(message);
			try {
				// 生产者每隔100毫秒睡眠一次，给其他线程运行的机会
				sleep(100);
			} catch (Exception e) {
			}
		}
	}
}

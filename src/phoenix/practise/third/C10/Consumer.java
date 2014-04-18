package phoenix.practise.third.C10;

/**
 * 消费者类，具有多线程并发操作
 * 
 * @author joephoenix
 * 
 */
public class Consumer extends Thread {
	// 定义消费者的queue队列
	private Queue queue;

	// 该队列操作的实际上与生产者同一个队列
	Consumer(Queue queue) {
		this.queue = queue;
	}

	// 实现多线程的run方法
	public void run() {
		while (true) {
			// consume方法从队列中取数据，该方法通过添加synchronized关键字实现原子操作，
			// 即操作过程中不允许其他线程中断
			queue.consume();
			try {
				// 执行完consume方法，该线程每隔100毫秒进入睡眠状态，
				// 将cpu的使用权给其他线程
				sleep(100);
			} catch (Exception e) {
			}
		}
	}
}

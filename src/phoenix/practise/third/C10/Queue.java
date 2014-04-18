package phoenix.practise.third.C10;

import java.util.ArrayList;
import java.util.List;

/**
 * 队列类
 * 
 * @author joephoenix
 * 
 */
public class Queue {
	// Queue
	// 通过一个list类型的数据结构存放管理生产者产生的数据，并让消费者从中取数据
	List<Message> queue = new ArrayList<Message>();

	// 队列中message对象的最大值,默认为5
	int maxMessageNum = 5;

	/**
	 * 该方法通过添加synchronized关键字实现原子操作，即该方法执行过程中不允许中断
	 * 
	 * 同步数据处理
	 * 
	 * @param message
	 */
	public synchronized void produce(Message message) {

		// 当有多个生产者线程处于等待中时，这个方法唤醒所有处于睡眠中的生产者线程，
		// 但是唤醒的生产者线程并不会马上获得运行机会，而是处于就绪状态，等待cpu资源
		this.notifyAll();// 就绪
		while (queue.size() == maxMessageNum) {
			// 当队列中没有多余的存储空间时，输出“队列满！等待中”，
			// 并且进入等待状态，并且放弃cpu资源
			System.out.println(Thread.currentThread().getName()
					+ "  队列满！等待中。。。");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 当队列中有空闲的位置存放数据时，向队列中添加数据，
		// 并且输出当前队列中可用的资源
		queue.add(message);
		System.out.println(Thread.currentThread().getName() + "正在生产"
				+ message.getContent() + "。。。  ,当前个数:" + getCount());

	}

	/**
	 * 消费方法，消费线程 采用同步控制
	 */
	public synchronized void consume() {

		// 当有多个消费者线程处于等待中时，这个方法唤醒所有处于睡眠中的消费者线程，
		// 但是唤醒的消费者线程并不会马上获得运行机会，而是处于就绪状态，等待cpu资源
		this.notifyAll();
		while (queue.size() == 0) {
			// 当队列中没有可取用的数据时，输出“队列空！等待中”，
			// 并且进入等待状态，并且放弃cpu资源
			System.out.println(Thread.currentThread().getName()
					+ "  队列空！等待中。。。");
			try {
				System.out.println("begin!");
				wait();
				System.out.println("end!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 当队列中有数据时，从队列中取数据，
		// 并且输出当前队列中可用的资源
		Message message = queue.get(0);
		queue.remove(0);
		System.out.println(Thread.currentThread().getName() + "正在消费"
				+ message.getContent() + "。。。 ,当前个数: " + getCount());

	}

	/**
	 * 读取队列的总数，也是同步控制，保证数量正确
	 * 
	 * @return
	 */
	public synchronized int getCount() {
		// 该方法通过添加synchronized关键字实现原子操作，
		// 即该方法执行过程中不允许中断
		return queue.size();
	}

}

package phoenix.practise.third.C10;

public class TestQueue {

	public static void main(String[] args) {
		Queue Q = new Queue();

		Producer wQ1 = new Producer(Q);
		Producer wQ2 = new Producer(Q);

		Consumer rQ1 = new Consumer(Q);
		Consumer rQ2 = new Consumer(Q);
		Consumer rQ3 = new Consumer(Q);

		Thread threadWQ1 = new Thread(wQ1, "thread-wQ1");
		Thread threadWQ2 = new Thread(wQ2, "thread-wQ2");

		Thread threadRQ1 = new Thread(rQ1, "thread-rQ1");
		Thread threadRQ2 = new Thread(rQ2, "thread-rQ2");
		Thread threadRQ3 = new Thread(rQ3, "thread-rQ3");

		threadWQ1.start();
		threadWQ2.start();

		threadRQ1.start();
		threadRQ2.start();
		threadRQ3.start();
	}

}

package phoenix.collect;

public class DeadlockSample {

	private final Object obj1 = new Object();
	private final Object obj2 = new Object();

	public static void main(String[] args) {
		DeadlockSample test = new DeadlockSample();
		test.testDeadlock();
	}

	private void testDeadlock() {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				callLock12();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				callLock21();
			}
		});

		t1.start();
		t2.start();
	}

	private void callLock12() {
		synchronized (obj1) {
			sleep(1);
			synchronized (obj2) {
				sleep(2);
			}
		}
	}

	private void callLock21() {
		synchronized (obj2) {
			sleep(2);
			synchronized (obj1) {
				sleep(1);
			}
		}
	}

	private void sleep(int number) {
		try {
			System.out.println("The obj" + number + " is begin sleep!");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

package phoenix.collect;

import java.util.ArrayList;
import java.util.List;

public class PigItThePython {

	static volatile List<byte[]> pigs = new ArrayList<byte[]>();
	static volatile int pigsEaten = 0;
	static final int ENOUGH_PIGS = 5000;

	static class PigEater extends Thread {
		@Override
		public void run() {
			while (true) {
				pigs.add(new byte[32 * 1024 * 1024]);
				if (pigsEaten > ENOUGH_PIGS) {
					return;
				}
				takeANap(100);
			}
		}
	}

	static class PigDigester extends Thread {
		@Override
		public void run() {
			long start = System.currentTimeMillis();

			while (true) {
				takeANap(2000);
				pigsEaten += pigs.size();
				pigs = new ArrayList<byte[]>();
				if (pigsEaten > ENOUGH_PIGS) {
					System.out.format("Digested %d pigs in %d ms.%n",
							pigsEaten, System.currentTimeMillis() - start);
					return;
				}
			}
		}
	}

	static void takeANap(int ms) {
		try {
			Thread.sleep(ms);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new PigEater().start();
		new PigDigester().start();
	}
}

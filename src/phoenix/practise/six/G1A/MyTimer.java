package phoenix.practise.six.G1A;

public class MyTimer extends Thread {
	GameCanvas scr;

	public MyTimer(GameCanvas scr) {
		this.scr = scr;
	}

	public void run() {
		while (true) {
			try {
				sleep((10 - ERS_Block.level + 1) * 100);
			} catch (InterruptedException e) {
			}
			if (!scr.getBlock().fallDown()) {
				scr.deleteFullLine();
				if (scr.isGameEnd()) {
					ERS_Block.isPlay = false;
					suspend();
				} else
					scr.getBlock().reset();
			}
		}
	}
}

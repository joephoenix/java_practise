package phoenix.practise.fifthLowerPart.F31;

import java.applet.Applet;
import java.awt.*;
import java.net.URL;

public class FirePicApplet extends Applet implements Runnable {

	// 声明属性
	private Image backImage, foreImage;
	private Image image, fireImage;
	private Graphics graphics, fireGraphics;
	private Thread thread;
	private MediaTracker imageTracker;
	private int height, width;

	public void init() {
		Dimension dim = getSize();
		width = dim.width;
		height = dim.height;

		// 图片存放的url
		URL url = getClass().getResource("/images/F31/");
		// 得到图片
		backImage = getImage(url, "back.jpg");
		foreImage = getImage(url, "fore.jpg");

		// 实例化MediaTracker对象
		imageTracker = new MediaTracker(this);
		imageTracker.addImage(backImage, 0);
		imageTracker.addImage(foreImage, 0);

		try {
			// 装载图片
			imageTracker.waitForID(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 得到Image对象实例
		image = createImage(width, height);
		graphics = image.getGraphics();
		fireImage = createImage(width * 2, height * 2);
		fireGraphics = fireImage.getGraphics();
	}

	// 运行线程
	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	// 主线程运行
	public void run() {
		int x = 0, y = 0;

		int tileWidth = backImage.getWidth(this);
		int tileHeight = backImage.getHeight(this);

		int foreWidth = foreImage.getWidth(this);
		int foreHeight = foreImage.getHeight(this);

		while (thread != null) {
			// x位置是火焰图片的宽度减去applet的宽度
			// y位置是火焰图片的高度减去applent的高度
			x = fireImage.getWidth(this) - width;
			y = fireImage.getHeight(this) - height;
			// 当x>0和y>0的话，x和y各减一，然后循环
			for (; (x > 0) && (y > 0); x--, y--) {
				// 如果x或者y等于0，则从新开始
				if ((x == 0) || (y == 0)) {
					x = fireImage.getWidth(this) - width;
					y = fireImage.getHeight(this) - height;
				}

				// 实现火焰效果
				for (int j = 0; j < fireImage.getHeight(this); j = j
						+ tileHeight) {
					for (int i = 0; i < fireImage.getWidth(this); i = i
							+ tileWidth) {
						fireGraphics.drawImage(backImage, i, j, this);
					}
				}

				// 绘制前景图片
				fireGraphics.drawImage(foreImage, x, y, foreWidth, foreHeight,
						this);
				// 绘制火焰效果Image
				graphics.drawImage(fireImage, -x, -y, this);
				// 重绘屏幕
				repaint();
			}
		}
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, this);
	}
}

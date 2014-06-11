package phoenix.practise.fifthLowerPart.F30;

import java.applet.Applet;
import java.awt.*;
import java.net.URL;

public class MyShowImage extends Applet implements Runnable {

	// Applet的Image对象
	Image[] images;
	// 显示图片的X坐标
	int xpoint = 10;
	// 显示图片的Y坐标
	int ypoint = 10;
	// 图片切换的线程
	Thread thread;
	// 当前显示的图片号
	int currentImage;

	public void init() {
		// 设置背景色
		setBackground(Color.white);
		// 设置前景色
		setForeground(Color.blue);
		// 初始化参数
		currentImage = 0;
		xpoint = 10;
		ypoint = 10;
		images = new Image[5];

		// 实例化媒体装载器
		MediaTracker tracker = new MediaTracker(this);
		for (int i = 0; i < images.length; i++) {
			URL imgURL = getClass().getResource("/images/F30/");
			// 得到图像
			images[i] = getImage(imgURL, "image" + i + ".jpg");
			// 增加待装图像
			tracker.addImage(images[i], i);
		}

		try {
			// 加载图像
			tracker.waitForID(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			// 重绘屏幕
			repaint();
		}
	}

	public void paint(Graphics g) {
		// 显示图像
		g.drawImage(images[currentImage], xpoint, ypoint, this);
		// 更改当前显示图片号
		currentImage = (currentImage + 1) % 5;
	}
}

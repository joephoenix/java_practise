package phoenix.practise.fifthLowerPart.F33;

import java.applet.Applet;
import java.awt.*;
import java.net.URL;

public class ReflectionEffect extends Applet implements Runnable {

	// 图片倒影线程
	Thread lakeThread;

	// Graphics对象
	Graphics graphics;
	Graphics waveGraphics;

	// Image对象
	Image image;
	Image waveImage;

	int currentImage, imageWidth, imageHeight;
	boolean imageLoaded;
	String imageName;

	public void init() {
		imageName = getParameter("image");
		if (imageName == null) {
			imageName = "image.jpg";
		}
	}

	public void start() {
		if (lakeThread == null) {
			lakeThread = new Thread(this);
			lakeThread.start();
		}
	}

	@Override
	public void run() {
		currentImage = 0;
		if (!imageLoaded) {
			repaint();
			graphics = getGraphics();
			MediaTracker mediatracker = new MediaTracker(this);

			// 得到Image实例
			URL url = getClass().getResource("/images/F33/");
			image = getImage(url, imageName);
			mediatracker.addImage(image, 0);
			try {
				// 装载图片
				mediatracker.waitForAll();
				imageLoaded = !mediatracker.isErrorAny();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			if (!imageLoaded) {
				stop();
				graphics.drawString("加载图片错误", 10, 40);
				return;
			}
			// 得到图片的参数
			imageWidth = image.getWidth(this);
			imageHeight = image.getHeight(this);
			// 创建动画效果
			createAnimation();
		}
		// 重绘屏幕
		repaint();
		try {
			while (true) {
				repaint();
				currentImage++;
				if (currentImage == 12)
					currentImage = 0;
				Thread.sleep(50);
			}
		} catch (InterruptedException ex) {
			stop();
		}
	}

	public void createAnimation() {
		Image img = createImage(imageWidth, imageHeight);
		Graphics g = img.getGraphics();
		g.drawImage(image, 0, 0, this);
		for (int i = 0; i < imageHeight; i++) {
			// 拷贝图像区域
			g.copyArea(0, imageHeight - 1 - i, imageWidth, 1, 0, -imageHeight
					+ 1 + (i * 2));
		}

		// 得到波浪效果的Image实例
		waveImage = createImage(13 * imageWidth, imageHeight);
		waveGraphics = waveImage.getGraphics();
		waveGraphics.drawImage(img, 12 * imageWidth, 0, this);

		int j = 0;
		while (j < 12) {
			makeWaves(waveGraphics, j);
			j++;
		}
		// 绘制图像
		g.drawImage(image, 0, 0, this);
	}

	/** 波浪效果模拟 ***/
	public void makeWaves(Graphics g, int i) {
		// 波形参数
		double d = (6.2831853071795862 * i) / 12;

		int j = (12 - i) * imageWidth;
		int waveHeight = imageHeight / 16;

		// 制作波浪形
		for (int l = 0; l < imageHeight; l++) {

			int k = (int) ((waveHeight * (l + 28) * Math.sin(waveHeight
					* (imageHeight - l) / (l + 1) + d)) / imageHeight);

			// 拷贝图像区域,形成波浪
			if (l < -k) {
				g.copyArea(12 * imageWidth, l, imageWidth, 1, -j, 0);
			} else {
				g.copyArea(12 * imageWidth, l + k, imageWidth, 1, -j, -k);
			}
		}
	}

	public void paint(Graphics g) {
		update(g);
	}

	public void update(Graphics g) {
		// 绘制图像
		if (waveImage != null) {
			g.drawImage(waveImage, -currentImage * imageWidth, imageHeight - 1,
					this);
			g.drawImage(waveImage, (12 - currentImage) * imageWidth,
					imageHeight - 1, this);
		}
		g.drawImage(image, 0, 1, this);
	}

}

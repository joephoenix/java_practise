package phoenix.practise.fifthLowerPart.F34;

import java.applet.Applet;
import java.awt.*;
import java.net.URL;

@SuppressWarnings("serial")
public class ReverseApplet extends Applet implements Runnable {

	// 图像数组及当前显示图像
	Image images[], showImage;
	MediaTracker imageTracker;

	// 图像宽度,高度,当前图像编号,图像总的个数
	int imageWidth, imageHeight, currentImage, totalImage;

	// 图片翻折线程
	Thread thread;
	int delay;

	// 绘制图像的Image对象和Grahpics对象
	Image image;
	Graphics graphics;

	// 初始化
	public void init() {
		totalImage = 5;
		currentImage = 0;
		// 设置背景颜色
		setBackground(Color.white);
		images = new Image[totalImage];
		imageTracker = new MediaTracker(this);
		for (int i = 0; i < totalImage; i++) {
			String imageName = "image" + (i + 1);
			URL url = getClass().getResource("/images/F34/");
			// 得到图像
			images[i] = getImage(url, imageName + ".jpg");
			// 增加图片到加载器中
			imageTracker.addImage(images[i], 0);
		}
		try {
			imageTracker.waitForID(0); // 加载图像
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 得到延迟参数
		String param = getParameter("delay");
		if (param == null) {
			delay = 1000;
		} else {
			delay = Integer.parseInt(param);
		}

		// 得到图像宽度和高度
		imageWidth = images[0].getWidth(this);
		imageHeight = images[0].getHeight(this);

		// 创建Image实例
		image = createImage(imageWidth, imageHeight);
		// 得到Graphics实例
		graphics = image.getGraphics();
	}

	// 线程启动
	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	// 绘制图像
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void run() {
		while (thread != null) {
			try {
				// 实现图片的翻折效果
				for (int i = 0; i <= (imageHeight / 2); i++) {
					Thread.sleep(30);
					graphics.setColor(Color.white);
					graphics.fillRect(0, 0, imageWidth, imageHeight);

					// 以不同高度绘制图片
					graphics.drawImage(images[currentImage], 0, i, imageWidth,
							imageHeight - 2 * i, this);
					repaint();
				}

				// 更改当前图像编号值
				currentImage = ((currentImage + 1) % totalImage);

				// 实现图片的反向翻折效果
				for (int i = 0; i <= (imageWidth / 2); i++) {
					Thread.sleep(30);
					graphics.setColor(Color.white);
					graphics.fillRect(0, 0, imageWidth, imageHeight);

					// 以不同宽度绘制图片
					graphics.drawImage(images[currentImage], (imageWidth / 2)
							- i, 0, 2 * i, imageHeight, this);
					repaint();
				}
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

package phoenix.practise.fifthCentralPart.F26;

import java.applet.Applet;
import java.awt.*;

public class ThreeDimensionWord extends Applet implements Runnable {

	// 绘制文字的Image对象
	Image image;
	// 绘制文字的Graphics对象
	Graphics graphics;

	Thread thread;
	// 显示宽度、高度
	int width, height;

	String message;
	// 文字尺寸和字体
	int fontSize;
	Font font;

	// 初始化
	public void init() {
		// 得到Applet的尺寸
		Dimension dim = getSize();
		width = dim.width;
		height = dim.height;
		image = createImage(width, height);

		// 得到Grahpics实例
		graphics = image.getGraphics();
		message = getParameter("text");
		if (message == null) {
			message = "三维文字";
		}
		fontSize = 30;
	}

	// 开始方法
	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	@Override
	public void run() {
		while (thread != null) {
			try {
				Thread.sleep(50L);
			} catch (InterruptedException ex) {
			}
			repaint();
		}
	}

	// 更新绘画
	public void update(Graphics g) {
		// 得到字体实例
		font = new Font("TimesRoman", 1, fontSize);
		graphics.setFont(font);
		int j = (int) (255 * Math.random());
		int k = (int) (255 * Math.random());
		int l = (int) (255 * Math.random());

		// 让线程休眠
		try {
			Thread.sleep(2000); // 线程休眠
		} catch (InterruptedException ex) {
		}

		// 绘制图形放入image中
		graphics.setColor(Color.GRAY);
		graphics.fillRect(0, 0, width, height);
		for (int i = 0; i < 6; i++) {
			// 实现3D效果
			graphics.setColor(new Color(255 - ((255 - j) * i) / 10,
					255 - ((255 - k) * i) / 10, 255 - ((255 - l) * i) / 10));
			graphics.drawString(message, 15 - i, height - 15 - i);
		}
		// 绘制Image到屏幕
		g.drawImage(image, 0, 0, this);
	}

	// 绘画
	public void paint(Graphics g) {
		update(g);
	}

}

package phoenix.practise.fifthLowerPart.F28;

import java.applet.Applet;
import java.awt.*;

public class MyFlyWord extends Applet implements Runnable {

	// 属性的声明
	Image image;
	Graphics graphics;
	Font font;
	String message;
	Thread thread;
	int xpos, ypos, fontsize;

	// 初始化方法
	public void init() {
		// 得到Image实例
		image = createImage(getSize().width, getSize().height);

		// 其他属性设置，如字体，文字
		graphics = image.getGraphics();
		message = getParameter("Text");
		if (message == null) {
			message = "飞行文字";
		}
		font = new Font("TimesRoman", Font.BOLD, 10);
	}

	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	@Override
	public void run() {
		while (thread != null) {
			if (fontsize > getSize().height) {
				fontsize = 0;
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException itex) {
				itex.printStackTrace();
			}
			repaint();
		}
	}

	public void stop() {
		thread = null;
	}

	// 绘制更新页面
	public void update(Graphics g) {
		// 背景
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, getSize().width, getSize().height);

		// 字体实例
		font = new Font("TimesRoman", Font.BOLD, fontsize);
		graphics.setFont(font);
		graphics.setColor(Color.pink);
		FontMetrics fontMetrics = graphics.getFontMetrics(font);
		int fontheight = fontMetrics.getHeight();
		int width;
		int baseline = getSize().height / 2 + fontheight / 2;

		// 文字字符串设置
		width = fontMetrics.stringWidth(message);
		width = (getSize().width - width) / 2;
		graphics.drawString(message, width, baseline -= 20);

		// 绘制Image对象
		g.drawImage(image, 0, 0, this);
		fontsize++;
	}

	public void paint(Graphics g) {
		update(g);
	}

}

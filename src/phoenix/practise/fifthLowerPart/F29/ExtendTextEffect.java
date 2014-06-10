package phoenix.practise.fifthLowerPart.F29;

import java.applet.Applet;
import java.awt.*;

@SuppressWarnings("serial")
public class ExtendTextEffect extends Applet implements Runnable {

	// 声明属性
	Image image;
	Graphics graphics;
	int appletWidth, appletHeight;

	String message;
	Thread thread;
	int ypoint = 0, xheight;
	int phase = 0;
	Font font;

	// 初始化方法
	public void init() {
		// 实例化字体
		font = new Font("TimesRoman", Font.BOLD, 30);
		appletWidth = getSize().width;
		appletHeight = getSize().height;

		// 设定X坐标和Y坐标
		xheight = appletHeight / 3;
		ypoint = xheight;

		// 得到显示信息
		message = getParameter("Text");
		if (message == null) {
			message = "伸展文字";
		}

		// 得到Image实例和2D图形
		image = createImage(appletWidth, appletHeight);
		graphics = image.getGraphics();
	}

	// 开始线程
	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	// 绘制屏幕
	public void update(Graphics g) {
		paint(g);
	}

	// 绘制Image对象
	public void paint(Graphics g) {
		g.drawImage(image, 0, ypoint, appletWidth, xheight, this);
	}

	// 在线程中实现图形的绘制
	@Override
	public void run() {
		try {
			while (true) {
				ypoint = 0;
				xheight = appletHeight;
				graphics.setColor(Color.white);
				graphics.fillRect(0, 0, appletWidth, appletHeight);
				repaint();
				// 线程休眠100毫秒
				Thread.sleep(100);
				if (phase == 0) {
					graphics.setColor(Color.orange);
					// 线条的伸展效果
					for (int i = appletWidth; i >= 0; i--) {
						graphics.fillRect(i, appletHeight / 3, appletWidth,
								appletHeight / 10);
						repaint();
						Thread.sleep(10);
					}
				} else if (phase == 1) {
					// 设置当前颜色
					graphics.setColor(Color.pink);
					for (int i = 0; i <= appletWidth; i++) {
						graphics.fillRect(0, appletHeight / 3, i,
								appletHeight / 10);
						repaint();
						Thread.sleep(10);
					}
				}

				//
				ypoint = appletHeight / 3;
				xheight = appletHeight / 3;
				for (int i = appletHeight / 3; i >= 0; i--) {
					ypoint--;
					xheight += 2;
					if (phase == 0) {
						// 重新绘制2D图形，设置图形的参数，如颜色、字体等
						graphics.setColor(Color.orange);
						graphics.fillRect(0, 0, appletWidth, appletHeight);
						graphics.setFont(font);
						graphics.setColor(Color.white);
						graphics.drawString(message, 0, 50);
						phase++;
					} else if (phase == 1) {
						// 重新绘制2D图形，设置图形的参数，如颜色、字体等
						graphics.setColor(Color.pink);
						graphics.fillRect(0, 0, appletWidth, appletHeight);
						graphics.setFont(font);
						graphics.setColor(Color.black);
						graphics.drawString(message, 0, 50);
						phase = 0;
					}
					// 重绘屏幕
					repaint();
					Thread.sleep(100);
				}
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

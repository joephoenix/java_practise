package phoenix.practise.fifthCentralPart.F25;

import java.applet.Applet;
import java.awt.*;

public class ShadowTextApplet extends Applet implements Runnable {

	String message;
	Thread thread;
	// 字体高度,运动速度和基线
	int fontHeight, speed, baseline, xpoint;
	// 文字颜色、背景颜色与阴影颜色
	Color textColor, bgColor, shadomColor;
	// 实现跳动的Image对象
	Image newImage;
	// 实现跳动的Graphics对象
	Graphics newGraphics;
	// 文字是否跳动的标志
	boolean normal;

	// 显示字体和字体的FontMetrics对象
	Font font;
	FontMetrics fontMetric;

	/**
	 * 初始化方法
	 */
	public void init() {
		// 得到graphics对象
		Graphics graphics = getGraphics();
		Dimension dim = getSize();

		// 根据Applet尺寸设置文字高度
		fontHeight = dim.height - 10;
		newImage = createImage(dim.width, dim.height);
		newGraphics = newImage.getGraphics();
		message = getParameter("text");
		if (message == null) {
			message = "阴影文字";
		}
		int textWidth = dim.width - (message.length() + 1) * 5 - 10;

		do {
			// 设置显示字体
			graphics.setFont(new Font("TimesRoman", 1, fontHeight));
			fontMetric = graphics.getFontMetrics();
			if (fontMetric.stringWidth(message) > textWidth) {
				fontHeight--;
			}
		} while (fontMetric.stringWidth(message) > textWidth);
		{
			// 调整显示基线位置
			baseline = getSize().height - fontMetric.getMaxDescent();
		}
		font = new Font("TimesRoman", 1, fontHeight);

		// 参数字符串,从页面传入
		String param;
		if ((param = getParameter("TEXTCOLOR")) == null) {
			textColor = Color.black;
		} else {
			textColor = new Color(Integer.parseInt(param));
		}
		if ((param = getParameter("BGCOLOR")) == null) {
			bgColor = Color.white;
		} else {
			bgColor = new Color(Integer.parseInt(param));
		}
		if ((param = getParameter("SHADOMCOLOR")) == null) {
			shadomColor = Color.lightGray;
		} else {
			shadomColor = new Color(Integer.parseInt(param));
		}
		if ((param = getParameter("NORMAL")) != null) {
			normal = (Integer.valueOf(param).intValue() != 0);
		}
		setBackground(bgColor);

		// 得到运动速度,页面传入
		if ((param = getParameter("SPEED")) != null) {
			speed = Integer.valueOf(param).intValue();
		}
		if (speed == 0) {
			speed = 300;
		}

		// 实例化运动文字的线程
		thread = new Thread(this);
	}

	// 启动线程开始
	public void start() {
		// 实例化线程
		if (thread == null) {
			thread = new Thread(this);
		}
		// 线程运行
		thread.start();
	}

	// 线程运行主体
	@Override
	public void run() {
		while (thread != null) {
			try {
				// 线程休眠,即跳动间隔时间
				Thread.sleep(speed);
			} catch (InterruptedException ex) {
			}
			// 重绘屏幕
			repaint();
		}
		System.exit(0);
	}

	// 绘制Applet
	public void paint(Graphics g) {
		if (normal) {
			g.setColor(bgColor);
			// 绘制填充矩形
			g.fillRect(0, 0, getSize().width, getSize().height);
			g.setColor(textColor);
			g.setFont(font);
			// 绘出字符串
			g.drawString(message,
					(getSize().width - fontMetric.stringWidth(message)) / 2,
					baseline);
		}
	}

	// 更新Applet
	public void update(Graphics g) {
		newGraphics.setColor(bgColor);
		newGraphics.fillRect(0, 0, getSize().width, getSize().height);
		newGraphics.setColor(textColor);
		newGraphics.setFont(font);

		if (!normal) {
			java.util.Random r = new java.util.Random();
			// 生成随机X坐标
			int xpoint = r.nextInt(fontMetric.stringWidth(message));

			font = new Font("TimesRoman", Font.BOLD, 30);
			newGraphics.setFont(font);
			newGraphics.setColor(shadomColor);

			// 绘制阴影
			newGraphics.drawString(message, xpoint + 3, baseline + 3);
			newGraphics.setColor(textColor);
			newGraphics.drawString(message, xpoint, baseline);

		} else {
			font = new Font("TimesRoman", Font.BOLD, 30);
			newGraphics.setFont(font);

			newGraphics.setColor(shadomColor);
			// 绘制阴影
			newGraphics.drawString(message, xpoint + 3, baseline + 3);

			newGraphics.setColor(textColor);
			newGraphics.drawString(message, xpoint, baseline);
		}
		// 绘制Image
		g.drawImage(newImage, 0, 0, this);
	}
}

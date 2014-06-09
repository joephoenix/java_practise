package phoenix.practise.fifthCentralPart.F24;

import java.applet.Applet;
import java.awt.*;
import java.util.Random;

public class JumpTextApplet extends Applet implements Runnable {

	String message; // 待显示的文本信息
	Thread jumpThread; // 实现抖动文字的线程
	int fontHeight, speed, baseline; // 字体高度,跳动速度和基线
	Color textColor, bgColor; // 文字颜色与背景颜色
	Image jumpImage; // 实现跳动的Image对象
	Graphics jumpGraphics; // 实现抖动的Graphics对象
	boolean normal; // 文字是否抖动的标志
	Font font; // 显示字体
	FontMetrics fontMetric; // 显示字体的FontMetrics对象
	Color randomColors[]; // 随机生成颜色
	boolean randomColor; // 是否是随机颜色

	/**
	 * 初始化函数
	 */
	public void init() {
		// 得到graphics对象
		Graphics graphics = getGraphics();
		Dimension dim = getSize();
		fontHeight = dim.height - 10;
		jumpImage = createImage(dim.width, dim.height);
		jumpGraphics = jumpImage.getGraphics();
		message = getParameter("text");
		if (message == null) {
			message = "抖动的文字";
		}

		// 设置文字宽度
		int textWidth = dim.width - (message.length() + 1) * 5 - 10;

		do {
			graphics.setFont(new Font("TimesRoman", 1, fontHeight));
			fontMetric = graphics.getFontMetrics();
			// 根据文字宽度调整其高度
			if (fontMetric.stringWidth(message) > textWidth) {
				fontHeight--;
			}
		} while (fontMetric.stringWidth(message) > textWidth);
		{
			baseline = getSize().height - fontMetric.getMaxDescent(); // 调整显示基线位置
		}
		font = new Font("TimesRoman", 1, fontHeight); // 得到字体实例

		String param; // 参数字符串
		if ((param = getParameter("TEXTCOLOR")) == null) {
			textColor = Color.black;
		} else {
			textColor = new Color(Integer.parseInt(param));
		}
		if ((param = getParameter("BGCOLOR")) == null) {
			bgColor = Color.lightGray;
		} else {
			bgColor = new Color(Integer.parseInt(param));
		}
		setBackground(bgColor); // 设置背景颜色
		if ((param = getParameter("SPEED")) != null) {
			speed = Integer.valueOf(param).intValue();
		}
		if (speed == 0) {
			speed = 200;
		}
		if ((param = getParameter("RANDOMCOLOR")) != null) {
			randomColor = (Integer.valueOf(param).intValue() != 0);
		}
		if ((param = getParameter("NORMAL")) != null) {
			normal = (Integer.valueOf(param).intValue() != 0);
		}
		// 初始化随机颜色数组
		if (randomColor) {
			Random random = new Random();
			// 颜色的RGB值
			int r, g, b;
			for (int i = 0; i < 10; i++) {
				r = random.nextInt(255);
				g = random.nextInt(255);
				b = random.nextInt(255);
				Color randomc = new Color(r, g, b);
				randomColors[i] = randomc;
			}
		}
		// 实例化抖动文字线程
		jumpThread = new Thread(this);
	}

	/**
	 * 启动线程
	 */
	public void start() {
		if (jumpThread == null) {
			jumpThread = new Thread(this);
		}
		jumpThread.start();
	}

	@Override
	public void run() {
		while (jumpThread != null) {
			try {
				// 线程休眠,即抖动间隔时间
				Thread.sleep(speed);
			} catch (InterruptedException ex) {
			}
			repaint(); // 重绘屏幕
		}
		System.exit(0); // 退出程序
	}

	/**
	 * // 绘制Applet
	 */
	public void paint(Graphics g) {
		// 如果是静态文本
		if (normal) {
			g.setColor(bgColor);
			// 绘制填充矩形
			g.fillRect(0, 0, getSize().width, getSize().height);
			g.setColor(textColor);
			g.setFont(font);
			g.drawString(message,
					(getSize().width - fontMetric.stringWidth(message)) / 2,
					baseline);
		}
	}

	/**
	 * // 更新Applet
	 */
	public void update(Graphics g) {
		jumpGraphics.setColor(bgColor);
		// 绘制填充矩形
		jumpGraphics.fillRect(0, 0, getSize().width, getSize().height);
		// 设置当前颜色
		jumpGraphics.setColor(textColor);
		// 设置字体
		jumpGraphics.setFont(font);
		if (!normal) {
			int xpoint = 0;
			for (int j = 0; j < message.length(); j++) {
				if (randomColor) {
					Color color;
					// 得到颜色数组中与背景色不同的一个随机颜色
					while (bgColor == (color = randomColors[Math.min(9,
							(int) (Math.random() * 10))])) {
						jumpGraphics.setColor(color);
					}
				}
				/******* 抖动实现的关键代码 ***********/
				// 单个字符的X坐标
				xpoint += (int) (Math.random() * 10);
				// 单个字符的Y坐标
				int ypoint = baseline - (int) (Math.random() * 10);

				String s1 = message.substring(j, j + 1);
				jumpGraphics.drawString(s1, xpoint, ypoint);
				xpoint += fontMetric.stringWidth(s1);
			}
		} else {
			jumpGraphics.drawString(message,
					(getSize().width - fontMetric.stringWidth(message)) / 2,
					baseline);
		}
		// 绘制Image
		g.drawImage(jumpImage, 0, 0, this);
	}

	/**
	 * // 构造函数
	 */
	public JumpTextApplet() {
		speed = 100;
		normal = false;
		randomColors = new Color[10];
		randomColor = false;
	}
}

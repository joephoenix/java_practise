package phoenix.practise.fifthLowerPart.F27;

import java.applet.Applet;
import java.awt.*;

public class WaveTextApplet extends Applet implements Runnable {

	String message;
	int direct, phase;

	Thread thread;

	char words[];
	Image image;

	Graphics g_wta;

	Color colors[];

	private Font font;
	private FontMetrics fontMetrics;

	public void init() {
		direct = 1;
		phase = 0;

		message = getParameter("Text");

		if (message == null) {
			message = "波浪文字";
		}

		setBackground(Color.black);

		words = new char[message.length()];
		message.getChars(0, message.length(), words, 0);

		image = createImage(getSize().width, getSize().height);
		g_wta = image.getGraphics();

		font = new Font("TimesRoman", Font.BOLD, 36);
		fontMetrics = getFontMetrics(font);
		g_wta.setFont(font);

		float h;
		colors = new Color[message.length()];
		for (int i = 0; i < message.length(); i++) {
			h = ((float) i) / ((float) message.length());
			colors[i] = new Color(Color.HSBtoRGB(h, 1.0f, 1.0f));
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
		while (thread != null) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		// 重新绘制屏幕
		repaint();
	}

	public void update(Graphics g) {
		int x, y;
		double ang;
		int Hrad = 12;
		int Vrad = 12;

		g_wta.setColor(Color.black);
		g_wta.fillRect(0, 0, getSize().width, getSize().height);

		phase += direct;
		phase %= 8;

		for (int i = 0; i < message.length(); i++) {
			ang = ((phase - i * direct) % 8) / 4.0 * Math.PI;
			// x轴
			x = 20 + fontMetrics.getMaxAdvance() * i
					+ (int) (Math.cos(ang) * Hrad);
			// y轴
			y = 60 + (int) (Math.sin(ang) * Vrad);

			g_wta.setColor(colors[(phase + i) % message.length()]);
			g_wta.drawChars(words, i, 1, x, y);
		}
		g.drawImage(image, 0, 0, this);
	}

	public void paint(Graphics g) {
		update(g);
	}

}

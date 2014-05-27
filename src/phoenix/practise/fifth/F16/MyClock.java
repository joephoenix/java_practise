package phoenix.practise.fifth.F16;

import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;

public class MyClock extends JFrame implements Runnable {

	Thread clock;

	public MyClock() {
		super("数字时钟");

		// 设置字体
		setFont(new Font("Times New Roman", Font.BOLD, 60));
		// 开始进程
		start();

		// 窗口设置参数
		setSize(600, 480);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * 开始时钟进程
	 */
	public void start() {
		if (clock == null) {
			clock = new Thread(this);
			clock.start();
		}
	}

	@Override
	public void run() {
		while (clock != null) {
			// 调用paint方法重绘界面
			repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	// 停止进程
	public void stop() {
		clock = null;
	}

	// 重载组件的paint方法
	public void paint(Graphics g) {
		// 实例化日历对象
		Calendar now = new GregorianCalendar();
		String timeInfo = "";
		// 得到小时数、分钟数和秒钟数
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);

		// 格式化输出
		if (hour <= 9) {
			timeInfo += "0" + hour + ":";
		} else {
			timeInfo += hour + ":";
		}
		if (minute <= 9) {
			timeInfo += "0" + minute + ":";
		} else {
			timeInfo += minute + ":";
		}
		if (second <= 9) {
			timeInfo += "0" + second;
		} else {
			timeInfo += second;
		}
		// 设置当前颜色为白色
		g.setColor(Color.white);
		// 得到窗口尺寸、设置背景色，设置字体颜色和显示时间字符串
		Dimension dim = getSize();
		g.fillRect(0, 0, dim.width, dim.height);
		g.setColor(Color.BLUE);
		g.drawString(timeInfo, dim.width / 3, dim.height / 2);
	}

	public static void main(String[] args) {
		new MyClock();
	}

}

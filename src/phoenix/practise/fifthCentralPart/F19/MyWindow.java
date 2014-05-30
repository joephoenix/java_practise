package phoenix.practise.fifthCentralPart.F19;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class MyWindow extends JWindow implements Runnable {

	// 进度条更新线程
	Thread splashThread;
	// 进度条
	JProgressBar jpb;

	public MyWindow() {

		Container container = getContentPane();

		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

		URL url = getClass().getResource("/images/F19/login.jpg");

		if (url != null) {
			container.add(new JLabel(new ImageIcon(url)), BorderLayout.CENTER);
		}

		jpb = new JProgressBar(1, 100); // 实例化进度条
		jpb.setStringPainted(true); // 描绘文字
		jpb.setString("加载程序中,请稍候......"); // 设置显示文字
		jpb.setBackground(Color.white); // 设置背景色
		container.add(jpb, BorderLayout.SOUTH); // 增加进度条到容器上

		Dimension screen = getToolkit().getScreenSize(); // 得到屏幕尺寸
		pack(); // 窗口适应组件尺寸
		setLocation((screen.width - getSize().width) / 2,
				(screen.height - getSize().height) / 2); // 设置窗口位置

	}

	public void start() {
		this.toFront(); // 窗口前端显示
		splashThread = new Thread(this); // 实例化线程
		splashThread.start(); // 开始运行线程
	}

	@Override
	public void run() {
		setVisible(true); // 显示窗口
		try {
			for (int i = 0; i < 100; i++) {
				Thread.sleep(100); // 线程休眠
				jpb.setValue(jpb.getValue() + 1); // 设置进度条值
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		dispose(); // 释放窗口
		showFrame(); // 运行主程序
	}

	static void showFrame() {
		JFrame frame = new JFrame("程序启动界面演示"); // 实例化JFrame对象
		frame.setSize(800, 600); // 设置窗口尺寸
		frame.setVisible(true); // 窗口可视
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭窗口时退出程序
	}

	public static void main(String[] args) {
		MyWindow splash = new MyWindow();
		splash.start(); // 运行启动界面
	}

}

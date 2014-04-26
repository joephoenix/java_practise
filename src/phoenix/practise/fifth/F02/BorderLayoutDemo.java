package phoenix.practise.fifth.F02;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class BorderLayoutDemo extends JFrame {
	/**
	 * 构造函数
	 */
	public BorderLayoutDemo() {
		// 得到容器
		Container container = getContentPane();
		// 设置布局管理器为Borderlayout
		container.setLayout(new BorderLayout());
		// 增加4个按钮
		container.add(new JButton("North"), BorderLayout.NORTH);
		container.add(new JButton("South"), BorderLayout.SOUTH);
		container.add(new JButton("East"), BorderLayout.EAST);
		container.add(new JButton("West"), BorderLayout.WEST);
		container.add(new JButton("Center"), BorderLayout.CENTER);
		// 设置窗口标题
		setTitle("BorderLayout 演示");
		// 设置主窗口尺寸
		setSize(280, 200);
		// 设置主窗口可视
		setVisible(true);
		// 关闭窗口时退出程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		new BorderLayoutDemo();
	}

}

package phoenix.practise.fifthUpperPart.F09;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class WindowStyle extends JFrame {

	public WindowStyle() {
		super("多种风格的窗口");
		// 得到容器
		Container container = getContentPane();
		// 初始化菜单以及菜单项
		JMenu menuTheme = new JMenu("窗口风格");
		JMenuItem itemNative = new JMenuItem("系统平台风格");
		JMenuItem itemMotif = new JMenuItem("Motif风格");
		JMenuItem itemMetal = new JMenuItem("跨平台风格");
		menuTheme.add(itemNative);
		menuTheme.add(itemMotif);
		menuTheme.add(itemMetal);

		// 菜单项事件处理
		itemNative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				changeStyle("Native");
			}
		});

		itemMotif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				changeStyle("Motif");
			}
		});

		itemMetal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				changeStyle("Metal");
			}
		});

		// 初始化菜单栏
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menuTheme); // 增加菜单到菜单栏
		setJMenuBar(menuBar); // 设置菜单

		// 初始化一个JPanel
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("组件样式")); // 设置边界
		panel.add(new JTextField("文本框：窗口样式测试 ")); // 增加组件到panel上
		panel.add(new JCheckBox("粗体"));
		panel.add(new JCheckBox("斜体"));
		panel.add(new JCheckBox("下划线"));
		panel.add(new JButton("确定"));
		panel.add(new JButton("退出"));
		container.add(panel); // 增加panel到容器上

		// 窗口设置
		setSize(600, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * 改变窗口样式
	 * 
	 * @param type
	 */
	public void changeStyle(String type) {
		try {
			// 判断来自于哪个菜单项
			if (type.equals("Native")) {
				// 设置界面样式
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} else if (type.equals("Motif")) {
				UIManager
						.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			} else if (type.equals("Metal")) {
				UIManager.setLookAndFeel(UIManager
						.getCrossPlatformLookAndFeelClassName());
			}
			// 更新界面
			javax.swing.SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new WindowStyle();
	}

}

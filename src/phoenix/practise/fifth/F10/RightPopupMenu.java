package phoenix.practise.fifth.F10;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class RightPopupMenu extends JFrame {

	// 声明用到的组件变量
	JRadioButtonMenuItem items[];
	Color[] colors = { Color.black, Color.red, Color.blue, Color.gray,
			Color.yellow, Color.green, Color.pink, Color.cyan, Color.orange,
			Color.white, Color.magenta };
	JPopupMenu jpm;

	/***
	 * 构造函数
	 */
	public RightPopupMenu() {
		super("右键弹出菜单");

		// 加入菜单项事件处理
		ChangeColorAction action = new ChangeColorAction();

		// 定义菜单项的内容，如名称等
		String[] names = { "Black", "Red", "Blue", "Gray", "Yellow", "Green",
				"Pink", "Cyan", "Orange", "White", "Magenta" };
		ButtonGroup colorGroup = new ButtonGroup();

		// 生成弹出菜单项
		jpm = new JPopupMenu();
		items = new JRadioButtonMenuItem[11];
		for (int i = 0; i < items.length; i++) {
			items[i] = new JRadioButtonMenuItem(names[i]);
			jpm.add(items[i]);
			colorGroup.add(items[i]);
			items[i].addActionListener(action);
		}

		// 添加窗口的鼠标事件处理
		addMouseListener(new MouseAdapter() {
			// 鼠标点击事件
			public void mousePressed(MouseEvent event) {
				triggerEvent(event);
			}

			// 释放鼠标
			public void mouseReleased(MouseEvent event) {
				triggerEvent(event);
			}

			// 主体操作事件
			private void triggerEvent(MouseEvent event) {
				if (event.isPopupTrigger()) {
					jpm.show(event.getComponent(), event.getX(), event.getY());
				}
			}

		});

		// 设置窗体的基本属性，如默认背景、窗口大小，是否可视等等
		getContentPane().setBackground(Color.white);
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public class ChangeColorAction implements ActionListener {

		/***
		 * 重载的方法，实现菜单的功能
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < items.length; i++) {
				if (e.getSource() == items[i]) {
					getContentPane().setBackground(colors[i]);

					// 重新绘制窗口
					repaint();
					return;
				}
			}
		}

	}

	public static void main(String[] args) {
		new RightPopupMenu();
	}
}

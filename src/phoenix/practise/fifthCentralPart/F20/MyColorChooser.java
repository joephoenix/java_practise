package phoenix.practise.fifthCentralPart.F20;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyColorChooser extends JFrame {
	// 声明需要的私有变量，容器和面板等
	private Container container;
	private JPanel colorPanel;

	// 构造函数
	public MyColorChooser() {
		super("调色板演示");

		container = getContentPane();
		colorPanel = new JPanel();
		JButton selectColorButton = new JButton("选取颜色");

		// 事件处理
		selectColorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// 实例化颜色选择器
				JColorChooser chooser = new JColorChooser();
				Color color = chooser.showDialog(MyColorChooser.this, "选取颜色",
						Color.lightGray);
				if (color == null)
					color = Color.gray;
				// 改变面板的背景色
				colorPanel.setBackground(color);
			}
		});
		container.add(selectColorButton, BorderLayout.NORTH);
		container.add(colorPanel, BorderLayout.CENTER);

		// 窗口设置
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		new MyColorChooser();
	}

}

package phoenix.practise.fifthUpperPart.F04;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;

public class ColorSelector extends JFrame {

	Container container;
	// 选择的颜色值信息
	JTextField selectedText;
	// 颜色列表框
	JList list;
	// 颜色的显示框，使用背景颜色绘制的方式
	JPanel selectedColor;

	/**
	 * 构造函数
	 */
	public ColorSelector() {
		// 通过getContentPane得到容器
		container = getContentPane();
		// 设置布局管理器
		container.setLayout(new BorderLayout());
		// 颜色选择的数组
		Color[] colors = { Color.orange, Color.pink, Color.red, Color.black,
				Color.blue, Color.cyan, Color.lightGray, Color.darkGray,
				Color.green, Color.yellow, Color.magenta, Color.white };
		list = new JList(colors);
		// 以list初始化滚动窗体
		JScrollPane scrollPane = new JScrollPane(list);
		// 初始化控件
		selectedText = new JTextField(20);
		selectedText.setPreferredSize(new Dimension(60, 60));
		selectedColor = new JPanel();
		// 设置panel的首选尺寸
		selectedColor.setPreferredSize(new Dimension(60, 60));
		/************* 把组件加到容器里面 *******************/
		container.add(selectedText, BorderLayout.NORTH);
		container.add(scrollPane, BorderLayout.CENTER);
		container.add(selectedColor, BorderLayout.SOUTH);
		// 设置renderer渲染，使用自定义的renderer
		list.setCellRenderer(new ColorRenderer());
		// 添加事件响应处理
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evnet) {
				Color c = (Color) list.getSelectedValue();
				selectedText.setText("选择的颜色" + " R=" + c.getRed() + ", G="
						+ c.getGreen() + ", B=" + c.getBlue());
				selectedColor.setBackground(c);
			}
		});
		// 设置窗体的属性，尺寸、是否可是和关闭退出
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/********* 入口函数 ************/
	public static void main(String[] args) {
		new ColorSelector();
	}

}

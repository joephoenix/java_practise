package phoenix.practise.fifthUpperPart.F05;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RoundButton extends JFrame {

	private int clickCount = 0;
	private JButton button1;
	private JButton button2;

	/**
	 * 构造函数
	 */
	public RoundButton() {
		// 第一个按钮
		button1 = new DefineButton("这是一个圆形按钮");
		// 得到按钮一的最佳尺寸
		Dimension dim = button1.getPreferredSize();
		// 得到长和宽各自的最大值
		double maxsize = Math.max(dim.getHeight(), dim.getWidth());
		dim.setSize(maxsize, maxsize);
		button1.setPreferredSize(dim);

		// 第二个按钮
		button2 = new DefineButton("点击了:" + clickCount + "次");

		button1.setBackground(Color.blue);
		button2.setBackground(Color.pink);

		// 增加组件到pane上
		getContentPane().add(button1);
		getContentPane().add(button2);

		// 设置布局管理
		getContentPane().setLayout(new FlowLayout());

		// 加上按钮二的事件处理
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				clickCount++;
				button2.setText("点击了: " + clickCount + " 次");
			}
		});

		// 窗口属性设置
		setSize(700, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 入口方法，main函数
	public static void main(String[] args) {
		new RoundButton();
	}

}

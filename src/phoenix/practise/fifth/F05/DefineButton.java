package phoenix.practise.fifth.F05;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class DefineButton extends JButton {

	/**
	 * 构造函数
	 */
	public DefineButton(String label) {
		super(label);
		// 不自行绘制按钮背景
		setContentAreaFilled(false);
	}

	/**
	 * 绘制圆形和标签
	 */
	protected void paintComponent(Graphics g) {
		// 鼠标点击时
		if (getModel().isArmed()) {
			g.setColor(Color.green);
		} else {
			g.setColor(getBackground());
		}

		/*************** ------------------------------------------ ***********/
		// 绘制圆形图案
		g.fillOval(0, 0, getSize().width, getSize().height);
		// 调用父类函数,绘制其余部分
		super.paintComponent(g);
	}

	/************* ---------------------------------------------- *************/
	// 绘制边框
	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		// 在边界上绘制一个椭圆
		g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
	}

}

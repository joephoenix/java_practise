package phoenix.practise.fifth.F07;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class ICoordinate extends JFrame {

	/**
	 * 构造函数
	 */
	public ICoordinate() {
		// 调用父类构造函数
		super("实线与虚线");

		// 设置窗体的属性
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * 页面绘图渲染
	 */
	public void paint(Graphics g) {
		// 得到2D图形的对象
		Graphics2D g2 = (Graphics2D) g;
		Dimension dim = this.getSize();
		// 设置图形的颜色、填充
		g2.setColor(Color.white);
		g2.fillRect(0, 0, dim.width, dim.height);
		g2.setColor(Color.black);

		// 绘制线条
		g2.drawLine(40, 280, 280, 280);
		g2.drawLine(40, 280, 40, 40);

		// 绘制字符串
		g2.drawString("0", 30, 285);
		g2.drawString("300", 40, 50);
		g2.drawString("300", 270, 275);

		// 定义画图笔和刷子
		float[] dash = { 5, 5 };
		BasicStroke bs = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);

		// 绘制
		g2.setStroke(bs);
		g2.setColor(Color.pink);
		g2.drawLine(40, 280, 100, 120);
		g2.drawLine(100, 120, 160, 120);
		g2.drawLine(160, 120, 280, 40);
	}

	public static void main(String[] args) {
		new ICoordinate();
	}

}

package phoenix.practise.fifthCentralPart.F15;

import java.awt.Point;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class MyDragPicture extends JFrame {

	private JLabel jlpic;

	public MyDragPicture() {
		super("图片的拖动效果");

		/** 声明并实例化需要的控件 **/
		// 读取运行的根路径
		String path = getClass().getResource("/images/F15/1.jpg").getPath();
		// 声明实例化图片
		Icon image = new ImageIcon(path);
		jlpic = new JLabel(image);
		getContentPane().add(jlpic); // 加载到容器上
		DragPicListener listener = new DragPicListener(); // 鼠标事件处理
		jlpic.addMouseListener(listener); // 增加标签的事件处理
		jlpic.addMouseMotionListener(listener);

		/*************** 窗口参数配置 **************************/
		setSize(800, 600); // 设置窗口尺寸
		setVisible(true); // 设置窗口为可视
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭窗口时退出程序
	}

	/*******
	 * 内联函数，实现图片拖动的鼠标监听事件
	 * 
	 * @author joephoenix
	 * 
	 */
	class DragPicListener implements MouseInputListener {
		Point p = new Point(0, 0); // 坐标点

		/**
		 * 鼠标移动
		 */
		public void mouseMoved(MouseEvent e) {
		}

		/**
		 * 鼠标拖动
		 */
		public void mouseDragged(MouseEvent e) {
			Point newP = SwingUtilities.convertPoint(jlpic, e.getPoint(),
					jlpic.getParent()); // 转换坐标系统
			jlpic.setLocation(jlpic.getX() + (newP.x - p.x), jlpic.getY()
					+ (newP.y - p.y)); // 设置标签的新位置
			p = newP; // 更改坐标点
		}

		/**
		 * 鼠标释放
		 */
		public void mouseReleased(MouseEvent e) {
		}

		/**
		 * 鼠标进入空间的区域
		 */
		public void mouseEntered(MouseEvent e) {
		}

		/**
		 * 
		 */
		public void mouseExited(MouseEvent e) {
		}

		/**
		 * 鼠标退出
		 */
		public void mouseClicked(MouseEvent e) {
		}

		/**
		 * 鼠标点击
		 */
		public void mousePressed(MouseEvent e) {
			p = SwingUtilities.convertPoint(jlpic, e.getPoint(),
					jlpic.getParent()); // 得到当前坐标点
		}
	}

	public static void main(String[] args) {
		new MyDragPicture();
	}

}

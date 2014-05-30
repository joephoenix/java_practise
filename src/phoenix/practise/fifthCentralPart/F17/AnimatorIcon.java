package phoenix.practise.fifthCentralPart.F17;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class AnimatorIcon extends JPanel implements ActionListener {

	// 动态图标实现需要的参数
	ImageIcon[] images;
	Timer animationTimer;
	int currentImage = 0;
	int delay = 500;
	int width;
	int height;

	public AnimatorIcon() {
		// 设置背景颜色
		setBackground(Color.white);

		// 设置文件的读取路径
		String path = AnimatorIcon.class.getResource("").getPath();
		path = path.substring(0, path.indexOf("/bin/"));
		// 找到项目的整体图片文件夹
		path = path + "/images/";
		// 加入本工程的分类文件夹
		path = path + "F17/";

		// 初始化动态图片的数组
		images = new ImageIcon[4];
		for (int i = 0; i < images.length; i++) {
			images[i] = new ImageIcon(path + i + ".jpg");
		}
		// 初始化长宽高
		width = images[0].getIconWidth();
		height = images[0].getIconHeight();
	}

	/****
	 * 重载组件绘制方法
	 */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		// 开始绘制
		images[currentImage].paintIcon(this, g, 70, 0);
		Random rd = new Random();
		currentImage = (currentImage + 1) % 2;
		// currentImage = rd.nextInt(images.length);
		// System.out.println(currentImage);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		repaint();
	}

	/**
	 * 开始动画
	 */
	public void startAnimation() {
		if (animationTimer == null) {
			currentImage = 0;
			// 实例化一个Timer对象
			animationTimer = new Timer(delay, this);
			animationTimer.start();
		} else if (!animationTimer.isRunning()) {
			animationTimer.restart();
		}
	}

	/**
	 * 停止动画
	 */
	public void stopAnimation() {
		animationTimer.stop();
	}

	public static void main(String args[]) {
		// 实例化动画图标对象
		AnimatorIcon ai = new AnimatorIcon();

		// 实例化窗口对象
		JFrame frame = new JFrame("动画图标");
		frame.getContentPane().add(ai);

		// 窗口属性设置
		frame.setSize(600, 480);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 启动
		ai.startAnimation();
	}

}

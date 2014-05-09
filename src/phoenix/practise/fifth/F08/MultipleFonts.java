package phoenix.practise.fifth.F08;

import java.awt.*;

import javax.swing.*;

public class MultipleFonts extends JFrame {
	/**
	 * 构造函数
	 */
	public MultipleFonts() {
		super("显示多种字体");
		// 定义字体数组和显示的文本内容
		Font[] fonts = { new Font("Serif", Font.BOLD, 22),
				new Font("Monospaced", Font.ITALIC, 24),
				new Font("宋体", Font.PLAIN, 18), new Font("黑体", Font.PLAIN, 20),
				new Font("Serif", Font.PLAIN + Font.ITALIC, 18),
				new Font("Arail", Font.BOLD, 30) };
		String[] text = { "Font Demo", "Monospaced,斜体,24号", "宋体字示例", "黑体",
				"Serif，粗体，斜体，18号", "Arail, 粗体,30#" };

		// 读取并得到容器并且这个这个容器是垂直排列的
		Container container = getContentPane();
		Box layoutBox = Box.createVerticalBox();
		layoutBox.setBorder(BorderFactory.createEmptyBorder(10, 20, 5, 5));
		container.add(layoutBox);

		// 通过JLabel把字体的信息展示出来
		for (int i = 0; i < fonts.length; i++) {
			JLabel fontLabel = new JLabel();
			fontLabel.setFont(fonts[i]);
			fontLabel.setText(text[i]);
			layoutBox.add(fontLabel);
		}

		// 设置窗口的配置
		setSize(400, 280);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MultipleFonts();
	}
}

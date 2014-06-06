package phoenix.practise.fifthCentralPart.F22;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MyCustomCursor extends JFrame {

	public MyCustomCursor() {
		super("自定义光标");

		// 光标类型数组
		int[] cursor = { Cursor.DEFAULT_CURSOR, Cursor.HAND_CURSOR,
				Cursor.MOVE_CURSOR, Cursor.N_RESIZE_CURSOR,
				Cursor.W_RESIZE_CURSOR, Cursor.WAIT_CURSOR, Cursor.TEXT_CURSOR };

		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		for (int i = 0; i < cursor.length; i++) {
			JTextArea jta = new JTextArea(3, 6);
			// 设置文本框的光标
			jta.setCursor(Cursor.getPredefinedCursor(cursor[i]));
			container.add(jta);
		}

		// 设置图形光标的组件
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		URL url = getClass().getResource("/images/F22/arrow.gif");
		Image image = toolkit.getImage(url);
		// int width = image.getWidth(null);
		Cursor customCursor = toolkit.createCustomCursor(image, new Point(10,
				10), "MyCursor");
		JTextArea jta = new JTextArea(15, 36);
		jta.setCursor(customCursor);
		container.add(jta);

		// 窗口设置
		setSize(600, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyCustomCursor();
	}
}

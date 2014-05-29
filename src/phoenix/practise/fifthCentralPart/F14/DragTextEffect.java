package phoenix.practise.fifthCentralPart.F14;

import java.awt.*;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;

import javax.swing.*;

public class DragTextEffect extends JFrame {

	public DragTextEffect() {
		super("文本的拖动处理");

		// 字符数组,用于构造列表框
		String[] data = { "one", "two", "three", "four" };

		// 列表框实例,DragList类对象
		DragList list = new DragList(data);
		JTextArea jta = new JTextArea(8, 20);
		// 标签实例,DragLabel类对象，自定义实现
		DragLabel label = new DragLabel("拖动目标");
		jta.setLineWrap(true); // 设置自动换行
		jta.setDragEnabled(true); // 文本框可拖动
		// 实例化拖动目标为标签
		new DropTarget(label, DnDConstants.ACTION_COPY, label);
		// 页面容器布局处理
		Container container = getContentPane();
		// 实例化分隔面板,采用垂直分布的方式
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		split.setDividerLocation(140); // 设置分隔位置
		split.add(list); // 增加组件到分隔面板
		split.add(jta);
		container.add(split, BorderLayout.CENTER);
		container.add(label, BorderLayout.SOUTH);
		// 设置窗口参数
		setSize(300, 150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new DragTextEffect();
	}

}

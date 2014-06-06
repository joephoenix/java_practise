package phoenix.practise.fifthCentralPart.F21;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyFileChooser extends JFrame {

	// 声明一个文件选择器、一个按钮和一个下拉选择框
	private JFileChooser chooser;
	private JButton button;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MyFileChooser() {
		super("文件选择器演示！");

		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		chooser = new JFileChooser();

		button = new JButton("选择文件"); // 初始化按钮

		comboBox = new JComboBox(); // 初始化组合框
		comboBox.addItem("打开"); // 增加组合框列表内容
		comboBox.addItem("保存");

		contentPane.add(comboBox);
		contentPane.add(button);

		// 添加按钮触发事件
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int state;

				chooser.removeChoosableFileFilter(chooser
						.getAcceptAllFileFilter());

				chooser.addChoosableFileFilter(new MyFileFilter("gif", "图像文件"));

				if (comboBox.getSelectedIndex() == 0) {
					state = chooser.showOpenDialog(null);
				} else {
					state = chooser.showSaveDialog(null);
				}
				// 得到选择的文件
				File file = chooser.getSelectedFile();

				if (file != null && state == JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, file.getPath());
				} else if (state == JFileChooser.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "退出!");
				} else if (state == JFileChooser.ERROR_OPTION) {
					JOptionPane.showMessageDialog(null, "错误!");
				}
			}
		});

		// 窗口设置信息
		this.setSize(200, 100);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		new MyFileChooser();
	}
}

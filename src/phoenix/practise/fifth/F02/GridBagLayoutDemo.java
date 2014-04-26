package phoenix.practise.fifth.F02;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GridBagLayoutDemo extends JFrame {

	/**
	 * 构造函数，完成界面的初始化
	 */
	public GridBagLayoutDemo() {
		// 得到一个JFrame的主容器
		Container contentPane = getContentPane();
		// 设置布局管理器
		contentPane.setLayout(new GridBagLayout());
		// 声明姓名标签 Label
		JLabel labelName = new JLabel("姓名");
		// 性别标签
		JLabel labelSex = new JLabel("性别");
		// 住址标签
		JLabel labelAddress = new JLabel("住址");
		// 声明文本域，存放姓名
		JTextField textFieldName = new JTextField();
		// 地址文本域
		JTextField textFieldAddress = new JTextField();
		// 声明组合框，用来选择性别
		JComboBox comboBoxSex = new JComboBox();
		// 增加选择项
		comboBoxSex.addItem("男");
		comboBoxSex.addItem("女");
		// 添加按钮，有确定和退出
		JButton buttonConfirm = new JButton("确定");
		JButton buttonCancel = new JButton("退出");
		// 增加各个组件,并且设定其位置
		contentPane.add(labelName, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 0, 0), 0, 0));
		contentPane.add(textFieldName, new GridBagConstraints(1, 0, 1, 1, 1.0,
				0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 0, 5), 0, 0));
		contentPane.add(comboBoxSex, new GridBagConstraints(3, 0, 1, 1, 1.0,
				0.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 0, 5), 0, 0));
		contentPane.add(labelSex, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 0, 0), 0, 0));
		contentPane.add(buttonConfirm, new GridBagConstraints(1, 2, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(5, 0, 3, 0), 0, 0));
		contentPane.add(buttonCancel, new GridBagConstraints(3, 2, 1, 1, 0.0,
				0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
				new Insets(5, 0, 3, 0), 0, 0));
		contentPane.add(labelAddress, new GridBagConstraints(0, 1, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 0, 0), 0, 0));
		contentPane.add(textFieldAddress, new GridBagConstraints(1, 1, 3, 1,
				0.0, 0.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 0, 5), 0, 0));
		// 设置窗口标题
		setTitle("GridBagLayout演示");
		// 设置窗口尺寸
		setSize(300, 140);
		// 设置窗口可见
		setVisible(true);
		// 关闭窗口时退出程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		new GridBagLayoutDemo();
	}

}

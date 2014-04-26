package phoenix.practise.fifth.F01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import phoenix.practise.forth.D02FileInputStream;

@SuppressWarnings("serial")
public class IconComboBoxDemo extends JFrame {
	// 用来响应列表框选择的变化
	JLabel iconLabel = null;
	// 定制的选择下拉框
	JComboBox<Object[]> iconComboBox = null;

	@SuppressWarnings("unchecked")
	public IconComboBoxDemo() {
		// 读取运行的根路径
		String path = IconComboBoxDemo.class.getResource("").getPath();
		path = path.substring(0, path.indexOf("/bin/"));
		// 找到项目的整体图片文件夹
		path = path + "/images/";
		// 加入本工程的分类文件夹
		path = path + "F01/";
		// System.out.println(path);
		// 定义Object二维数组,用于初始化下拉框,参数依次为图标,显示文本,提示文本
		Object[][] obj = {
				{ new ImageIcon(path + "1.gif"), "旅游", "提供旅游的最新信息" },
				{ new ImageIcon(path + "2.gif"), "音乐", "提供最新的音乐资讯" },
				{ new ImageIcon(path + "3.jpg"), "聊天", "与朋友聊天" },
				{ new ImageIcon(path + "4.jpg"), "影视", "影视娱乐" },
				{ new ImageIcon(path + "5.jpg"), "家居", "家居世界" } };
		// 初始化下拉框
		iconComboBox = new JComboBox<Object[]>();
		// 设置最大可视行数
		iconComboBox.setMaximumRowCount(3);
		// 设置单元绘制器
		iconComboBox.setRenderer(new IconRenderer());
		// 增加数组中的所有元素到下拉框中
		for (int i = 0; i < obj.length; i++) {
			iconComboBox.addItem(obj[i]);
		}

		// 初始化iconLabel信息
		iconLabel = new JLabel();
		// 下拉框事件处理,用匿名类实现
		iconComboBox.addActionListener(new ActionListener() {
			// 处理事件
			public void actionPerformed(ActionEvent evt) {
				// 得到选择的内容,此处为一维数组
				Object[] obj = (Object[]) iconComboBox.getSelectedItem();
				// 设置iconLabel的图标
				iconLabel.setIcon((Icon) obj[0]);
				// 设置iconLabel的文本
				iconLabel.setText(obj[1].toString());
			}
		});

		// 增加组件到主窗体上
		this.getContentPane().setLayout(new BorderLayout()); // 设置布局管理器
		this.getContentPane().add(iconComboBox, BorderLayout.NORTH); // 在上方增加下拉框
		this.getContentPane().add(iconLabel, BorderLayout.CENTER); // 在中间增加iconLabel,用于响应选择的变化
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭窗口时退出程序
		this.setSize(800, 600); // 设置窗口尺寸
		this.setVisible(true); // 显示窗口
	}

	public static void main(String[] args) {
		new IconComboBoxDemo();
	}
}

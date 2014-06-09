package phoenix.practise.fifthCentralPart.F23;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

public class MyHttpBrowser extends JFrame {

	// 地址栏
	JTextField jtfAddress;
	// 转到文件按钮
	JButton jbGo;
	// 显示文件
	JTextPane jtpShow;
	// 提示信息
	JLabel jlInfo;

	public MyHttpBrowser() {
		super("自定义浏览器");

		// 实例化操作组件
		jtfAddress = new JTextField(20);
		jbGo = new JButton("转到");
		jtpShow = new JTextPane();
		jlInfo = new JLabel();

		// 声明展示面板
		JPanel panel = new JPanel();
		// 增加组件到面板上
		panel.add(new JLabel("地址"));
		panel.add(jtfAddress);
		panel.add(jbGo);

		// 实例化滚动栏
		JScrollPane jsp = new JScrollPane(jtpShow);

		// 得到窗体的主容器
		Container container = getContentPane();
		container.add(panel, BorderLayout.NORTH); // 增加组件到容器上
		container.add(jsp, BorderLayout.CENTER);
		container.add(jlInfo, BorderLayout.SOUTH);

		// 添加事件处理,发生按钮点击时显示页面内容
		jbGo.addActionListener(new ShowHTMLListener());
		jtfAddress.addActionListener(new ShowHTMLListener());

		// 窗口参数设置
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class ShowHTMLListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				jlInfo.setText("正在连接...");
				// 得到HTML页面的URL地址
				URL address = new URL(jtfAddress.getText());
				// 设置显示页面
				jtpShow.setPage(address);
				jlInfo.setText("完成");
			} catch (Exception ex) {
				jlInfo.setText("连接出错");
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new MyHttpBrowser();
	}

}

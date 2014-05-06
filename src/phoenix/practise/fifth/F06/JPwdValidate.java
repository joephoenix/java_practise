package phoenix.practise.fifth.F06;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class JPwdValidate extends JFrame {
	JTextField username; // 用户名输入框
	JPasswordField password; // 密码输入框
	JButton logonButton; // 登录按钮
	JButton cancelButton; // 退出按钮

	/**
	 * 构造函数，实现jframe的展示
	 */
	public JPwdValidate() {
		super("密码验证器的演示");
		// 得到awt的容器
		Container container = getContentPane();
		container.setLayout(new GridLayout(3, 2, 2, 2));

		// 初始化容器上的组件
		username = new JTextField(16);
		password = new JPasswordField(16);
		logonButton = new JButton("登录");

		// 添加登录按钮的事件处理机制
		logonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				char[] pw = password.getPassword();
				String message = "您的用户名：" + username.getText() + "\n您的密码："
						+ new String(pw);
				// 现实提示框信息
				JOptionPane.showMessageDialog(JPwdValidate.this, message);
			}
		});

		// 退出按钮初始化
		cancelButton = new JButton("退出");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		});

		// 在容器上添加组件
		container.add(new JLabel("      用户名:"));
		container.add(username);
		container.add(new JLabel("      密码:"));
		container.add(password);
		container.add(logonButton);
		container.add(cancelButton);

		// 窗体的设置
		setResizable(false);
		setSize(300, 120);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JPwdValidate();
	}
}

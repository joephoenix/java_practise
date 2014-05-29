package phoenix.practise.fifthUpperPart.F13;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;

import javax.swing.*;

public class MyClipboard extends JFrame implements ClipboardOwner {
	// 声明剪贴板
	Clipboard clipboard;
	// 用于拷贝的文本框
	JTextArea jtaCopyTo = new JTextArea(5, 10);
	// 用于粘贴的文本框
	JTextArea jtaPaste = new JTextArea(5, 10);

	/***
	 * 构造函数
	 */
	public MyClipboard() {
		super("使用剪贴板的复制/粘贴程序");
		// 获得系统剪贴板
		clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		// 设置页面的按钮和文本框
		JButton btCopy = new JButton("拷贝"); // 拷贝按钮
		JButton btPaste = new JButton("粘贴"); // 粘贴按钮
		jtaCopyTo.setLineWrap(true); // 设置换行
		jtaPaste.setLineWrap(true);
		// 设置边界
		jtaCopyTo.setBorder(BorderFactory.createTitledBorder("复制到系统剪切板"));
		jtaPaste.setBorder(BorderFactory.createTitledBorder("从系统剪切板粘贴"));
		// 得到容器，并且实例化工具栏和添加
		Container container = getContentPane();
		JToolBar toolBar = new JToolBar();
		toolBar.add(btCopy);
		toolBar.add(btPaste);
		// 处理时间的添加
		btCopy.addActionListener(new CopyListener());
		btPaste.addActionListener(new PasteListener());
		// 实例化Box
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(jtaCopyTo);
		box.add(jtaPaste);
		// 增加工具栏到容器
		container.add(toolBar, BorderLayout.NORTH);
		// 增加Box到容器
		container.add(box, BorderLayout.CENTER);
		// 窗口的参数设置
		setSize(320, 180);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * 拷贝数据处理
	 * 
	 * 用拷贝文本框文本实例化StringSelection对象
	 * 
	 * @author joephoenix
	 * 
	 */
	class CopyListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			StringSelection contents = new StringSelection(jtaCopyTo.getText()); //
			clipboard.setContents(contents, MyClipboard.this);
		}
	}

	/**
	 * 粘贴数据处理,把剪贴板的内容粘贴到文本框
	 * 
	 * @author joephoenix
	 * 
	 */
	class PasteListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Transferable contents = clipboard.getContents(this);
			if (contents != null
					&& contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
				try {
					String string = (String) contents
							.getTransferData(DataFlavor.stringFlavor);
					jtaPaste.append(string);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	/**
	 * 实现ClipboardOwner接口中的方法
	 */
	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// 暂时没有处理需要的方法
	}

	public static void main(String[] args) {
		new MyClipboard();
	}
}

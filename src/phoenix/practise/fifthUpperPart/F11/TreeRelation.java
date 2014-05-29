package phoenix.practise.fifthUpperPart.F11;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class TreeRelation extends JFrame {

	// 初始化组件
	JTextField jtfInfo;

	/**
	 * 构造函数
	 */
	public TreeRelation() {
		super("森林状的关系图");
		// 生成节点
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("设置");
		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("常规");

		// 给每个添加子节点
		node1.add(new DefaultMutableTreeNode("默认路径"));
		node1.add(new DefaultMutableTreeNode("保存选项"));

		// 子结点添加到根节点上
		root.add(node1);
		root.add(new DefaultMutableTreeNode("界面"));
		root.add(new DefaultMutableTreeNode("提示声音"));
		root.add(new DefaultMutableTreeNode("打印"));

		// 生成一个树的实例（Tree）
		JTree tree = new JTree(root);
		// 得到JTree的Renderer
		DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) tree
				.getCellRenderer();
		// 图标设置
		renderer.setLeafIcon(null);
		renderer.setClosedIcon(null);
		renderer.setOpenIcon(null);

		// 给树添加节点的事件处理
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent evt) {
				TreePath path = evt.getPath(); // 得到选择路径
				String info = path.getLastPathComponent().toString(); // 得到选择的节点名称
				jtfInfo.setText(info); // 在文本域中显示名称
			}
		});

		// 增加JTree到滚动窗格
		JScrollPane jsp = new JScrollPane(tree);
		jtfInfo = new JTextField(); // 实例化文本域
		jtfInfo.setEditable(false); // 文本域不可编辑
		getContentPane().add(jsp, BorderLayout.CENTER);
		getContentPane().add(jtfInfo, BorderLayout.SOUTH);

		// 设置窗口的属性
		setSize(250, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new TreeRelation();
	}

}

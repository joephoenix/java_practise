package phoenix.practise.fifthUpperPart.F01;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.LineBorder;

@SuppressWarnings({ "serial", "rawtypes" })
public class IconRenderer extends JLabel implements ListCellRenderer {
	public Component getListCellRendererComponent(JList list, Object obj,
			int row, boolean sel, boolean hasFocus) {
		Object[] cell = (Object[]) obj; // 得到行的参数
		setIcon((Icon) cell[0]); // 设置图标
		setText(cell[1].toString()); // 设置文本
		setToolTipText(cell[2].toString()); // 设置提示文本
		setBorder(new LineBorder(Color.WHITE)); // 设置边界
		if (sel) {
			// 如果选中了,设置文本颜色为品红色
			setForeground(Color.MAGENTA);
		} else {
			// 如果未选中,设置文本颜色为默认色
			setForeground(list.getForeground());
		}
		return this;
	}
}

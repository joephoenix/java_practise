package phoenix.practise.fifth.F04;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.MatteBorder;

public class ColorRenderer extends JLabel implements ListCellRenderer {

	/**
	 * 实现接口中的方法
	 */
	public Component getListCellRendererComponent(JList list, Object obj,
			int row, boolean sel, boolean hasFocus) {
		if (hasFocus || sel) {
			setBorder(new MatteBorder(2, 10, 2, 10,
					list.getSelectionBackground()));
		} else {
			setBorder(new MatteBorder(2, 10, 2, 10, list.getBackground()));
		}
		Color c = (Color) obj;
		setForeground(c);
		String r = Integer.toHexString(c.getRed()).toUpperCase();
		if (r.length() == 1) {
			r = "0" + r;
		}
		String g = Integer.toHexString(c.getGreen()).toUpperCase();
		if (g.length() == 1) {
			g = "0" + g;
		}
		String b = Integer.toHexString(c.getBlue()).toUpperCase();
		if (b.length() == 1) {
			b = "0" + b;
		}
		setText("#" + r + g + b);
		return this;
	}

}

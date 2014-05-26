package phoenix.practise.fifth.F14;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import javax.swing.JLabel;

public class DragLabel extends JLabel implements DropTargetListener {

	/**
	 * 构造函数
	 * 
	 * @param str
	 */
	public DragLabel(String str) {
		super(str);
	}

	@Override
	public void dragEnter(DropTargetDragEvent dtde) {

	}

	@Override
	public void dragOver(DropTargetDragEvent dtde) {

	}

	@Override
	public void dropActionChanged(DropTargetDragEvent dtde) {

	}

	@Override
	public void dragExit(DropTargetEvent dte) {

	}

	@Override
	public void drop(DropTargetDropEvent dtde) {
		try {
			// 得以Transferable对象
			Transferable trans = dtde.getTransferable();
			if (dtde.isDataFlavorSupported(DataFlavor.stringFlavor)) {
				dtde.acceptDrop(dtde.getDropAction()); // 接受拖动
				String s = (String) trans
						.getTransferData(DataFlavor.stringFlavor); // 得到拖动数据
				setText(s); // 设置标签的文本
				dtde.dropComplete(true); // 结束拖动
			} else {
				dtde.rejectDrop(); // 拒绝托运

			}
		} catch (Exception err) {
			err.printStackTrace(); // 输出出错信息
		}
	}
}

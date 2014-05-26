package phoenix.practise.fifth.F14;

import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceContext;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

import javax.swing.JList;

public class DragList extends JList implements DragGestureListener,
		DragSourceListener {
	// 拖动源
	DragSource dragSource = DragSource.getDefaultDragSource();

	/**
	 * 构造函数
	 */
	public DragList(Object[] data) {
		super(data);
		// 拖动类型
		int action = DnDConstants.ACTION_COPY_OR_MOVE;
		// 创建拖动识别
		dragSource.createDefaultDragGestureRecognizer(this, action, this);
	}

	@Override
	public void dragEnter(DragSourceDragEvent dsde) {
		DragSourceContext dragSourceContext = dsde.getDragSourceContext(); // 得到拖动上下文对象
		int action = dsde.getDropAction(); // 得到拖动命令
		if ((action & DnDConstants.ACTION_COPY) != 0) // 判断命令类型
			dragSourceContext.setCursor(DragSource.DefaultCopyDrop); // 设置光标类型
		else
			dragSourceContext.setCursor(DragSource.DefaultCopyNoDrop);

	}

	@Override
	public void dragOver(DragSourceDragEvent dsde) {

	}

	@Override
	public void dropActionChanged(DragSourceDragEvent dsde) {

	}

	@Override
	public void dragExit(DragSourceEvent dse) {

	}

	@Override
	public void dragDropEnd(DragSourceDropEvent dsde) {

	}

	@Override
	public void dragGestureRecognized(DragGestureEvent dge) {
		try {
			Transferable trans = new StringSelection(this.getSelectedValue()
					.toString()); // 得到拖动的Transferable对象
			dge.startDrag(DragSource.DefaultCopyNoDrop, trans, this); // 开始拖动操作
		} catch (Exception err) {
			err.printStackTrace(); // 输出错误信息
		}
	}

}

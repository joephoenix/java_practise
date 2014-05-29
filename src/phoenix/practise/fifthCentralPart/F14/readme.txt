该程序可以实现简单的文本拖动处理，用户可以把左边的文本拖动到右边显示出来。

data: 字符数组，用于构造列表框。
list: 列表框实例。
jta: 文本框实例。
label: 标签框实例。
container: 容器。
split: 分隔面板。
dragSource: 拖动源。
action: 拖动类型。
trans: Transferable对象。


DragTextDemo(): 创建窗口，布局窗口。
DragList(): 设置拖动类型，创建拖动识别。
dragGestureRecongized(DragGestureEvent dge): 得到拖动的Transferable对象，开始拖动操作。
dragEnter(DragSourceDragEvent dragSourcede): 拖动进入处理。
drop(DropTargetDropEvent evt): 拖动操作处理。



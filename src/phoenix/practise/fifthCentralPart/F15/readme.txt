这个程序主要介绍了如何拖动图片。用户可以随意地拖动窗口中的图片，把其拖动到窗口中的任何一个位置。
通过这个例子，读者可以学习到如何使图片具有拖动的效果。

DragPictureDemo(): 设置窗口，把图片添加到窗口上。
mouseDragge(MouseEvetn e): 鼠标事件处理，使图片具有拖动效果。

// 转换坐标系统
Point newP = SwingUtilities.convertPoint(jlPic, 
e.getPoint(), jlPic.getParent()); 
 // 设置标签的新位置
jlPic.setLocation(jlPic.getX() + (newP.x - p.x), jlPic.getY()
					+ (newP.y - p.y));
这段代码的作用是转换坐标系统，设置标签的新位置，使图片具有拖动效果。


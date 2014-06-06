该程序介绍了光标的几种不同显示方式。当鼠标移到窗口的一个表格上会显示出不同的光标形状。
通过这个例子，读者学习到怎样设置光标的形状以及怎样自定义光标。

Toolkit toolkit = Toolkit.getDefaultToolkit();
Image image = toolkit.getImage("cursor.gif"); 
// 实例化自定义光标对象
Cursor customCursor = toolkit.createCustomCursor(image,
				new Point(w/2, w/2), "MyCursor"); 
JTextArea jta = new JTextArea(3, 6); 
jta.setCursor(customCursor); 
container.add(jta); 
	
以上代码，自定义了自己的光标。需要控制光标的大小，长宽不能大于30，30。

new Point(w/2, w/2)一般需要去光标图片长宽的一半为宜。

该程序介绍了一个简单的粘贴复制的例子，用户可以把想要复制的内容写进输入框里，
然后按拷贝，再按粘贴，就可以把想要复制的内容粘贴在显示框里。

clipboard: 剪贴板。
jtaCopyTo: 用于拷贝的文本框。
jtaPaste: 用于粘贴的文本框。
btCopy: 拷贝按钮。
btPaste: 粘贴按钮。

clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	这段代码可以获得系统剪贴板。
StringSelection contents = new StringSelection(jtaCopyTo.getText());
clipboard.setContents(contents, ClipboardDemo.this)；
   这段代码用拷贝文本框文本实例化StringSelection对象，并且设置剪蛅板内容


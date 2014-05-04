该程序是一个类似聊天软件的小例子，当用户写上昵称，在输入框输入信息点击发送按钮时，就会把信息发送到显示框。

变量有：
jtfName:名字输入棫。
jtaChat:显示聊天信息。
jtaInput:输入消息。
jbSend: 发送消息按
jbClear: 钮清除消息域。
container:容器。
p：一个面板。
box：一个Box实例。

有两个函数，分别功能有：
ActonDemo():初始化窗口。
replaceMessage():把输入框的信息显示到显示框，并把输入框的信息清除

代码段说明：
这段代码的作用是使窗口接受回车事件，窗口接受到回车事件之后就会调用sendMessage()函数，
把输入框的信息显示到显示框，并把输入框的信息清除。

Box box=new Box(BoxLayout.X_AXIS);
这段代码初始化一个Box，并且设置这个Box的布局方式是水平布局的。
jtaInput.getInputMap().put(KeyStroke.getKeyStroke("ENTER"),"send");  
jtaInput.getActionMap().put("send",sendMessage); 



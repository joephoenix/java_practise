该程序介绍了一个简单的密码登录的例子，用户可以输入用户名和密码，密码的每一位是用星形显示出来的。
通过这个例子，读者可以了解到一般的登录框是怎样设计的。

container.setLayout(new GridLayout(3,2,2,2));
   这段代码设置窗口的布局管理器为GridLayout，把窗口分为3行2列，水平间距和垂直间距都是2。
password=new JPasswordField(16);
   这段代码初始化密码输入框，宽度为16列
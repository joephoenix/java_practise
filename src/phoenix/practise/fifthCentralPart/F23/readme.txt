该程序介绍了怎样创建一个简单的HTML浏览器。通过这个简单的例子，
读者可以了解到URL这个类的用法及用URL对象显示页面内容的处理方法。


该段程序主要是得HTML页面的URL地址，并且设置显示页面。

URL address = new URL(jtfAddress.getText()); 
jtpShow.setPage(address);
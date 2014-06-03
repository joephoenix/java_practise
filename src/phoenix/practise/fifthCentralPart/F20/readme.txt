该程序介绍了一个颜色选择器，用户单击选取颜色，在颜色选择器上选择颜色，就可以看到调色板下面自己选取的颜色。
通过这个例子，读者可以学习到一个颜色选择器是怎样用代码实现的。

JColorChooser chooser = new JColorChooser();
Color color = chooser.showDialog(
   JColorChooserDemo.this,”选取颜色”,Color.lightGray);
该段代码实例化了颜色选择器，并可以得到用户选取的颜色。
java的类中已经有颜色选择器了，所以要弄个颜色选择器太简单了。

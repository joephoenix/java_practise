该程序介绍如何创建滑杆及动态地展示它。
只需几行代码可以通过对滑杆的拖动，可以改变显示效果。
java包中的类已经帮我们实现了许多问题的解决方法，通过使用这些类，我们可以节省很多时间。

xSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 10);
该程序实例化了xSlider，其中new JSlider(SwingConstants.HORIZONTAL, 0, 200, 10)有四个参数，
SwingConstants.HORIZONTAL表示创建一个水平滑杆，
0表现滑杆的最小值是0,200表示滑杆的最大值是200,10表现滑杆的初始值是10
该程序主要介绍了如何使图标有动画效果。
类AnimatorIcon继承了JPanel类和实现了ActionListener接口。
通过这个例子，读者会对Timer类以及接口实现会有更深的了解。

该程序实例化了Timer类的的对象。
它创建实例的参数可能读者没有见过，其实Timer类这个类的全称是：javax.swing.Timer，
它和java.util.Timer这个类是不同的。
animationTimer对象实例化时使用了delay和this这两个参数，表示每隔delay毫秒，就会触发this事件。
因为this是指当前对象的引用，而当前对象的类实现了ActionListener接口，
所以每隔delay毫秒，就会触发actionPerformed()这个函数。

这是一个简单的文件选择器，用户可以选择打开还是保存文件，
程序设置的文件类型是图像文件,当选择到文件之后，程序显示的是你选择的文件的路径。
通过对这个例子的学习，读者可以学习到怎样创建文件选择器，怎样过滤文件类型。

代码段说明

//移去所有文件过滤器。
chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());
//增加文件过滤器，只接收gif文件。 
chooser.addChoosableFileFilter(new MyFileFilter("gif","图像文件"));
这段代码是作用是移去所有文件过滤器，增加文件过滤器，接受gif文件。
因为用户往往要打开的只是一种文件类型的文件，增加文件过滤，有助于用户快速找到自己的所需要的文件。
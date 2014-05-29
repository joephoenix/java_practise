这个程序主要介绍了用applet在网页上显示漂亮的波浪文字。
这个网页上的文字不断晃动，就像波浪一样，文字的颜色也在不断的改变。
通过这个例子，读者可以学习到怎样在网页上显示波浪文字。

// 运动角度
ang = ((phase - i * direct) % 8) / 4.0 * Math.PI; 
// 字符的X坐标
x = 20 + fontMetric.getMaxAdvance() * i + (int) (Math.cos(ang) * Hrad); 
y = 60 + (int) (Math.sin(ang) * Vrad)；//字符的Y坐标。
这段代码设置运动的角度和字符的X、Y坐标。
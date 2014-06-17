这个程序主要介绍了如何在网页上显示具有翻转效果的图片。
用户可以看到网页上的图片在不断地更换，图片更换时具有翻转效果。
通过这个例子，读者可以学习到如何使网页上的图片具有翻转的效果。

for (int i = 0; i <= (imageHeight / 2); i++) {
   Thread.sleep(30);
   graphics.setColor(Color.white);
   graphics.fillRect(0, 0, imageWidth, imageHeight);
   graphics.drawImage(images[currentImage], 0, (imageHeight / 2) - i, imageWidth, 2 * i, this);
   repaint();
}
	
这段代码的作用是实现图片的翻折效果。
图片的翻折效果看似复杂，其实很简单。
只要不断地以不同高度绘制图片，然后重绘屏幕，就可以达到翻折的效果。

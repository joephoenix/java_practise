这个程序主要了如何在网页上显示具有火焰效果的图片。
通过这个例子，读者可以学习到如何在网页上设计出具有火焰效果的图片。


这一章要好好看看，特别是back.jpg和fore.jpg的设置，初步确认是前景图片和背景图片不停地切换。

for (int j = 0; j < fireImage.getHeight(this); j = j + tileHeight) {
  for (int i = 0; i < fireImage.getWidth(this); i = i + tileWidth) {
	  fireGraphics.drawImage(backImage, i, j, this);
  }
}

这段代码使图片看起来有火焰效果。
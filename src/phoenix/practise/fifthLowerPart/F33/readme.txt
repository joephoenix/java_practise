这个程序主要介绍了在网页上展示出图像在水中的倒影。
这张图片本来是只有山没有水的，经过applet改写后的图像，竟然可以看到水景！而且水中还有倒影。
通过这个例子，读者学到怎样让图像在水中显示出倒影。

double d = (6.2831853071795862 * i) / 12;
int j = (12 - i) * imageWidth;
int waveHeight = imageHeight / 16;
for (int l = 0; l < imageHeight; l++) {
     int k = (int) ((waveHeight * (l + 28) * Math.sin(waveHeight * (imageHeight - l) / (l + 1) + d)) / imageHeight);
	 if (l < -k){
	    // 拷贝图像区域,形成波浪
	    g.copyArea(12 * imageWidth, l, imageWidth, 1, -j, 0);
	}
	else{
	    g.copyArea(12 * imageWidth, l + k, imageWidth, 1, -j, -k);
	}
}

这段代码的作用是模拟出波浪效果。

这个程序主要介绍在网页上显示百叶窗效果的图像。用户可以看到网页上图像变换时会有百叶窗的效果。
通过这个例子，读者可以学到怎样让图像显示具有百叶窗效果。

for (int i = 0; i < images.length; i++) {
			// 得到图像宽度和高度，以及像数总量
			imageWidth = images[i].getWidth(this);
			imageHeight = images[i].getHeight(this);
			totalPix = imageWidth * imageHeight;

			//
			int[] pixInImage = new int[totalPix];
			m_pix.put(i, pixInImage);
			// 获取图像像素数据
			PixelGrabber pg = new PixelGrabber(images[i], 0, 0, imageWidth,
					imageHeight, m_pix.get(i), 0, imageWidth);
			try {
				pg.grabPixels();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
这段代码的作用是获取图像像素数据。

for (int j = 0; j < imageHeight; j += (int) (imageHeight / 10)) {
								for (int k = 0; k < imageWidth; k++) {
									pixA[imageWidth * (j + i) + k] = pixB[imageWidth
											* (j + i) + k];
								}
							}
							
以上代码实现百叶窗的效果，通过修改，可以实现垂直和水平两种情况

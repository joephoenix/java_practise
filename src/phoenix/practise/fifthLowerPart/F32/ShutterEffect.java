package phoenix.practise.fifthLowerPart.F32;

import java.applet.Applet;
import java.awt.*;
import java.awt.image.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ShutterEffect extends Applet implements Runnable {

	// 待显示的图像数组及当前显示的图像
	Image images[], showImage;
	MediaTracker imageTracker;

	// 图像宽度,高度,总的图像数量,当前图像编号及下一个图像编号
	int imageWidth, imageHeight, totalImage = 5, currentImage, nextImage;

	// 图片切换效果的线程
	Thread thread;

	// 切换延迟
	int delay;

	// 图像点阵数及像素点数组
	int totalPix;
	Map<Integer, int[]> m_pix = new HashMap<Integer, int[]>();
	int pixA[], pixB[];

	// 初始化函数
	public void init() {
		// 设置Applet的背景颜色
		setBackground(Color.black);

		//
		images = new Image[totalImage];
		imageTracker = new MediaTracker(this);
		String param = new String("");

		for (int i = 0; i < totalImage; i++) {
			String useImage = "image" + i + ".jpg";
			URL url = getClass().getResource("/images/F32/");
			images[i] = getImage(url, useImage);
			imageTracker.addImage(images[i], 0);
		}

		try {
			// 装载图像
			imageTracker.waitForID(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 得到延迟参数
		param = getParameter("delay");
		if (param != null) {
			delay = Integer.parseInt(param);
		} else {
			delay = 3000;
		}

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

		currentImage = 0;
		pixA = new int[totalPix];
		pixB = new int[totalPix];
		showImage = images[0];
	}

	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	public void paint(Graphics g) {
		g.drawImage(showImage, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(delay);

				// 更改下一张图像编号
				nextImage = ((currentImage + 1) % totalImage);

				// 对两张前后相连的图片按照像素进行处理
				System.arraycopy(m_pix.get(currentImage), 0, pixA, 0, totalPix);
				if ((currentImage + 1) == m_pix.keySet().size()) {
					System.arraycopy(m_pix.get(0), 0, pixB, 0, totalPix);
				} else {
					System.arraycopy(m_pix.get(currentImage + 1), 0, pixB, 0,
							totalPix);
				}
				// 转换像素数组到图像
				showImage = createImage(new MemoryImageSource(imageWidth,
						imageHeight, pixA, 0, imageWidth));
				// 重绘屏幕
				repaint();

				/** 开始实现百叶窗效果 **/
				while (true) {
					// 垂直效果
					for (int i = 0; i < (int) (imageHeight / 10); i++) {
						try {
							// 线程休眠
							Thread.sleep(50);

							for (int j = 0; j < imageHeight; j += (int) (imageHeight / 10)) {
								for (int k = 0; k < imageWidth; k++) {
									pixA[imageWidth * (j + i) + k] = pixB[imageWidth
											* (j + i) + k];
								}
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						showImage = createImage(new MemoryImageSource(
								imageWidth, imageHeight, pixA, 0, imageWidth));
						repaint();
					}
					break;
				}
				currentImage = nextImage;
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

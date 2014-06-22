package phoenix.practise.fifthLowerPart.F38;

import java.applet.Applet;
import java.awt.*;
import java.net.URL;

public class PictureAlbum extends Applet {

	// 图片选择下拉框
	Choice choicePhoto;
	int totalImages;

	// 图像数组及当前显示图像
	Image images[], showImage;

	// 绘制图像的Graphics对象
	Graphics graphics;
	MediaTracker imagetracker;

	public void init() {
		// 设置Applet的背景颜色
		setBackground(Color.black);
		setLayout(null);
		choicePhoto = new Choice();
		// 设置下拉框边界与位置
		choicePhoto.setBounds(5, 10, 200, 20);

		String param;
		// 得到相片数量的参数
		param = getParameter("Amount");
		if (param == null) {
			totalImages = 5;
		} else {
			totalImages = Integer.parseInt(param);
		}
		images = new Image[totalImages];

		// 读取相片
		imagetracker = new MediaTracker(this);
		for (int i = 0; i < totalImages; i++) {
			param = getParameter("Name" + i);
			if (param == null) {
				choicePhoto.addItem("ViewPicture" + i);
			} else {
				choicePhoto.addItem(param);
			}
			param = getParameter("Picture" + i);
			if (param == null) {
				// 得到图像
				URL url = getClass().getResource("/medias/F38/");
				images[i] = getImage(url, "image" + i + ".jpg");
				imagetracker.addImage(images[i], i);
			} else {
				URL url = getClass().getResource("/medias/F38/");
				images[i] = getImage(url, param);
				imagetracker.addImage(images[i], i);
			}
		}
		try {
			// 等待第一张图片的加载完成
			imagetracker.waitForID(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 增加组件到Applet
		add(choicePhoto);
		Dimension dim = getSize();

		// 绘制图像
		showImage = createImage(dim.width, dim.height - 40);
		graphics = showImage.getGraphics();
	}

	public void paint(Graphics g) {
		// 绘制图像
		g.drawImage(showImage, 5, 40, this);
	}

	public boolean action(Event e, Object o) {
		// 判断是否是下拉框事件
		if (e.target == choicePhoto) {
			int selected = choicePhoto.getSelectedIndex();

			// 绘制图像
			graphics.drawImage(images[selected], 0, 0, this);
			repaint();
		}
		return true;
	}
}

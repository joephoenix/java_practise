package phoenix.practise.six.G01;

/**
 * 虚拟的单个方格类,控制方格的颜色
 */
public class RussiaBox implements Cloneable {
	private boolean isColor;

	public RussiaBox(boolean isColor) {
		this.isColor = isColor;
	}

	/*
	 * 设置颜色
	 */
	public void setColor(boolean isColor) {
		this.isColor = isColor;
	}

	/*
	 * 返回颜色
	 */
	public boolean isColorBox() {
		return isColor;
	}

	/*
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}

}

package phoenix.practise.six.G01;

import java.awt.*;

import javax.swing.JPanel;
import javax.swing.border.*;

/**
 * 游戏中方块显示的画布类
 **/
public class GameCanvas extends JPanel {
	/**
	 * 自动生成的类UUID
	 */
	private static final long serialVersionUID = -2609279590154243360L;

	// 声明一个防止方块的盒子
	private RussiaBox[][] boxes;
	// 默认盒子的大小
	private int rows = 20, cols = 12;
	private static GameCanvas canvas = null;
	// 默认为零需要调用fanning函数设置
	private int boxWidth, boxHeight;
	private Color blockColor = Color.RED, bgColor = new Color(0, 204, 204);
	private EtchedBorder border = new EtchedBorder(EtchedBorder.RAISED,
			Color.WHITE, new Color(148, 145, 140));

	/*
	 * 采用单例模式,构造函数私有，singleton
	 */
	private GameCanvas() {
		boxes = new RussiaBox[rows][cols];
		for (int i = 0; i < boxes.length; i++)
			for (int j = 0; j < boxes[i].length; j++) {
				boxes[i][j] = new RussiaBox(false);
			}
		setBorder(border);
	}

	/*
	 * 获得GameCanvas实例
	 */
	public static GameCanvas getCanvasInstance() {
		if (canvas == null)
			canvas = new GameCanvas();

		return canvas;
	}

	/*
	 * 设置画布的背景色
	 */
	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}

	/*
	 * 获得画布的背景色
	 */
	public Color getBgColor() {
		return bgColor;
	}

	/*
	 * 设置方块的颜色
	 */
	public void setBlockColor(Color blockColor) {
		this.blockColor = blockColor;
	}

	/*
	 * 方块的颜色
	 */
	public Color getBlockColor() {
		return blockColor;
	}

	/*
	 * 设置画布中方块的行数
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/*
	 * 得到画布中方块的行数
	 */
	public int getRows() {
		return rows;
	}

	/*
	 * 设置画布中方块的列数
	 */
	public void setCols(int cols) {
		this.cols = cols;
	}

	/*
	 * 得到画布中方块的列数
	 */
	public int getCols() {
		return cols;
	}

	/*
	 * 得到row行,col列的方格
	 */
	public RussiaBox getBox(int row, int col) {
		if (row >= 0 && row < rows && col >= 0 && col < cols)
			return boxes[row][col];

		else
			return null;
	}

	/*
	 * 在画布中绘制方块
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		fanning();
		for (int i = 0; i < boxes.length; i++)
			for (int j = 0; j < boxes[i].length; j++) {
				Color color = boxes[i][j].isColorBox() ? blockColor : bgColor;
				g.setColor(color);
				g.fill3DRect(j * boxWidth, i * boxHeight, boxWidth, boxHeight,
						true);
			}
	}

	/*
	 * 清除第row行
	 */
	public void removeLine(int row) {
		for (int i = row; i > 0; i--)
			for (int j = 0; j < cols; j++) {
				boxes[i][j] = (RussiaBox) boxes[i - 1][j].clone();
			}
	}

	/*
	 * 重置 为初始时的状态
	 */
	public void reset() {
		for (int i = 0; i < boxes.length; i++)
			for (int j = 0; j < boxes[i].length; j++) {
				boxes[i][j].setColor(false);
			}
		repaint();
	}

	/*
	 * 根据窗体的大小自动调整方格的大小
	 */
	public void fanning() {
		boxWidth = getSize().width / cols;
		boxHeight = getSize().height / rows;
	}
}

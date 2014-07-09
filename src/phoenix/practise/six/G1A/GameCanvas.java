package phoenix.practise.six.G1A;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameCanvas extends Canvas implements KeyListener {

	final int unitSize = 30; // 小方块边长
	int rowNum; // 正方格的行数
	int columnNum; // 正方格的列数
	int maxAllowRowNum; // 允许有多少行未削
	int blockInitRow; // 新出现块的起始行坐标
	int blockInitCol; // 新出现块的起始列坐标
	int[][] scrArr; // 屏幕数组
	Block b; // 对方快的引用

	// 画布类的构造方法
	GameCanvas() {
		rowNum = 15;
		columnNum = 10;
		maxAllowRowNum = rowNum - 2;
		b = new Block(this);
		blockInitRow = rowNum - 1;
		blockInitCol = columnNum / 2 - 2;
		scrArr = new int[32][32];
	}

	// 初始化屏幕，并将屏幕数组清零的方法
	void initScr() {
		for (int i = 0; i < rowNum; i++)
			for (int j = 0; j < columnNum; j++) {
				scrArr[j][i] = 0;
			}
		b.reset();
		repaint();
	}

	// 重新刷新画布方法
	public void paint(Graphics g) {
		for (int i = 0; i < rowNum; i++)
			for (int j = 0; j < columnNum; j++)
				drawUnit(i, j, scrArr[j][i]);
	}

	// 画方块的方法
	public void drawUnit(int row, int col, int type) {
		scrArr[row][col] = type;
		Graphics g = getGraphics();
		switch (type) { // 表示画方快的方法
		case 0:
			g.setColor(Color.black);
			break; // 以背景为颜色画
		case 1:
			g.setColor(Color.blue);
			break; // 画正在下落的方块
		case 2:
			g.setColor(Color.magenta);
			break; // 画已经落下的方法
		}
		g.fill3DRect(col * unitSize, getSize().height - (row + 1) * unitSize,
				unitSize, unitSize, true);
		g.dispose();
	}

	public Block getBlock() {
		return b; // 返回block实例的引用
	}

	// 返回屏幕数组中(row,col)位置的属性值
	public int getScrArrXY(int row, int col) {
		if (row < 0 || row >= rowNum || col < 0 || col >= columnNum)
			return (-1);
		else
			return (scrArr[row][col]);
	}

	// 返回新块的初始行坐标方法
	public int getInitRow() {
		return (blockInitRow); // 返回新块的初始行坐标
	}

	// 返回新块的初始列坐标方法
	public int getInitCol() {
		return (blockInitCol); // 返回新块的初始列坐标
	}

	// 满行删除方法
	void deleteFullLine() {
		int full_line_num = 0;
		int k = 0;
		for (int i = 0; i < rowNum; i++) {
			boolean isfull = true;
			L1: for (int j = 0; j < columnNum; j++)
				if (scrArr[j][k] == 0) {
					k++;
					isfull = false;
					break L1;
				}
			if (isfull)
				full_line_num++;
			if (k != 0 && k - 1 != i && !isfull)
				for (int j = 0; j < columnNum; j++) {
					if (scrArr[j][k] == 0)
						drawUnit(k - 1, j, 0);
					else
						drawUnit(k - 1, j, 2);
					scrArr[k - 1][j] = scrArr[j][k];
				}
		}
		for (int i = k - 1; i < rowNum; i++) {
			for (int j = 0; j < columnNum; j++) {
				drawUnit(i, j, 0);
				scrArr[j][k] = 0;
			}
		}
		ERS_Block.score += full_line_num;
		ERS_Block.scoreField.setText("" + ERS_Block.score);
	}

	// 判断游戏是否结束方法
	boolean isGameEnd() {
		for (int col = 0; col < columnNum; col++) {
			if (scrArr[maxAllowRowNum][col] != 0)
				return true;
		}
		return false;
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	// 处理键盘输入的方法
	public void keyPressed(KeyEvent e) {
		if (!ERS_Block.isPlay)
			return;
		switch (e.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			b.fallDown();
			break;
		case KeyEvent.VK_LEFT:
			b.leftMove();
			break;
		case KeyEvent.VK_RIGHT:
			b.rightMove();
			break;
		case KeyEvent.VK_SPACE:
			b.leftTurn();
			break;
		}
	}
}

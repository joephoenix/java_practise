package phoenix.practise.first;

public class YangHuiSanJiao {

	public static void main(String[] args) {
		try {
			int[][] yanghui = getYanghuiArray(11, 11);
			for (int k = 0; k < yanghui.length; k++) {
				for (int l = 0; l < yanghui[k].length; l++) {
					System.out.print(yanghui[k][l] + " ");
				}
				System.out.println();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static int[][] getYanghuiArray(int x, int y) throws Exception {
		if (x != y) {
			throw new Exception("x must eaquals y");
		}
		if (x % 2 == 0) {
			throw new java.lang.Exception("x & y must be odd number!");
		}
		int[][] yanghui = new int[x][y];
		for (int i = 1; i < x; i++) {
			if (i == 1) {
				for (int j = 0; j < y; j++) {

				}
			} else if (i == 2) {
				yanghui[i - 1][0] = 1;
				yanghui[i - 1][1] = 1;
			} else {
				int[] row = new int[i];
				row[0] = 1;
				row[row.length - 1] = 1;
				for (int j = 1; j < row.length - 1; j++) {
					row[j] = yanghui[i - 2][j - 1] + yanghui[i - 2][j];
				}
			}
		}
		return yanghui;
	}
}

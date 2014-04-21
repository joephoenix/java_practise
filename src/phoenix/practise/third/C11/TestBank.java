package phoenix.practise.third.C11;

import javax.swing.JOptionPane;

public class TestBank {

	public static void main(String[] args) {
		int i = 0, j = 0;
		int flag = 1;
		Bank bank = new Bank();
		bank.showdata();
		while (flag == 1) {
			i = -1;
			while (i < 0 || i >= Bank.M) {
				String str = JOptionPane.showInputDialog("请输入需申请资源的进程号（从0到"
						+ (Bank.M - 1) + "，否则重输入!）");
				i = Integer.parseInt(str);
				if (i < 0 || i >= Bank.M)
					System.out.println("输入的进程号不存在，重新输入!\n");
			}
			System.out.print("请输入进程" + i + "申请的资源数\n");
			for (j = 0; j < Bank.N; j++) {
				String str = JOptionPane.showInputDialog("资源" + j + ":");
				Bank.Request[j] = Integer.parseInt(str);
				if (Bank.Request[j] > Bank.NEED[i][j]) {
					System.out.print("进程" + i + "申请的资源数大于进程" + i + "还需要" + j
							+ "类资源的资源量!申请不合理，出错!请重新选择!\n");
					flag = 0;
					break;
				} else {
					if (Bank.Request[j] > Bank.AVAILABLE[j]) {
						System.out.print("进程" + i + "申请的资源数大于系统可用" + j
								+ "类资源的资源量!申请不合理，出错!请重新选择!\n");
						flag = 0;
						break;
					}
				}
			}
			if (flag == 1) {
				bank.changdata(i);
				int chkerr = bank.chkerr(i);
				if (chkerr == 1) {
					bank.rstordata(i);
					bank.showdata();
				} else {
					bank.showdata();
					int check = bank.check0(i);
					if (check == 1) {
						System.out.print("进程" + i + "已经完成，系统将其所占用资源释放\n");
						bank.free(i);
					}
				}
			} else {
				bank.showdata();
			}
			System.out.println("\n");
			String str = JOptionPane
					.showInputDialog("是否继续银行家算法演示,按'1'键继续,按'0'键退出演示");
			flag = Integer.parseInt(str);
		}
	}
}

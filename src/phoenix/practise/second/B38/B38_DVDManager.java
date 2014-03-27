package phoenix.practise.second.B38;

import java.util.Scanner;

public class B38_DVDManager {

	/**
	 * 声明DVD设置信息对象
	 */
	B38_DVDSet dvd = new B38_DVDSet();

	/**
	 * 初始化
	 */
	public void setData() {
		dvd.initial();
	}

	/**
	 * 菜单显示方法
	 */
	public void startMenu() {
		System.out.println("欢迎使用 MiniDVD Mgr 1.0");
		System.out.println("--------------------------------------------");
		System.out.println("1. 查看 DVD");
		System.out.println("2. 借阅 DVD");
		System.out.println("3. 退出 MiniDVD Mgr");
		System.out.println("--------------------------------------------\n");

		System.out.print("请选择您要进行的操作？ ");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			search();
			break;
		case 2:
			lend();
			break;
		case 3:
			System.out.println("谢谢光临！");
			break;
		}
	}

	/**
	 * 查询DVD的状况
	 */
	public void search() {
		System.out.println("MyDVD Mgr 1.0 ---> 显示DVD列表\n");

		for (int i = 0; i < dvd.names.length; i++) {
			if (dvd.names[i] == null) {
				break;
			} else if (dvd.state[i] == 1) {
				System.out.println("<<" + dvd.names[i] + ">>" + "\t\t已借出");
			} else if (dvd.state[i] == 0) {
				System.out.println("<<" + dvd.names[i] + ">>");
			}
		}

		System.out.println("--------------------------------");
		returnMain();
	}

	/**
	 * 借阅DVD
	 */
	public void lend() {
		System.out.println("MyDVD Mgr 1.0 ---> 欢迎借阅DVD\n");

		Scanner input = new Scanner(System.in);
		System.out.print("请输入DVD的名称");
		String want = input.next(); // ????????????DVD??????
		for (int i = 0; i < dvd.names.length; i++) {
			if (dvd.names[i] == null) {
				// 没有DVD信息，不进行操作
			} else if (dvd.names[i].equals(want.trim()) && dvd.state[i] == 0) {
				// 借出DVD，并且修改状态为已借阅
				dvd.state[i] = 1;
				System.out.println("借阅成功!");
				break;
			}
		}
		System.out.println("欢迎下次光临，借阅DVD!");
		System.out.println("------------------------------------");
		returnMain();
	}

	/**
	 * 返回菜单操作
	 */
	public void returnMain() {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入0返回上级菜单\n");
		if (input.nextInt() == 0) {
			startMenu();
		} else {
			System.out.println("输入错误, 异常终止！");
		}
	}

	/**
	 * 入口程序
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		B38_DVDManager mgr = new B38_DVDManager();
		mgr.setData(); // 初始化影碟数据
		mgr.startMenu();
	}

}

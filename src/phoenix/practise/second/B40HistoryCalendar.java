package phoenix.practise.second;

import java.util.Scanner;

public class B40HistoryCalendar {

	public static void main(String[] args) {
		System.out.println("******************欢 迎 使 用 万 年 历******************");
		Scanner input = new Scanner(System.in);
		System.out.print("\n请选择年份： ");
		int year = input.nextInt();
		System.out.print("\n请选择月份： ");
		int month = input.nextInt();
		System.out.println();

		int days = 0; // 存储当月的天数
		boolean isLY;

		/* 判断是否是闰年 */
		if (year % 4 == 0 && !(year % 100 == 0) || year % 400 == 0) { // 判断是否为闰年
			isLY = true; // 闰年
		} else {
			isLY = false;// 平年
		}
		if (isLY) {
			System.out.println(year + "\t闰年");
		} else {
			System.out.println(year + "\t平年");
		}

		/* 计算该月的天数 */
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		case 2:
			if (isLY) {
				days = 29;
			} else {
				days = 28;
			}
			break;
		default:
			days = 30;
			break;
		}
		System.out.println(month + "\t共" + days + "天");

		/* 计算输入的年份之前的天数 */
		int totalDays = 0;
		for (int i = 1900; i < year; i++) {
			/* 判断闰年或平年，并进行天数累加 */
			if (i % 4 == 0 && !(i % 100 == 0) || i % 400 == 0) { // 判断是否为闰年
				totalDays = totalDays + 366; // 闰年366天
			} else {
				totalDays = totalDays + 365; // 平年365天
			}
		}
		System.out.println("输入年份距离1900年1月1日的天数：" + totalDays);

		/* 计算输入月份之前的天数 */
		int beforeDays = 0;
		for (int i = 1; i <= month; i++) {
			switch (i) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				days = 31;
				break;
			case 2:
				if (isLY) {
					days = 29;
				} else {
					days = 28;
				}
				break;
			default:
				days = 30;
				break;
			}
			if (i < month) {
				beforeDays = beforeDays + days;
			}
		}
		totalDays = totalDays + beforeDays; // 距离1900年1月1日的天数
		System.out.println("输入月份距离1900年1月1日的天数：" + totalDays);
		System.out.println("当前月份的天数：" + days);

		/* 计算星期几 */
		int firstDayOfMonth; // 存储当月第一天是星期几：星期日为0，星期一~星期六为1~6
		int temp = 1 + totalDays % 7; // 从1900年1月1日推算
		if (temp == 7) { // 求当月第一天
			firstDayOfMonth = 0; // 周日
		} else {
			firstDayOfMonth = temp;
		}
		System.out.println("该月第一天是: " + firstDayOfMonth);

		/* 输出日历 */
		System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
		for (int nullNo = 0; nullNo < firstDayOfMonth; nullNo++) {
			System.out.print("\t"); // 输出空格
		}

		for (int i = 1; i <= days; i++) {
			System.out.print(i + "\t");
			if ((totalDays + i - 1) % 7 == 5) { // 如果当天为周六，输出换行
				System.out.println();
			}
		}

	}

}

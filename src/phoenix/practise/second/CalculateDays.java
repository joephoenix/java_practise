package phoenix.practise.second;

import java.util.Scanner;

public class CalculateDays {

	public String monthName;
	public int dayInYear;

	public CalculateDays() {
	}

	public static void main(String[] args) {
		System.out.println("please input the year");
		Scanner sc_year = new Scanner(System.in);
		int year = sc_year.nextInt();
		System.out.println("please input the month");
		Scanner sc_month = new Scanner(System.in);
		int month = sc_month.nextInt();
		System.out.println("please input the day");
		Scanner sc_day = new Scanner(System.in);
		int day = sc_day.nextInt();
		if (year < 0 && month > 12 && month < 0 && day > 31 && day < 0) {
			System.out.println("please input the illedge number!");
		} else if (month == 2
				&& ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
				&& day > 29 && day < 0) {
			System.out.println("please input the illedge number!");
		} else if (month == 2 && day > 29 && day < 0) {
			System.out.println("please input the illedge number!");
		}
		// 计算天数和
		CalculateDays cdNew = new CalculateDays();
		cdNew = cdNew.calculate(month, year, day);

		System.out.println("the day that " + cdNew.monthName + ". " + day
				+ "  " + year + " is the " + cdNew.dayInYear + " day in year "
				+ year);
		sc_year.close();
		sc_month.close();
		sc_day.close();
	}

	private CalculateDays calculate(int month, int year, int day) {
		CalculateDays cd = new CalculateDays();
		String name = "";
		int sum = day;
		for (int i = 1; i < month; i++) {
			switch (i) {
			case 1:
				sum += 31;
				break;
			case 2:
				if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
					sum += 29;
				} else {
					sum += 28;
				}
				;
				break;
			case 3:
				sum += 31;
				break;
			case 4:
				sum += 30;
				break;
			case 5:
				sum += 31;
				break;
			case 6:
				sum += 30;
				break;
			case 7:
				sum += 31;
				break;
			case 8:
				sum += 31;
				break;
			case 9:
				sum += 30;
				break;
			case 10:
				sum += 31;
				break;
			case 11:
				sum += 30;
				break;
			case 12:
				sum += 31;
				break;
			default:
				sum += 31;
				break;
			}
		}
		switch (month) {
		case 1:
			name = "Jan";
			break;
		case 2:
			name = "Feb";
			break;
		case 3:
			name = "Mar";
			break;
		case 4:
			name = "Apr";
			break;
		case 5:
			name = "May";
			break;
		case 6:
			name = "Jun";
			break;
		case 7:
			name = "Jul";
			break;
		case 8:
			name = "Aug";
			break;
		case 9:
			name = "Sep";
			break;
		case 10:
			name = "Oct";
			break;
		case 11:
			name = "Nov";
			break;
		case 12:
			name = "Dec";
			break;
		}
		// feedback
		cd.dayInYear = sum;
		cd.monthName = name;
		return cd;
	}
}

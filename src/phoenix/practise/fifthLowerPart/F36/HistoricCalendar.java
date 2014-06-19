package phoenix.practise.fifthLowerPart.F36;

import java.applet.Applet;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class HistoricCalendar extends Applet {

	// 顶端距离
	static final int TOP = 70;
	// 单元格尺寸
	static final int CELLWIDTH = 50, CELLHEIGHT = 30;
	static final int MARGIN = 3;
	static final int FEBRUARY = 1;

	// 控件声明
	TextField tfYear = new TextField("2004", 5);
	Choice monthChoice = new Choice();
	Button btUpdate = new Button("更新");

	// 日历的相关设置
	GregorianCalendar calendar = new GregorianCalendar();
	Font smallFont = new Font("TimesRoman", Font.PLAIN, 15);
	Font bigFont = new Font("TimesRoman", Font.BOLD, 50);

	// 日期、月份和星期的数组声明
	String days[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
	String months[] = { "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月",
			"十月", "十一月", "十二月" };
	int daysInMonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	// 查询的年份及月份
	int searchMonth, searchYear;

	public void init() {
		setBackground(Color.white);

		// 得到系统年份和月份
		searchMonth = calendar.get(Calendar.MONTH);
		searchYear = calendar.get(Calendar.YEAR);
		tfYear.setText(String.valueOf(searchYear));

		monthChoice.setFont(smallFont);
		// 增加下拉框选项
		for (int i = 0; i < 12; i++) {
			monthChoice.addItem(months[i]);
		}
		monthChoice.select(searchMonth);

		// 增加组件到Applet
		add(new Label(" 年:"));
		add(tfYear);
		add(new Label(" 月:"));
		add(monthChoice);
		add(btUpdate);

		// 对所有组件的字体进行设置
		int componentCount = this.getComponentCount();
		for (int i = 0; i < componentCount; i++) {
			getComponent(i).setFont(smallFont);
		}
	}

	public void paint(Graphics g) {
		FontMetrics fontMetric;
		int fontAscent;
		int dayPos;
		int totalWidth, totalHeight;
		int numRows;
		int xNum, yNum;
		int numDays;
		String dayStr;
		// int margin;

		// 设置当前颜色
		g.setColor(Color.lightGray);
		g.setFont(bigFont);
		g.drawString(searchYear + "年", 60, TOP + 70);
		g.drawString((searchMonth + 1) + "月", 200, TOP + 130);
		g.setColor(Color.black);
		g.setFont(smallFont);

		// 获取变量初值
		fontMetric = g.getFontMetrics();
		fontAscent = fontMetric.getAscent();
		dayPos = TOP + fontAscent / 2;

		// 得到总的表格宽度
		totalWidth = 7 * CELLWIDTH;
		for (int i = 0; i < 7; i++) {
			// 绘制表格标题栏
			g.drawString(days[i], (CELLWIDTH - fontMetric.stringWidth(days[i]))
					/ 2 + i * CELLWIDTH, dayPos - 20);
		}

		// 计算需要的行的数量
		numRows = getNumberRows(searchYear, searchMonth);
		totalHeight = numRows * CELLHEIGHT;
		for (int i = 0; i <= totalWidth; i += CELLWIDTH) {
			g.drawLine(i, TOP, i, TOP + totalHeight);
		}
		for (int i = 0, j = TOP; i <= numRows; i++, j += CELLHEIGHT) {
			g.drawLine(0, j, totalWidth, j);
		}

		//
		xNum = (getFirstDayOfMonth(searchYear, searchMonth) + 1) * CELLWIDTH
				- MARGIN;
		yNum = TOP + MARGIN + fontAscent;
		numDays = daysInMonth[searchMonth]
				+ ((calendar.isLeapYear(searchYear) && (searchMonth == FEBRUARY)) ? 1
						: 0);

		// 绘制每月的表格
		for (int day = 1; day <= numDays; day++) {
			dayStr = Integer.toString(day);
			g.drawString(dayStr, xNum - fontMetric.stringWidth(dayStr), yNum); // 绘制字符串
			xNum += CELLWIDTH;
			if (xNum > totalWidth) {
				xNum = CELLWIDTH - MARGIN;
				yNum += CELLHEIGHT;
			}
		}
	}

	// 按钮动作
	public boolean action(Event e, Object o) {
		int searchYearInt;
		if (e.target == btUpdate) {
			searchMonth = monthChoice.getSelectedIndex();
			searchYearInt = Integer.parseInt(tfYear.getText(), 10);
			if (searchYearInt > 1581) {
				searchYear = searchYearInt;
			}
			// 重绘屏幕
			repaint();
			return true;
		}
		return false;
	}

	// 得到行数量
	private int getNumberRows(int year, int month) {
		int firstDay;
		int numCells;
		if (year < 1582) {
			return (-1);
		}
		if ((month < 0) || (month > 11)) {
			return (-1);
		}
		firstDay = getFirstDayOfMonth(year, month);

		if ((month == FEBRUARY) && (firstDay == 0)
				&& !calendar.isLeapYear(year)) {
			return 4;
		}
		numCells = firstDay + daysInMonth[month];
		if ((month == FEBRUARY) && (calendar.isLeapYear(year))) {
			numCells++;
		}
		return ((numCells <= 35) ? 5 : 6);
	}

	// 得到每月的第一天
	private int getFirstDayOfMonth(int year, int month) {
		int firstDay;
		int i;
		if (year < 1582) {
			return (-1);
		}
		if ((month < 0) || (month > 11)) {
			return (-1);
		}
		firstDay = getFirstDayOfYear(year);
		for (i = 0; i < month; i++) {
			firstDay += daysInMonth[i];
		}
		if ((month > FEBRUARY) && calendar.isLeapYear(year)) {
			firstDay++;
		}
		return (firstDay % 7);
	}

	// 计算每年的第一天
	private int getFirstDayOfYear(int year) {
		int leapYears;
		int hundreds;
		int fourHundreds;
		int first;
		if (year < 1582) {
			return (-1);
		}
		leapYears = (year - 1581) / 4;
		hundreds = (year - 1501) / 100;
		leapYears -= hundreds;
		fourHundreds = (year - 1201) / 400;
		leapYears += fourHundreds;
		first = 5 + (year - 1582) + leapYears % 7;
		return first;
	}
}

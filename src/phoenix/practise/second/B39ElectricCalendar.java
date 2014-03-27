package phoenix.practise.second;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class B39ElectricCalendar extends JApplet {

	/* 定义全局变量 */
	public static final Color background = Color.white;// 背景色
	public static final Color foreground = Color.black;// 前景色
	public static final Color headerBackground = Color.DARK_GRAY;// 星期
	public static final Color headerForeground = Color.white;// 星期前景色
	public static final Color selectedBackground = Color.green;// 选中背景色
	public static final Color selectedForeground = Color.white;// 选中前景色
	public static final String WeekSun = "Sunday"; // 星期标签名称
	public static final String WeekMon = "Monday";
	public static final String WeekTue = "Tuesday";
	public static final String WeekWed = "Wendesday";
	public static final String WeekThu = "Thursday";
	public static final String WeekFri = "Friday";
	public static final String WeekSat = "Saturday";
	private JPanel MainPanel;// 日历面板
	private JLabel yearsLabel;// “年份”标签
	private JSpinner yearsSpinner;// 年份组合框
	private JLabel monthsLabel;// “月份”标签
	private JComboBox monthsComboBox; // 12月份下拉框
	private JLabel textLabel;// 标题显示标签
	private JLabel InfoLabel;// 个人信息显示标签
	private JTable daysTable; // 日表格
	private AbstractTableModel daysModel;// 天单元表格
	private Calendar calendar;// 日历对象

	// ==================================================
	/* 函数定义 */

	public B39ElectricCalendar() {
		MainPanel = (JPanel) getContentPane();
	}

	/**
	 * 初始化界面函数
	 */
	public void init() {
		MainPanel.setLayout(new BorderLayout());
		calendar = Calendar.getInstance();// 默认方式，以本地的时区和地区来构造Calendar
		// --------------------------------------
		yearsLabel = new JLabel("年份: "); // 设置年份标签显示
		yearsSpinner = new JSpinner();// 构造年份spinner组合框
		yearsSpinner.setEditor(new JSpinner.NumberEditor(yearsSpinner, "0000"));
		yearsSpinner.setValue(new Integer(calendar.get(Calendar.YEAR)));
		yearsSpinner.addChangeListener(new ChangeListener() {// 注册该组合框的事件监听器
					public void stateChanged(ChangeEvent changeEvent) {
						int day = calendar.get(Calendar.DAY_OF_MONTH);
						calendar.set(Calendar.DAY_OF_MONTH, 1);
						calendar.set(Calendar.YEAR,
								((Integer) yearsSpinner.getValue()).intValue());
						int maxDay = calendar
								.getActualMaximum(Calendar.DAY_OF_MONTH);
						calendar.set(Calendar.DAY_OF_MONTH,
								day > maxDay ? maxDay : day);
						updateView();// 更新显示
					}
				});
		// --------------------------------------
		JPanel yearMonthPanel = new JPanel();// 定义年月面板
		MainPanel.add(yearMonthPanel, BorderLayout.NORTH);// 添加年月面板到日历面板的南面（最上方）
		yearMonthPanel.setLayout(new BorderLayout());// 边布局模式
		JPanel yearPanel = new JPanel();// 构建年份面板
		yearMonthPanel.add(yearPanel, BorderLayout.WEST);// 年份面板添加到年月面板西部（左边）
		yearPanel.setLayout(new BorderLayout());// 设置年份面板为边布局并添加年份标签和组合框
		yearPanel.add(yearsLabel, BorderLayout.WEST);
		yearPanel.add(yearsSpinner, BorderLayout.CENTER);
		// --------------------------------------
		monthsLabel = new JLabel("月份: "); // 设置月份标签显示
		monthsComboBox = new JComboBox();// 月份下拉框
		for (int i = 1; i <= 12; i++) { // 构造下拉框的12个月份
			monthsComboBox.addItem(new Integer(i));
		}
		monthsComboBox.setSelectedIndex(calendar.get(Calendar.MONTH));// 下拉框当前月份为选中状态
		monthsComboBox.addActionListener(new ActionListener() { // 注册月份下拉框的事件监听器
					public void actionPerformed(ActionEvent actionEvent) {
						int day = calendar.get(Calendar.DAY_OF_MONTH);
						calendar.set(Calendar.DAY_OF_MONTH, 1);
						calendar.set(Calendar.MONTH,
								monthsComboBox.getSelectedIndex());
						int maxDay = calendar
								.getActualMaximum(Calendar.DAY_OF_MONTH);
						calendar.set(Calendar.DAY_OF_MONTH,
								day > maxDay ? maxDay : day);
						updateView();// 更新面板显示
					}
				});
		// --------------------------------------
		JPanel monthPanel = new JPanel();// 定义月份面板
		yearMonthPanel.add(monthPanel, BorderLayout.EAST);// 添加月份面板到年月面板的东面（右面）
		monthPanel.setLayout(new BorderLayout());// 月份面板设为边布局方式
		monthPanel.add(monthsLabel, BorderLayout.WEST);// 添加月份名称标签到月份面板西面（左面）
		monthPanel.add(monthsComboBox, BorderLayout.CENTER);// 添加月份下拉框到月份面板中间
		// --------------------------------------
		textLabel = new JLabel("JAVA Mini Calendar"); // 设置标题标签显示
		JPanel txetPanel = new JPanel();// 定义标题文本显示面板
		yearMonthPanel.add(txetPanel, BorderLayout.CENTER);// 添加标题文本显示面板到年月面板中间
		txetPanel.add(textLabel, BorderLayout.CENTER);// 添加标题文本标签到面板
		// --------------------------------------
		InfoLabel = new JLabel("joephoenix's product!"); // 设置个人信息标签显示
		JPanel InfoPanel = new JPanel();// 定义底部个人信息显示面板
		MainPanel.add(InfoPanel, BorderLayout.SOUTH);// 添加个人信息显示面板到日历面板南方（下方）
		InfoPanel.add(InfoLabel);// 添加信息标签文本标签到面板
		daysModel = new AbstractTableModel() { // 设置7行7列
			public int getRowCount() {
				return 7;
			}

			public int getColumnCount() {
				return 7;
			}

			public Object getValueAt(int row, int column) {
				if (row == 0) { // 第一行显示星期
					return getHeader(column);
				}
				row--;
				Calendar calendar = (Calendar) B39ElectricCalendar.this.calendar
						.clone();
				calendar.set(Calendar.DAY_OF_MONTH, 1);
				int dayCount = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
				int moreDayCount = calendar.get(Calendar.DAY_OF_WEEK) - 1;
				int index = row * 7 + column;
				int dayIndex = index - moreDayCount + 1;
				if (index < moreDayCount || dayIndex > dayCount) {
					return null;
				} else {
					return new Integer(dayIndex);
				}
			}
		};
		daysTable = new CalendarTable(daysModel, calendar); // 构造日表格
		daysTable.setCellSelectionEnabled(true);// 设置表格单元格可选择
		daysTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		daysTable.setDefaultRenderer(daysTable.getColumnClass(0),
				new TableCellRenderer() {
					public Component getTableCellRendererComponent(
							JTable table, Object value, boolean isSelected,
							boolean hasFocus, int row, int column) {
						String text = (value == null) ? "" : value.toString();
						JLabel cell = new JLabel(text);
						cell.setOpaque(true); // 绘制边界内的所有像素
						if (row == 0) { // 第一行显示星期，设置为星期的前景色和背景色
							cell.setForeground(headerForeground);
							cell.setBackground(headerBackground);
						} else {
							if (isSelected) { // 日期单元格如果选中，则设置为日期选中的前、背景色
								cell.setForeground(selectedForeground);
								cell.setBackground(selectedBackground);
							} else { // 设置日期单元格的普通前、背景色
								cell.setForeground(foreground);
								cell.setBackground(background);
							}
						}
						return cell;
					}
				});
		updateView();
		MainPanel.add(daysTable, BorderLayout.CENTER);
		// 添加日面板到日历面板中间
	}

	/**
	 * 设置星期的标题
	 * 
	 * @param index
	 * @return
	 */
	public static String getHeader(int index) {// 设置第一行星期的显示
		switch (index) {
		case 0:
			return WeekSun;
		case 1:
			return WeekMon;
		case 2:
			return WeekTue;
		case 3:
			return WeekWed;
		case 4:
			return WeekThu;
		case 5:
			return WeekFri;
		case 6:
			return WeekSat;
		default:
			return null;
		}
	}

	/**
	 * 更新面板显示方法
	 */
	public void updateView() {
		daysModel.fireTableDataChanged();
		daysTable.setRowSelectionInterval(calendar.get(Calendar.WEEK_OF_MONTH),
				calendar.get(Calendar.WEEK_OF_MONTH));
		daysTable.setColumnSelectionInterval(
				calendar.get(Calendar.DAY_OF_WEEK) - 1,
				calendar.get(Calendar.DAY_OF_WEEK) - 1);
	}

	/**
	 * 表格 固定内部类
	 * 
	 * @author joephoenix
	 * 
	 */
	public static class CalendarTable extends JTable {
		private Calendar calendar;

		/**
		 * 构造方法
		 * 
		 * @param model
		 * @param calendar
		 */
		public CalendarTable(TableModel model, Calendar calendar) {
			super(model);
			this.calendar = calendar;
		}

		/**
		 * 选择表格单元格时候的操作
		 */
		public void changeSelection(int row, int column, boolean toggle,
				boolean extend) {
			super.changeSelection(row, column, toggle, extend);
			if (row == 0) {
				return;
			}
			Object obj = getValueAt(row, column);
			if (obj != null) {
				calendar.set(calendar.DAY_OF_MONTH, ((Integer) obj).intValue());
			}

		}
	}
}

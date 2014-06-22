package phoenix.practise.fifthLowerPart.F37;

import java.applet.Applet;
import java.awt.*;

@SuppressWarnings("serial")
public class MyCalculator extends Applet {
	// 显示输入和结果的文本域
	TextField tfAnswer;

	// 运算符按钮,+,-,*,/等
	Button bPoint, bEqual, bPlus, bMinus, bClear, bMulti, bDivision;

	// 数字按钮,0~9的数字按钮
	Button[] b = new Button[10];

	// 当前操作和上一步操作
	String currentOp, preOp;

	// 当前输入和上一次输入
	String foreText, backText;

	// 运算类型标志
	boolean isFloat = false;

	/**
	 * 初始化函数
	 */
	public void init() {
		// 实例化面板,放置数字、计算符号和结果
		Panel panel1 = new Panel();
		Panel panel2 = new Panel();
		Panel panel3 = new Panel();

		currentOp = new String("");
		preOp = new String("");
		foreText = new String("");
		backText = new String("");
		tfAnswer = new TextField(8);

		setBackground(Color.lightGray);
		setForeground(Color.blue);

		// 实例化数字按钮并添加到面板
		for (int i = 9; i >= 0; i--) {
			b[i] = new Button(Integer.toString(i));
			panel2.add(b[i]); // 增加按钮到面板
		}

		// 实例化按钮和按钮颜色
		bPoint = new Button(".");
		bEqual = new Button("=");
		bEqual.setForeground(Color.red);
		bClear = new Button("清除");
		bClear.setForeground(Color.red);
		bDivision = new Button("/");
		bDivision.setForeground(Color.red);
		bMulti = new Button("*");
		bMulti.setForeground(Color.red);
		bMinus = new Button("-");
		bMinus.setForeground(Color.red);
		bPlus = new Button("+");
		bPlus.setForeground(Color.red);

		// 设置布局管理器
		setLayout(new FlowLayout());
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new GridLayout(4, 3));
		panel3.setLayout(new GridLayout(4, 1));

		// 增加组件到面板
		panel1.add(tfAnswer);
		panel1.add(bClear);
		panel2.add(bPoint);
		panel2.add(bEqual);
		panel3.add(bPlus);
		panel3.add(bMinus);
		panel3.add(bMulti);
		panel3.add(bDivision);

		// 增加组件到Applet
		add(panel1);
		add(panel2);
		add(panel3);
	}

	/**
	 * 计算事件处理
	 */
	public boolean action(Event e, Object o) {
		String s = new String("");
		for (int i = 0; i < 10; i++) {
			if (e.target == b[i] || e.target == bPoint) {
				if (e.target != bPoint) {
					s = (String) o;
					doForeText(s); // 处理输入
				}
				// 浮点数处理
				if ((e.target == bPoint) && (!isFloat)) {
					isFloat = true;
					s = (String) o;
					if (foreText.equals("")) {
						// 增加小数点前面0
						foreText += "0.";
					} else {
						doForeText(s);
					}
				}
			}
		}
		if (e.target == bClear) {
			doClear(); // 清除输入
		}
		if ((e.target == bMulti) || (e.target == bDivision)
				|| (e.target == bPlus) || (e.target == bMinus)) {
			isFloat = false;
			if (foreText != "") {
				currentOp = ((String) o);
				doOperator(); // 处理运算
			} else {
				preOp = ((String) o);
			}
		}
		if (e.target == bEqual) {
			doOperator(); // 处理运算
		}
		return true;
	}

	/***
	 * 对两个输入的数字进行计算操作
	 */
	public void doOperator() {
		double dFore, dBack;
		Double d;

		if (preOp.equals("")) {
			backText = foreText;
			foreText = "";
			tfAnswer.setText(backText);
		} else {
			dFore = (new Double(foreText)).doubleValue(); // 得到第一输入
			dBack = (new Double(backText)).doubleValue(); // 得到第二输入
			foreText = "";
			backText = tfAnswer.getText();

			// +运算处理
			if (preOp.equals("+")) {
				d = new Double((dBack + dFore)); // 得到运算结果
				tfAnswer.setText(d.toString()); // 显示运算结果
				backText = d.toString();
			}
			// -运算处理
			if (preOp.equals("-")) {
				d = new Double((dBack - dFore));
				tfAnswer.setText(d.toString());
				backText = d.toString();
			}
			// *运算处理
			if (preOp.equals("*")) {
				d = new Double((dBack * dFore));
				tfAnswer.setText(d.toString());
				backText = d.toString();
			}
			// 除法的运算处理
			if (preOp.equals("/")) {
				if (dFore == 0) {
					tfAnswer.setText("除数不能为0");
					return;
				}
				d = new Double((dBack / dFore));
				tfAnswer.setText(d.toString());
				backText = d.toString();
			}
		}
		preOp = currentOp;
	}

	/**
	 * 显示输入的字符并连接成字符串
	 * 
	 * @param s
	 */
	public void doForeText(String s) {
		foreText += s;
		tfAnswer.setText(foreText);
	}

	/**
	 * 清空当前输入，并显示上一个输入的内容
	 * 
	 * @param s
	 */
	public void doBackText(String s) {
		backText = foreText;
		foreText = "";
		tfAnswer.setText(foreText);
	}

	/**
	 * 清除输入的结果
	 */
	public void doClear() {
		currentOp = "";
		preOp = "";
		foreText = "";
		backText = "";
		isFloat = false;
		tfAnswer.setText("");
	}

}

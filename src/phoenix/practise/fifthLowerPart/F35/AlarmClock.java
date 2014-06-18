package phoenix.practise.fifthLowerPart.F35;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AlarmClock extends Applet implements Runnable {

	// 显示和输入信息的文本域
	TextField tfHour, tfMinute, tfSecond;
	TextField tfNowHour, tfNowMinute, tfNowSecond;

	// 打开和关闭闹钟按钮
	Button btStart, btStop;

	// 闹钟线程
	Thread alarm;
	boolean turnOn;

	// 初始化
	public void init() {
		turnOn = true;

		// 实例化面板
		Panel panel2 = new Panel();
		Panel panel3 = new Panel();
		Panel panel4 = new Panel();

		// 增加组件到面板上
		tfHour = new TextField(1);
		tfMinute = new TextField(1);
		tfSecond = new TextField(1);
		tfNowHour = new TextField(1);
		tfNowMinute = new TextField(1);
		tfNowSecond = new TextField(1);
		btStart = new Button("开");
		btStop = new Button("关");

		panel2.add(new Label("当前时间："));
		panel2.add(tfNowHour);
		panel2.add(new Label("时"));
		panel2.add(tfNowMinute);
		panel2.add(new Label("分"));
		panel2.add(tfNowSecond);
		panel2.add(new Label("秒"));
		panel3.add(new Label("闹钟时间："));
		panel3.add(tfHour);
		panel3.add(new Label("时"));
		panel3.add(tfMinute);
		panel3.add(new Label("分"));
		panel3.add(tfSecond);
		panel3.add(new Label("秒"));

		panel4.add(new Label("闹钟设置"));
		panel4.add(btStart);
		panel4.add(btStop);

		// 增加组件到Applet上
		add(panel2);
		add(panel3);
		add(panel4);

		// 打开闹钟按钮事件处理
		btStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				turnOn = true; // 设置打开标志为True
			}
		});

		// 关闭闹钟按钮事件处理
		btStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				turnOn = false; // 设置打开标志为false
			}
		});
	}

	// 启动线程
	public void start() {
		if (alarm == null) {
			alarm = new Thread(this);
			alarm.start();
		}
	}

	@Override
	public void run() {
		while (alarm != null) {
			try {
				alarm.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}

			// 运行闹钟
			runAlarm();
		}
	}

	private void runAlarm() {
		// 得到日历对象
		Calendar now = new GregorianCalendar();
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);

		// 更新时间显示文本域
		tfNowHour.setText(Integer.toString(hour));
		tfNowMinute.setText(Integer.toString(minute));
		tfNowSecond.setText(Integer.toString(second));

		// 如果闹钟是打开的
		if (turnOn) {
			int alarmHour = -1, alarmMinute = -1;

			// 得到设置的闹钟小时数,分钟数
			String time = tfHour.getText();
			if (time != null && !time.equals("")) {
				alarmHour = Integer.parseInt(time);
			}
			time = tfMinute.getText();
			if (time != null && !time.equals("")) {
				alarmMinute = Integer.parseInt(time);
			}

			// 比较时间，符合则播放闹铃
			if (alarmHour != -1 && alarmMinute != -1) {
				if (hour == alarmHour) {
					if (minute == alarmMinute) {
						// 取得声音文件
						URL url = getClass().getResource("/medias/F35/");
						AudioClip sound = getAudioClip(url, "alarm.wav");
						sound.play();

						// 关闭闹钟
						turnOn = false;
					}
				}
			}
		}
	}
}

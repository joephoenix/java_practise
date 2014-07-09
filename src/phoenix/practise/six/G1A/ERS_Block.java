package phoenix.practise.six.G1A;

import java.awt.*;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class ERS_Block extends JFrame {
	public static boolean isPlay = false;
	public static int level = 1, score = 0;
	public static TextField scoreField, levelField;

	public static MyTimer timer;
	GameCanvas gameScr;

	public static void main(String[] argus) {
		ERS_Block ers = new ERS_Block("俄罗斯方块游戏  V1.0  Author:Vincent");
		WindowListener win_listener = new WinListener();
		ers.addWindowListener(win_listener);
	}

	// 俄罗斯方块类的构造方法
	ERS_Block(String title) {
		super(title);

		setSize(600, 480);
		setLayout(new GridLayout(1, 2));

		gameScr = new GameCanvas();
		gameScr.addKeyListener(gameScr);

		timer = new MyTimer(gameScr);
		timer.setDaemon(true);
		timer.start();
		timer.suspend();

		add(gameScr);

		Panel rightScr = new Panel();
		rightScr.setLayout(new GridLayout(2, 1, 0, 30));
		rightScr.setSize(120, 500);
		add(rightScr);

		// 右边信息窗体的布局
		MyPanel infoScr = new MyPanel();
		infoScr.setLayout(new GridLayout(4, 1, 0, 5));
		infoScr.setSize(120, 300);
		rightScr.add(infoScr);

		// 定义标签和初始值
		Label scorep = new Label("分数:", Label.LEFT);
		Label levelp = new Label("级数:", Label.LEFT);
		scoreField = new TextField(8);
		levelField = new TextField(8);
		scoreField.setEditable(false);
		levelField.setEditable(false);
		infoScr.add(scorep);
		infoScr.add(scoreField);
		infoScr.add(levelp);
		infoScr.add(levelField);
		scorep.setSize(new Dimension(20, 60));
		scoreField.setSize(new Dimension(20, 60));
		levelp.setSize(new Dimension(20, 60));
		levelField.setSize(new Dimension(20, 60));
		scoreField.setText("0");
		levelField.setText("1");

		// 右边控制按钮窗体的布局
		MyPanel controlScr = new MyPanel();
		controlScr.setLayout(new GridLayout(5, 1, 0, 5));
		rightScr.add(controlScr);

		// 定义按钮play
		Button play_b = new Button("开始游戏");
		play_b.setSize(new Dimension(50, 200));
		play_b.addActionListener(new Command(Command.button_play, gameScr));

		// 定义按钮Level UP
		Button level_up_b = new Button("提高级数");
		level_up_b.setSize(new Dimension(50, 200));
		level_up_b.addActionListener(new Command(Command.button_levelup,
				gameScr));

		// 定义按钮Level Down
		Button level_down_b = new Button("降低级数");
		level_down_b.setSize(new Dimension(50, 200));
		level_down_b.addActionListener(new Command(Command.button_leveldown,
				gameScr));

		// 定义按钮Level Pause
		Button pause_b = new Button("游戏暂停");
		pause_b.setSize(new Dimension(50, 200));
		pause_b.addActionListener(new Command(Command.button_pause, gameScr));

		// 定义按钮Quit
		Button quit_b = new Button("退出游戏");
		quit_b.setSize(new Dimension(50, 200));
		quit_b.addActionListener(new Command(Command.button_quit, gameScr));

		controlScr.add(play_b);
		controlScr.add(level_up_b);
		controlScr.add(level_down_b);
		controlScr.add(pause_b);
		controlScr.add(quit_b);
		setVisible(true);
		gameScr.requestFocus();
	}
}

// 重写MyPanel类，使Panel的四周留空间
class MyPanel extends Panel {
	public Insets getInsets() {
		return new Insets(30, 50, 30, 50);
	}
}

package phoenix.practise.six.G1A;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Command implements ActionListener {

	static final int button_play = 1; // 给按钮分配编号
	static final int button_levelup = 2;
	static final int button_leveldown = 3;
	static final int button_quit = 4;
	static final int button_pause = 5;
	static boolean pause_resume = true;

	int curButton; // 当前按钮
	GameCanvas scr;

	// 控制按钮类的构造方法
	Command(int button, GameCanvas scr) {
		curButton = button;
		this.scr = scr;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (curButton) {
		case button_play:
			if (!ERS_Block.isPlay) {
				scr.initScr();
				ERS_Block.isPlay = true;
				ERS_Block.score = 0;
				ERS_Block.scoreField.setText("0");
				ERS_Block.timer.resume();
			}
			scr.requestFocus();
			break;
		case button_levelup:
			if (ERS_Block.level < 10) {
				ERS_Block.level++;
				ERS_Block.levelField.setText("" + ERS_Block.level);
				ERS_Block.score = 0;
				ERS_Block.scoreField.setText("" + ERS_Block.score);
			}
			scr.requestFocus();
			break;
		case button_leveldown:
			if (ERS_Block.level > 1) {
				ERS_Block.level--;
				ERS_Block.levelField.setText("" + ERS_Block.level);
				ERS_Block.score = 0;
				ERS_Block.scoreField.setText("" + ERS_Block.score);
			}
			scr.requestFocus();
			break;
		case button_pause:
			if (pause_resume) {
				ERS_Block.timer.suspend();
				pause_resume = false;
			} else {
				ERS_Block.timer.resume();
				pause_resume = true;
			}
			scr.requestFocus();
			break;
		case button_quit:
			System.exit(0);
		}
	}
}

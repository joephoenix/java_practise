package phoenix.patterns;

import phoenix.patterns.p15Command.Command;
import phoenix.patterns.p15Command.RunCommand;
import phoenix.patterns.p15Command.Invoke;
import phoenix.patterns.p15Command.Runner;
import phoenix.patterns.p15Command.SwimCommand;
import phoenix.patterns.p15Command.Swimer;

public class CommandTest {

	public static void main(String[] args) {
		Runner r = new Runner();
		Swimer w = new Swimer();
		Command cr = new RunCommand(r);
		Command cw = new SwimCommand(w);
		Invoke runIv = new Invoke(cr);
		Invoke swimIv = new Invoke(cw);

		runIv.ExecuteCommand();
		swimIv.ExecuteCommand();
	}

}

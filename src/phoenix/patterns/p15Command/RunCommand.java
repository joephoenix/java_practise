package phoenix.patterns.p15Command;

public class RunCommand extends Command {

	public RunCommand(Runner runner) {
		super(runner);
	}

	@Override
	public void Action() {
		_runner.Run1000Meters();
	}

}

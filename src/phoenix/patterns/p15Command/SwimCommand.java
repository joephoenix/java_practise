package phoenix.patterns.p15Command;

public class SwimCommand extends Command {

	public SwimCommand(Swimer swimer) {
		super(swimer);
	}

	@Override
	public void Action() {
		_swimer.Swim500Meters();
	}

}

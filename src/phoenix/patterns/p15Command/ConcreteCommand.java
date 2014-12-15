package phoenix.patterns.p15Command;

public class ConcreteCommand extends Command {

	public ConcreteCommand(Receiver receiver) {
		super(receiver);
	}

	@Override
	public void Action() {
		_receiver.Run1000Meters();
	}

}

package phoenix.patterns.p15Command;

public class Invoke {

	public Command _command;

	public Invoke(Command command) {
		this._command = command;
	}

	public void ExecuteCommand() {
		_command.Action();
	}

}

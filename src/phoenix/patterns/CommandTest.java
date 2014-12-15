package phoenix.patterns;

import phoenix.patterns.p15Command.Command;
import phoenix.patterns.p15Command.ConcreteCommand;
import phoenix.patterns.p15Command.Invoke;
import phoenix.patterns.p15Command.Receiver;

public class CommandTest {

	public static void main(String[] args) {
		Receiver r = new Receiver();
		Command c = new ConcreteCommand(r);
		Invoke i = new Invoke(c);

		i.ExecuteCommand();
	}

}

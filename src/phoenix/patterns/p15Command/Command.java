package phoenix.patterns.p15Command;

/**
 * 命令模式使得命令发出的一个和接收的一方实现低耦合，从而有以下的优点：
 * 
 * 命令模式使得新的命令很容易被加入到系统里。
 * 
 * 可以设计一个命令队列来实现对请求的Undo和Redo操作。 可以较容易地将命令写入日志。
 * 可以把命令对象聚合在一起，合成为合成命令。合成命令式合成模式的应用。
 * 
 * 命令模式的缺点：
 * 
 * 使用命令模式可能会导致系统有过多的具体命令类。这会使得命令模式在这样的系统里变得不实际。
 * 
 * 
 * @author joephoenix
 *
 */
public abstract class Command {

	protected Runner _runner;
	protected Swimer _swimer;

	public Command(Runner runner) {
		this._runner = runner;
	}

	public Command(Swimer swimer) {
		this._swimer = swimer;
	}

	public abstract void Action();
}

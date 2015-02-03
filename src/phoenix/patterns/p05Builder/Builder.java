package phoenix.patterns.p05Builder;

public abstract class Builder {

	// install CPU
	public abstract void installPartCPU();

	// install mainBoard
	public abstract void installMBoard();

	// install hardware
	public abstract void installHardware();

	// complete
	public abstract Computer getComputer();

}

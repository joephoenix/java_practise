package phoenix.patterns.p05Builder;

public class ConcreteBuilderB extends Builder {

	Computer computer = new Computer();

	@Override
	public void installPartCPU() {
		computer.add("AMD");
	}

	@Override
	public void installMBoard() {
		computer.add("AUSAI");
	}

	@Override
	public void installHardware() {
		computer.add("KingStone");
	}

	@Override
	public Computer getComputer() {
		return computer;
	}

}

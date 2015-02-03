package phoenix.patterns.p05Builder;

public class ConcreteBuilderA extends Builder {

	Computer computer = new Computer();

	@Override
	public void installPartCPU() {
		computer.add("Intel");
	}

	@Override
	public void installMBoard() {
		computer.add("MicroStar");
	}

	@Override
	public void installHardware() {
		computer.add("WestWood");
	}

	@Override
	public Computer getComputer() {
		return computer;
	}

}

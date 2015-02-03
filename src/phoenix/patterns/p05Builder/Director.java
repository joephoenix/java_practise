package phoenix.patterns.p05Builder;

public class Director {

	public void Construct(Builder builder) {
		builder.installPartCPU();
		builder.installMBoard();
		builder.installHardware();
	}

}

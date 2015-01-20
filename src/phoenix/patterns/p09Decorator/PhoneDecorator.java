package phoenix.patterns.p09Decorator;

public class PhoneDecorator extends Phone {

	private Phone phone;

	public PhoneDecorator(Phone p) {
		this.phone = p;
	}

	@Override
	public void print() {
		if (phone != null) {
			phone.print();
		}
	}

}

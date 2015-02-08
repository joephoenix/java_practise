package phoenix.patterns.p04AbstractFactory;

public class ShangHaiFactory extends AbstractFactory {

	@Override
	public YaBo createYaBo() {
		return new ShangHaiYaBo();
	}

	@Override
	public YaJia createYaJia() {
		return new ShangHaiYaJia();
	}

}

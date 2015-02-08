package phoenix.patterns.p04AbstractFactory;

public class HuNanFactory extends AbstractFactory {

	@Override
	public YaBo createYaBo() {
		return new HuNanYaBo();
	}

	@Override
	public YaJia createYaJia() {
		return new HuNanYaJia();
	}

}

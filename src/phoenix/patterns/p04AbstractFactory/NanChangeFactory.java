package phoenix.patterns.p04AbstractFactory;

public class NanChangeFactory extends AbstractFactory {

	@Override
	public YaBo createYaBo() {
		return new NanChangeYaBo();
	}

	@Override
	public YaJia createYaJia() {
		return new NanChangeYaJia();
	}

}

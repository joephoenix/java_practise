package phoenix.human;

public class Male extends Human implements Study {

	public Male() {
		this.setSex("男");
	}

	@Override
	void doPee() {
		System.out.println("他的名字是" + this.name + "，是个 " + this.sex + "孩， "
				+ "他站着撒尿！");
	}

	public void learningEnglish() {
		System.out.println(this.name + "(" + this.sex + "):  How are you?");
	}

}

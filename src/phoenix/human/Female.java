package phoenix.human;

public class Female extends Human implements Study {

	public Female() {
		this.setSex("女");
	}

	@Override
	void doPee() {
		System.out.println("她的名字是" + this.name + "，是个 " + this.sex + "孩， "
				+ "他蹲着撒尿！");
	}

	public void learningEnglish() {
		System.out.println(this.name + "(" + this.sex + ")"
				+ ": I'm fine, thank you!");
	}
}

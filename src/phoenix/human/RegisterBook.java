package phoenix.human;

public class RegisterBook {

	public static void main(String[] args) {
		Male liLei = new Male();
		liLei.setName("李磊");

		// liLei.doPee();

		Female hanmeimei = new Female();
		hanmeimei.setName("韩梅梅");

		// hanmeimei.doPee();

		liLei.learningEnglish();
		hanmeimei.learningEnglish();
	}

}

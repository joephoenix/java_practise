package phoenix.patterns;

import phoenix.patterns.p17Observer.Company;
import phoenix.patterns.p17Observer.PublicGame;
import phoenix.patterns.p17Observer.SubScriber;

public class ObserverTest {

	public static void main(String[] args) {
		Company com = new PublicGame("WOW", "is having a new version now !");
		com.addObserver(new SubScriber("Obama Clark"));
		com.addObserver(new SubScriber("Tom Smith"));

		com.update();
	}
}

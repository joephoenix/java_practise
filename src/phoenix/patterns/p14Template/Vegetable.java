package phoenix.patterns.p14Template;

public abstract class Vegetable {

	public void cookVegetable() {
		System.out.println();
		System.out.println("The normal fry vegetable method");
		this.pourOil();
		this.heatOil();
		this.pourVegetable();
		this.stir_fry();
	}

	public void pourOil() {
		System.out.println("Pour Oil");
	}

	public void heatOil() {
		System.out.println("Heat Oil");
	}

	public abstract void pourVegetable();

	public void stir_fry() {
		System.out.println("stir fry the vegetable");
	}
}

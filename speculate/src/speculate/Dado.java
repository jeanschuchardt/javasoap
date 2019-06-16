package speculate;

import java.util.Random;

public class Dado {

	private int id1;
	private int id2;

	private Random gerador;

	public Dado(int id1, int id2) {
		this.id1 = id1;
		this.id2 = id2;
		gerador = new Random(id1 + id2);
	}

	public int valorDado() {
		return gerador.nextInt(6) + 1;
	}

}

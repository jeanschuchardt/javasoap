package speculate;

public class main {

	public static void main(String[] args) {

		// Dado dado = new Dado(5, 11);

		Speculate a = new Speculate();
		a.preRegistro("jean", 1, "antonio", 2);
		a.preRegistro("jessica", 3, "lucas", 4);
		a.preRegistro("pricila", 6, "pas", 5);

		// System.out.println(a.preRlist);

		System.out.println(a.registraJogador("lucas"));

		a.print();

		System.out.println(a.registraJogador("jean"));

		a.print();

		System.out.println(a.registraJogador("antonio"));

		a.print();

		System.out.println(a.registraJogador("jessica"));
		System.out.println(a.registraJogador("pricila"));

		a.print();
		System.out.println();
		a.printpre();
		System.out.println();
		System.out.println();

		//jessica
		System.out.println("Tem partida>> "+a.temPartida(3));

		System.out.println();
		System.out.println();
		//antonio 
		System.out.println(a.temPartida(2));

		
		System.out.println();
		System.out.println(">>>>");
	
		
		//jessica
		System.out.println(a.obtemOponente(3));

		System.out.println();
		System.out.println();
		//antonio 
		System.out.println(a.obtemOponente(2));

		
		System.out.println();
		System.out.println();
		//pricila
		System.out.println(a.obtemOponente(6));

	}

}

package speculate;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

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
		System.out.println(a.registraJogador("pas"));

		a.print();
		System.out.println();
		a.printpre();
		System.out.println();
		System.out.println();

		// jessica
		System.out.println("Tem partida>> " + a.temPartida(3));

		System.out.println();
		System.out.println();
		// antonio
		System.out.println(a.temPartida(2));

		System.out.println();
		System.out.println(">>>>");

		// jessica
		System.out.println(a.obtemOponente(3));

		System.out.println();
		System.out.println();
		// antonio
		System.out.println(a.obtemOponente(2));

		System.out.println();
		System.out.println();
		// pricila
		System.out.println(a.obtemOponente(6));

		System.out.println(">>\n<<");
		System.out.println();
		System.out.println(a.partidasl.size());

		System.out.println(a.partidasl.get(0).getJogador1().getNome());
		System.out.println(a.partidasl.get(0).getJogador2().getNome());

		System.out.println();
		System.out.println(a.partidasl.get(1).getJogador1().getNome());
		System.out.println(a.partidasl.get(1).getJogador2().getNome());

		System.out.println();

		System.out.println(a.partidasl.get(2).getJogador1().getNome());
		System.out.println(a.partidasl.get(2).getJogador2().getNome());

		System.out.println(a.obtemNumBolas(1));
		System.out.println(a.obtemNumBolasOponente(2));
		System.out.println(a.obtemNumBolas(2));

		System.out.println();
		System.out.println("jogadado\n");

		System.out.println(a.obtemNumBolas(2));
		System.out.println(a.obtemNumBolasOponente(2));
		int numJogadas1 = 2;
		int numJogadas2 = 2;
		a.defineJogadas(1, numJogadas1);
		a.defineJogadas(1, numJogadas2);

//		System.out.println(a.jogaDado(2));
//		System.out.println(a.jogaDado(2));
//		System.out.println(a.jogaDado(2));
//
//		System.out.println(a.jogaDado(1));
//		System.out.println(a.obtemTabuleiro(1));
//
//		System.out.println();
//		System.out.println("define jogada "+a.defineJogadas(1, a.obtemNumBolas(1)));
//		
		boolean x = true;
		System.out.println("minhas bolas " + a.obtemNumBolas(1));
		int contador = 0;
		while (a.obtemNumBolas(1) != 0 || a.obtemNumBolas(2) != 0) {
			System.out.println(a.ehMinhaVez(1));
		System.out.println(a.ehMinhaVez(2));
			if (x) {
				if (numJogadas1 == 0) {
					if (a.ehMinhaVez(1) != 1) {
						x = false;
					}
					a.defineJogadas(2, a.obtemNumBolas(2));
					numJogadas2 = a.obtemNumBolas(2);

				}else {
				System.out.println(a.jogaDado(1));
				System.out.println(a.obtemTabuleiro(1));
				
				numJogadas1--;
				}
			} else {

				if (numJogadas2 == 0) {
					if (a.ehMinhaVez(1) != 1) {
						x = true;
					}
					a.defineJogadas(1, a.obtemNumBolas(1));
					numJogadas1 = a.obtemNumBolas(1);
					
				}
				else {
				System.out.println(a.jogaDado(2));
				System.out.println(a.obtemTabuleiro(1));

				numJogadas2--;
				}
				// break;
			}
			contador++;
			if(a.obtemNumBolas(1)==0) {
				break;
			}if(a.obtemNumBolas(2)==0) {
				break;
			}
		
		}
		System.out.println(a.jogaDado(23421));
		System.out.println(a.obtemTabuleiro(1));
		System.out.println(contador);
//
//		System.out.println();
//		System.out.println(a.partidasl.size());
//
//		System.out.println(a.partidasl.get(0).getJogador1().getNome());
//		System.out.println(a.partidasl.get(0).getJogador2().getNome());
//
//		System.out.println();
//		System.out.println(a.partidasl.get(1).getJogador1().getNome());
//		System.out.println(a.partidasl.get(1).getJogador2().getNome());
//
//		System.out.println();
//
//		System.out.println(a.partidasl.get(2).getJogador1().getNome());
//		System.out.println(a.partidasl.get(2).getJogador2().getNome());

	}

}

package speculate;

import java.util.ArrayList;
import java.util.List;

public class Speculate {
//	final int  nJogadores = 2;
//	final int nPartidas = 500;
	final int nJogadores = 2;
	final int nPartidas = 3;
	int contadorPreRegistroX = 0;
	int contadorPreRegistroY = 0;

	int contadorRegistroX = 0;
	int contadorRegistroY = 0;

	Partida partidas[];

	int contadorPartida = 0;

	Jogador preRegistro[][];
	Jogador registro[][];
	int tabuleiro[];
	// Partida partidas[][];

	List<Partida> partidasl;

	Speculate() {
		// partidas = new Partida[nPartidas][nJogadores];
		preRegistro = new Jogador[nPartidas][nJogadores];

		registro = new Jogador[nPartidas][nJogadores];
		partidas = new Partida[nPartidas];
		partidasl = new ArrayList<Partida>();
		for (int i = 0; i < nPartidas; i++) {
			for (int j = 0; j < nJogadores; j++) {
				registro[i][j] = new Jogador();
			}
		}

	}

	public int preRegistro(String nomeJogador1, int idJ1, String nomeJogador2, int idJ2) {
		Jogador j1 = new Jogador(nomeJogador1, idJ1,15);
		Jogador j2 = new Jogador(nomeJogador2, idJ2,15);

//		preRlist.add(j1);
//		preRlist.add(j2);

		preRegistro[contadorPreRegistroX][contadorPreRegistroY] = j1;

		incrementaCoontadorPreRegistroY();

		preRegistro[contadorPreRegistroX][contadorPreRegistroY] = j2;

		incrementaCoontadorPreRegistroX();
		incrementaCoontadorPreRegistroY();

//		for (Jogador[] prereg : preRegistro) {
//			for (Jogador jogador : prereg) {
//				System.out.println(jogador);
//			}
//
//		}

		return 0;
	}

	public int registraJogador(String nomeJogador) {
		for (int i = 0; i < nPartidas; i++) {
			for (int j = 0; j < nJogadores; j++) {

				if (null != preRegistro[i][j]) {
					if (preRegistro[i][j].getNome().equals(nomeJogador)) {
						registro[i][j] = preRegistro[i][j];
						preRegistro[i][j] = null;

//						int indexVazio = partidaVazia();
//						partidasl.get(indexVazio).setJogador(jogador);
//						System.out.println(indexVazio); 

					}
				}
			}
		}

		return 0;
	}

	public int encerraPartida(int idJogador) {

		return 0;
	}

	public int temPartida(int idJogador) {

		for (int i = 0; i < nPartidas; i++) {
			for (int j = 0; j < nJogadores; j++) {
				if (idJogador == registro[i][j].getIndentificador()) {
					if (j == 0) {
						if (null != registro[i][j + 1].getNome()) {
							return 1;
						} else {
							return 0;
						}
						// registro[i][j+1].getNome();
					} else if (j == 1) {
						if (null != registro[i][j - 1].getNome()) {
							return 2;
						} else {
							return 0;
						}
						
					}

				}

			}
		}

		return 0;
	}

	public String obtemOponente(int idJogador) {
		for (int i = 0; i < nPartidas; i++) {
			for (int j = 0; j < nJogadores; j++) {
				if (idJogador == registro[i][j].getIndentificador()) {
					if (j == 0) {
						if (null != registro[i][j + 1].getNome()) {
							return registro[i][j + 1].getNome();
						} else {
							return null;
						}
						// registro[i][j+1].getNome();
					} else if (j == 1) {
						if (null != registro[i][j - 1].getNome()) {
							return registro[i][j - 1].getNome();
						} else {
							return null;
						}
						
					}

				}

			}
		}


		return null;
	}

	public int ehMinhaVez(int idJogador) {
		// TODO write your implementation code here:
		return 0;
	}

	public int obtemNumBolas(int idJogador) {
		// TODO write your implementation code here:
		return 0;
	}

	public int obtemNumBolasOponente(int idJogador) {
		// TODO write your implementation code here:
		return 0;
	}

	public String obtemTabuleiro(int idJogador) {
		// TODO write your implementation code here:
		return null;
	}

	public int defineJogadas(String idJogador) {
		// TODO write your implementation code here:
		return 0;
	}

	public int jogaDado(int idJogador) {
		// TODO write your implementation code here:
		return 0;
	}

	/* private */

	private void incrementaCoontadorPreRegistroY() {
		if (contadorPreRegistroY == 0) {

			contadorPreRegistroY = 1;

		} else if (contadorPreRegistroY == 1) {

			contadorPreRegistroY = 0;
		}
	}

	private void incrementaCoontadorPreRegistroX() {
		if (contadorPreRegistroX < nPartidas) {

			contadorPreRegistroX += 1;

		} else {
			throw new IllegalArgumentException();

		}
	}

	private int partidaVazia() {
		int index = 0;
		for (Partida partida : partidasl) {
			if (partida.temEspaco() == 0) {
				return index;
			}
			index++;
		}
		return -1;
	}

	public void print() {
		for (int i = 0; i < nPartidas; i++) {
			for (int j = 0; j < nJogadores; j++) {
				System.out.println(registro[i][j]);
			}
		}
	}

	public void printpre() {
		for (int i = 0; i < nPartidas; i++) {
			for (int j = 0; j < nJogadores; j++) {
				System.out.println(preRegistro[i][j]);
			}
		}
	}
}

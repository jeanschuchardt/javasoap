package speculate;

import java.util.ArrayList;
import java.util.List;

public class Speculate {

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

	List<Partida> partidasl;

	Speculate() {

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
//		Jogador j1 = new Jogador(nomeJogador1, idJ1, 15);
//		Jogador j2 = new Jogador(nomeJogador2, idJ2, 15);
		Jogador j1 = new Jogador(nomeJogador1, idJ1);
		Jogador j2 = new Jogador(nomeJogador2, idJ2);

		preRegistro[contadorPreRegistroX][contadorPreRegistroY] = j1;

		incrementaCoontadorPreRegistroY();

		preRegistro[contadorPreRegistroX][contadorPreRegistroY] = j2;

		incrementaCoontadorPreRegistroX();
		incrementaCoontadorPreRegistroY();

		return 0;
	}

	public int registraJogador(String nomeJogador) {
		for (int i = 0; i < nPartidas; i++) {
			for (int j = 0; j < nJogadores; j++) {

				if (null != preRegistro[i][j]) {
					if (preRegistro[i][j].getNome().equals(nomeJogador)) {
						registro[i][j] = preRegistro[i][j];
						preRegistro[i][j] = null;
						Jogador j1;
						Jogador j2;
						if (j == 0) {
							j1 = registro[i][j];
							j2 = registro[i][j + 1];
							if (null != j1.getNome() && null != j2.getNome()) {
								partidasl.add(new Partida(registro[i][j], registro[i][j + 1]));
							}
						} else if (j == 1) {
							j1 = registro[i][j - 1];
							j2 = registro[i][j];

							if (null != j1.getNome() && null != j2.getNome()) {
								partidasl.add(new Partida(registro[i][j - 1], registro[i][j]));
							}

						}
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
		int i = 0;
		for (Partida partida : partidasl) {
			String ehVez = partida.getEhVez();
			if (idJogador == partida.getIdJ1()) {

				if (ehVez == "J1") {
					return 1;
				}

			} else if (idJogador == partida.getIdJ2()) {
				if (ehVez == "J2") {
					return 1;
				}

			}
			i++;
		}
		return -1; // jogador nao encontrad;o
		// TODO: - 2 algum erro
		// TODO: 2 é vencedor
		// TODO: 3 é perdedor
		// TODO: 5 vencedor por wo
		// TODO: 6 perdedor por wo
	}

	public int obtemNumBolas(int idJogador) {
		int i = 0;
		for (Partida partida : partidasl) {
			if (idJogador == partida.getIdJ1()) {
				return partida.getBolasJ1();
			} else if (idJogador == partida.getIdJ2()) {
				return partida.getBolasJ2();
			}
			i++;
		}
		return -1;

	}

	public int obtemNumBolasOponente(int idJogador) {
		int i = 0;
		for (Partida partida : partidasl) {
			if (idJogador == partida.getIdJ1()) {
				return partida.getBolasJ2();
			} else if (idJogador == partida.getIdJ2()) {
				return partida.getBolasJ1();
			}
			i++;
		}
		return -1;

	}

	public String obtemTabuleiro(int idJogador) {
		int i = 0;
		for (Partida partida : partidasl) {
			String ehVez = partida.getEhVez();
			if (idJogador == partida.getIdJ1()) {
				return partida.getTabuleiroString();

			} else if (idJogador == partida.getIdJ2()) {
				return partida.getTabuleiroString();

			}
			i++;
		}

		return "";// erro;
	}

	public int defineJogadas(int idJogador, int numJogadas) {
		int i = 0;
		for (Partida partida : partidasl) {
			// i++;
			if (idJogador == partida.getIdJ1()) {
				if (partida.getEhVez() == "J1") {
					return partida.setJogadasJ1(numJogadas);
				}
			} else if (idJogador == partida.getIdJ2()) {
				if (partida.getEhVez() == "J2") {
					return partida.setJogadasJ2(numJogadas);
				}
			} else {
				return -2;
			}

		}
		return -1;

		// TODO: -2
		// TODO: -3
		// TODO: -4

	}

	public int jogaDado(int idJogador) {

		Jogador j1, j2;
		Partida p = null;
		int index = -1;
		int i = 0;
		for (Partida partida : partidasl) {
			if (idJogador == partida.getIdJ1() || idJogador == partida.getIdJ2()) {
				p = partida;
				index = i;
			}
		}

		try {

			if (p.getEhVez() == "J1") {
				if (p.getJogadasJ1() != 0) {
					if (p.getIdJ1() == idJogador) {
						int valorDado = p.getDado().valorDado();
						System.out.println("valor dado: " + valorDado);
						valorDado = valorDado - 1;
						String t[] = p.getTabuleiro();

						if (valorDado == 5) {
							p.dencrementaBolasJ1();
						}

						else if (t[valorDado] == "*") {
							t[valorDado] = "" + (valorDado + 1);
							p.incrementaBolasJ1();
						} else {
							t[valorDado] = "*";
							p.dencrementaBolasJ1();
						}
						System.out.println("bolas jogador: " + p.getBolasJ1());
						p.decrementaJogadasJ1();

						if (p.getJogadasJ1() == 0) {
							p.trocaVez();
						}

						partidasl.remove(index);
						partidasl.add(index, p);

						return valorDado;
					}
				} else if (p.getIdJ1()== idJogador && p.getJogadasJ1() == 0 && p.getEhVez()=="J1") {
					return -4;
				}
			} else {
				if (p.getJogadasJ2() != 0) {
					if (p.getIdJ2() == idJogador) {

						int valorDado = p.getDado().valorDado();
						System.out.println("valor dado: " + valorDado);
						valorDado = valorDado - 1;

						String t[] = p.getTabuleiro();
						if (valorDado == 5) {
							p.dencrementaBolasJ2();
						} else

						if (t[valorDado] == "*") {

							t[valorDado] = "" + (valorDado + 1);
							p.incrementaBolasJ2();
						}

						else {
							t[valorDado] = "*";
							p.dencrementaBolasJ2();
						}

						System.out.println("bolas jogador: " + p.getBolasJ2());
						p.decrementaJogadasJ2();
						if (p.getJogadasJ2() == 0) {
							p.trocaVez();
						}

						partidasl.remove(index);
						partidasl.add(index, p);

						return valorDado;
					}
				} else if (p.getIdJ2()== idJogador && p.getJogadasJ2() == 0 && p.getEhVez()=="J2") {
					return -4;
				}
			}

		} catch (Exception e) {
			//System.out.println(e.getCause());
			return -2;
		}

		return -3;
	}

	/* private */
	private int buscapartida(int idJogador) {
		int i = 0;
		for (Partida partida : partidasl) {
			if (idJogador == partida.getIdJ1()) {
				return i;
			} else if (idJogador == partida.getIdJ1()) {
				return i;
			}
			i++;
		}
		return -1;
	}

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

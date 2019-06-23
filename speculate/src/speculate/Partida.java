package speculate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Partida {

	private Jogador jogador1;
	private Jogador jogador2;
	private String tabuleiro[] = { "*", "2", "*", "4", "*", "6" };
	private int bolasJ1;
	private int bolasJ2;
	private int jogadasJ1;
	private int jogadasJ2;
	private String ehVez = "J1";

	private boolean partidaFinalizada ;
	private String jogadorFinalizadaor = "";
	private Jogador jogadorPerdedor;
	private Jogador jogadorGanhador;

	private Dado dado;

	public int setJogador(Jogador jogador) {
		if (null == jogador1) {
			jogador1 = jogador;
			return jogador1.getIndentificador();
		} else if (null != jogador1 && null == jogador2) {
			jogador2 = jogador;
			return jogador2.getIndentificador();
		} else {
			return -2;
		}

	}

	public int temEspaco() {
		if (jogador1 == null || jogador2 == null) {
			return 0;
		} else {
			return -1;
		}
	}

	public int getIdJ1() {
		return jogador1.getIndentificador();
	}

	public int getIdJ2() {
		return jogador2.getIndentificador();
	}

	public Partida(Jogador jogador1, Jogador jogador2) {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		bolasJ1 = 2;
		bolasJ2 = 2;
		dado = new Dado(jogador1.getIndentificador(), jogador2.getIndentificador());
		partidaFinalizada = false;

	}

	public int setJogadasJ1(int num) {
		if (num > getBolasJ1()) {
			return -5;

		} else {
			jogadasJ1 = num;
			return 1;
		}
	}

	public int setJogadasJ2(int num) {
		if (num > getBolasJ2()) {
			return -5;

		} else {
			jogadasJ2 = num;
			return 1;
		}
	}

	public void trocaVez() {
		if (ehVez == "J1") {
			ehVez = "J2";
		} else {
			ehVez = "J1";
		}
	}

	public void incrementaBolasJ1() {
		bolasJ1 += 1;
	}

	public void incrementaBolasJ2() {
		bolasJ2 += 1;
	}

	public void dencrementaBolasJ1() throws Exception {
		if (bolasJ1 > 0) {
			bolasJ1 -= 1;
		} else {
			throw new Exception("numero de bolas = 0");
		}
	}

	public void dencrementaBolasJ2() throws Exception {
		if (bolasJ2 > 0) {
			bolasJ2 -= 1;
		}else
		{
			throw new Exception("numero de bolas = 0");
		}
		
	}
	
	public void decrementaJogadasJ1() throws Exception {
		if(jogadasJ1>0) {
			jogadasJ1 -=1;
		}else {
			throw new Exception("numero de jogadas = 0");
		}
		
	}
	public void decrementaJogadasJ2() throws Exception {
		if(jogadasJ2>0) {
			jogadasJ2 -=1;
		}else {
			throw new Exception("numero de jogadas = 0");
		}
		
	}
	public String getTabuleiroString() {
		String a = "";
		for (String string : tabuleiro) {
			a = a + string +"\t";
		}
		return a;
		
	}
}
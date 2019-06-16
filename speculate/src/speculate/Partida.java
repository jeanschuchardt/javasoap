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
	private int tabuleiro[];
	private int bolasJ1;
	private int bolasJ2;

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
		}else {
			return -1;
		}
	}

}
package com.mycompany.speculatews_service.speculate;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Partida {
	private Jogador jogador1 = null;
	private Jogador jogador2 = null;
	
	private Jogador proximoJogador = null;
	
	private Jogador vencedor = null;
	private int bolasJ1;
	private int bolasJ2;
	
	private Boolean desistencia = false;
	private Tabuleiro tabuleiro = null;
        private Dado dado = null;
	private int id;
	private Boolean partidaTerminada = false;
	private int jogadas = 0;

	public Partida(int id) {
		this.id = id;
		this.bolasJ1 = 15;
		this.bolasJ1 = 15;
	}
	
	
	
	private void jogadorDesistente() {
		// faz a verificaï¿½ï¿½o de qual jogador desistiu da partida
		int id = proximoJogador.getIndentificador();
		if(id == jogador1.getIndentificador()) {
			this.vencedor = jogador2;
			this.proximoJogador = jogador2;
		} else {
			this.vencedor = jogador1;
			this.proximoJogador = jogador1;
		}
	}
	
	
	
	
	public void criaTabuleiro() {
		this.tabuleiro = new Tabuleiro();
	}
        
        public void criaDado(){
            this.dado = new Dado(this.getJogador1().getIndentificador(), this.getJogador2().getIndentificador());
        }
	
	public int jogaDados() {
		int valorDado = dado.valorDado();
		boolean efeito = this.tabuleiro.recebeJogada(valorDado);
		// verifica o efeito da jogada no tabuleiro
		// true -> jogador recebe uma bola, porque a casa jï¿½ estava ocupada
		if(efeito) {
			proximoJogador.setBolas(proximoJogador.getBolas()+1);
		// false -> jogador se desfaz da bola, porque a casa estava vazia 
		} else {
			proximoJogador.setBolas(proximoJogador.getBolas()-1);
		}
		this.jogadas--;
		this.fimJogadas();
		return valorDado;
	}
	
	
	
	public void terminarPartida() {
		this.partidaTerminada = true;
	}
	
	
	
	private void fimJogadas() {
		// verifica se as jogadas do jogador atual acabaram
		if(this.jogadas == 0) {
			// se n�o restou nenhuma bola ele � o vencedor
			if(this.proximoJogador.getBolas() == 0) {
				this.vencedor = this.proximoJogador ;
			}
			this.trocaVez();
		}
	}
	
	private void trocaVez() {
		// muda o turno para o proximo jogador
		int id = this.proximoJogador.getIndentificador();
		if(jogador1.getIndentificador() == id) {
			this.proximoJogador = jogador2;
		} else {
			this.proximoJogador = jogador1;
		}
	}
	

}
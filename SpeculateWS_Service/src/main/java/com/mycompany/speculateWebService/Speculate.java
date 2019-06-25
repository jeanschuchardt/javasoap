package com.mycompany.speculateWebService;

import com.mycompany.speculatews_service.speculate.Dado;
import com.mycompany.speculatews_service.speculate.Jogador;
import com.mycompany.speculatews_service.speculate.Partida;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "SpeculateWS_Service")
public class Speculate {

    final int nJogadores = 2;
    final int nPartidas = 500;
    int contadorPreRegistroX = 0;
    int contadorPreRegistroY = 0;
    int contadorRegistroX = 0;
    int contadorRegistroY = 0;
    Partida[] partidas;
    int contadorPartida = 0;
    Jogador[][] preRegistro;
    Jogador[][] registro;
    int[] tabuleiro;
    List<Partida> partidasl;

    public Speculate() {
        this.preRegistro = new Jogador[nPartidas][nJogadores];

        this.registro = new Jogador[nPartidas][nJogadores];
        this.partidas = new Partida[nPartidas];
        this.partidasl = new ArrayList();
        for (int i = 0; i < nPartidas; i++) {
            for (int j = 0; j < nJogadores; j++) {
                this.registro[i][j] = new Jogador();
            }
        }
    }

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "preRegistro")
    public int preRegistro(@WebParam(name = "nomeJogador1") String nomeJogador1, @WebParam(name = "idJ1") int idJ1, @WebParam(name = "nomeJogador2") String nomeJogador2, @WebParam(name = "idJ2") int idJ2) {
        Jogador j1 = new Jogador(nomeJogador1, idJ1);
        Jogador j2 = new Jogador(nomeJogador2, idJ2);

        this.preRegistro[this.contadorPreRegistroX][this.contadorPreRegistroY] = j1;

        incrementaCoontadorPreRegistroY();
        System.out.println("J1 "+this.contadorPreRegistroX+","+this.contadorPreRegistroY);
        

        this.preRegistro[this.contadorPreRegistroX][this.contadorPreRegistroY] = j2;

        System.out.println("J2 "+this.contadorPreRegistroX+","+this.contadorPreRegistroY);
        incrementaCoontadorPreRegistroX();
        incrementaCoontadorPreRegistroY();
        System.out.println("next "+this.contadorPreRegistroX+","+this.contadorPreRegistroY);
        return 0;
    }

    @WebMethod(operationName = "registraJogador")
    public int registraJogador(@WebParam(name = "nomeJogador") String nomeJogador) {
        Jogador jogador = null;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if ((null != this.preRegistro[i][j])
                        && (this.preRegistro[i][j].getNome().equals(nomeJogador))) {
                    this.registro[i][j] = this.preRegistro[i][j];
                    jogador = this.preRegistro[i][j];
                    this.preRegistro[i][j] = null;
                    if (j == 0) {
                        Jogador j1 = this.registro[i][j];
                        Jogador j2 = this.registro[i][(j + 1)];
                        if ((null != j1.getNome()) && (null != j2.getNome())) {
                            this.partidasl.add(new Partida(this.registro[i][j], this.registro[i][(j + 1)]));
                        }
                    } else if (j == 1) {
                        Jogador j1 = this.registro[i][(j - 1)];
                        Jogador j2 = this.registro[i][j];
                        if ((null != j1.getNome()) && (null != j2.getNome())) {
                            this.partidasl.add(new Partida(this.registro[i][(j - 1)], this.registro[i][j]));
                        }
                    }
                }
            }
        }
        if (jogador != null) {
            return jogador.getIndentificador();
        }
        return -1;
    }

    @WebMethod(operationName = "encerraPartida")
    public int encerraPartida(@WebParam(name = "idJogador") int idJogador) {
        int i = 0;
        for (Partida partida : this.partidasl) {
            if (idJogador == partida.getIdJ1()) {
                if ((partida.getBolasJ1() > 0) && (partida.getBolasJ2() > 0)) {
                    partida.setPartidaFinalizada(true);
                    partida.setJogadorFinalizadaor("J1");
                    partida.setJogadorGanhador(partida.getJogador2());
                    return 0;
                }
                return 0;
            } else if (idJogador == partida.getIdJ2()) {
                if ((partida.getBolasJ1() > 0) && (partida.getBolasJ2() > 0)) {
                    partida.setPartidaFinalizada(true);
                    partida.setJogadorFinalizadaor("J1");
                    partida.setJogadorGanhador(partida.getJogador1());
                    return 0;
                }
                return 0;
            }

            i++;
        }
        return -1;
    }

    @WebMethod(operationName = "temPartida")
    public int temPartida(@WebParam(name = "idJogador") int idJogador) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if (idJogador == this.registro[i][j].getIndentificador()) {
                    if (j == 0) {
                        if (null != this.registro[i][(j + 1)].getNome()) {
                            return 1;
                        }
                        return 0;
                    }
                    if (j == 1) {
                        if (null != this.registro[i][(j - 1)].getNome()) {
                            return 2;
                        }
                        return 0;
                    }
                }
            }
        }
        return 0;
    }

    @WebMethod(operationName = "obtemOponente")
    public String obtemOponente(@WebParam(name = "idJogador") int idJogador) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if (idJogador == this.registro[i][j].getIndentificador()) {
                    if (j == 0) {
                        if (null != this.registro[i][(j + 1)].getNome()) {
                            return this.registro[i][(j + 1)].getNome();
                        }
                        return "";
                    }
                    if (j == 1) {
                        if (null != this.registro[i][(j - 1)].getNome()) {
                            return this.registro[i][(j - 1)].getNome();
                        }
                        return "";
                    }
                }
            }
        }
        return "";
    }

    @WebMethod(operationName = "ehMinhaVez")
    public int ehMinhaVez(@WebParam(name = "idJogador") int idJogador) {
        int i = 0;
        for (Partida partida : this.partidasl) {
            String ehVez = partida.getEhVez();
            if (idJogador == partida.getIdJ1()) {
                if (!partida.isPartidaFinalizada()) {
//                    if (partida.getJogadasJ1() == 0) {
//                        partida.trocaVez();
//                    }
                    if (partida.getBolasJ2() == 0) {
                        return 3;
                    }
                    if (partida.getBolasJ1() == 0) {
                        return 2;
                    }
                    if (ehVez == "J1") {
                        return 1;
                    }
                    if (ehVez == "J2") {
                        return 0;
                    }
                } else {
                    if (partida.getJogadorFinalizadaor() == "J1") {
                        return 6;
                    }
                    return 5;
                }
            } else if (idJogador == partida.getIdJ2()) {
                if (!partida.isPartidaFinalizada()) {
//                    if (partida.getJogadasJ2() == 0) {
//                        partida.trocaVez();
//                    }
                    if (partida.getBolasJ1() == 0) {
                        return 3;
                    }
                    if (partida.getBolasJ2() == 0) {
                        return 2;
                    }
                    if ("J2".equals(ehVez)) {
                        return 1;
                    }
                    if (ehVez == "J1") {
                        return 0;
                    }
                } else {
                    if ("J2".equals(partida.getJogadorFinalizadaor())) {
                        return 6;
                    }
                    return 5;
                }
            }
            i++;
        }
        return -2;
    }

    @WebMethod(operationName = "obtemNumBolas")
    public int obtemNumBolas(@WebParam(name = "idJogador") int idJogador) {
        int i = 0;
        for (Partida partida : this.partidasl) {
            if (idJogador == partida.getIdJ1()) {
                return partida.getBolasJ1();
            }
            if (idJogador == partida.getIdJ2()) {
                return partida.getBolasJ2();
            }
            i++;
        }
        return -1;
    }

    @WebMethod(operationName = "obtemNumBolasOponente")
    public int obtemNumBolasOponente(@WebParam(name = "idJogador") int idJogador) {
        int i = 0;
        for (Partida partida : this.partidasl) {
            if (idJogador == partida.getIdJ1()) {
                return partida.getBolasJ2();
            }
            if (idJogador == partida.getIdJ2()) {
                return partida.getBolasJ1();
            }
            i++;
        }
        return -1;
    }

    @WebMethod(operationName = "obtemTabuleiro")
    public String obtemTabuleiro(@WebParam(name = "idJogador") int idJogador) {
        int i = 0;
        for (Partida partida : this.partidasl) {
            String ehVez = partida.getEhVez();
            if (idJogador == partida.getIdJ1()) {
                return partida.getTabuleiroString();
            }
            if (idJogador == partida.getIdJ2()) {
                return partida.getTabuleiroString();
            }
            i++;
        }
        return "";
    }

    @WebMethod(operationName = "defineJogadas")
    public int defineJogadas(@WebParam(name = "idJogador") int idJogador, @WebParam(name = "numJogadas") int numJogadas) {
        int i = 0;
        for (Partida partida : this.partidasl) {
            if (idJogador == partida.getIdJ1()) {
                if (numJogadas <= partida.getBolasJ1()) {
                    if ("J1".equals(partida.getEhVez())) {
                        partida.setJogadasJ1(numJogadas);
                        return 1;// partida.setJogadasJ1(numJogadas);
                    } else {
                        return -3;
                    }
                } else {
                    return -5;
                }
            } else if (idJogador == partida.getIdJ2()) {
                if (numJogadas <= partida.getBolasJ2()) {
                    if ("J2".equals(partida.getEhVez())) {
                        partida.setJogadasJ2(numJogadas);
                        return 1;// partida.setJogadasJ2(numJogadas);
                    } else {
                        return -3;
                    }
                } else {
                    return -5;
                }
            }
            return -2;
            //tirei o return -1 para tentar solucionar um erro 
        }
        return -2;
    }

    @WebMethod(operationName = "jogaDado")
    public int jogaDado(@WebParam(name = "idJogador") int idJogador
    ) {
        Partida p = null;
        int index = -1;
        int i = 0;
        for (Partida partida : this.partidasl) {
            if ((idJogador == partida.getIdJ1()) || (idJogador == partida.getIdJ2())) {
                p = partida;
                index = i;
            }
        }
        try {
            if ("J1".equals(p.getEhVez())) {
                if (p.getJogadasJ1() != 0) {
                    if (p.getIdJ1() == idJogador) {
                        int valorDado = p.getDado().valorDado();
                        //  System.out.println("valor dado: " + valorDado);
                        valorDado -= 1;
                        String[] t = p.getTabuleiro();
                        if (valorDado == 5) {
                            p.dencrementaBolasJ1();
                        } else if ("*".equals(t[valorDado])) {
                            t[valorDado] = ("" + (valorDado + 1));
                            p.incrementaBolasJ1();
                        } else {
                            t[valorDado] = "*";
                            p.dencrementaBolasJ1();
                        }
                        //  System.out.println("bolas jogador: " + p.getBolasJ1());
                        p.decrementaJogadasJ1();
                        if (p.getJogadasJ1() == 0) {
                            if (p.getBolasJ1() == 0) {
                                p.setJogadorGanhador(p.getJogador1());
                                p.setJogadorPerdedor(p.getJogador2());
                            }
                            p.trocaVez();
                        }

                        this.partidasl.remove(index);
                        this.partidasl.add(index, p);

                        return valorDado + 1;
                    }
                } else if ((p.getIdJ1() == idJogador) && (p.getJogadasJ1() == 0) && ("J1".equals(p.getEhVez()))) {
                    return -4;
                }
            } else if (p.getJogadasJ2() != 0) {
                if (p.getIdJ2() == idJogador) {
                    int valorDado = p.getDado().valorDado();
                    //    System.out.println("valor dado: " + valorDado);
                    valorDado -= 1;

                    String[] t = p.getTabuleiro();
                    if (valorDado == 5) {
                        p.dencrementaBolasJ2();
                    } else if ("*".equals(t[valorDado])) {
                        t[valorDado] = ("" + (valorDado + 1));
                        p.incrementaBolasJ2();
                    } else {
                        t[valorDado] = "*";
                        p.dencrementaBolasJ2();
                    }
                    p.decrementaJogadasJ2();

                    if (p.getJogadasJ2() == 0) {
                        if (p.getBolasJ2() == 0) {
                            p.setJogadorGanhador(p.getJogador2());
                            p.setJogadorPerdedor(p.getJogador1());
                        }
                        p.trocaVez();
                    }
                    this.partidasl.remove(index);
                    this.partidasl.add(index, p);

                    return valorDado + 1;
                }
            } else if ((p.getIdJ2() == idJogador) && (p.getJogadasJ2() == 0) && ("J2".equals(p.getEhVez()))) {
                return -4;
            }
        } catch (Exception e) {
            return -2;
        }
        return -3;
    }

    private int buscapartida(int idJogador) {
        int i = 0;
        for (Partida partida : this.partidasl) {
            if (idJogador == partida.getIdJ1()) {
                return i;
            }
            if (idJogador == partida.getIdJ1()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private void incrementaCoontadorPreRegistroY() {
        if (this.contadorPreRegistroY == 0) {
            this.contadorPreRegistroY = 1;
        } else if (this.contadorPreRegistroY == 1) {
            this.contadorPreRegistroY = 0;
        }
    }

    private void incrementaCoontadorPreRegistroX() {
        if (this.contadorPreRegistroX < nPartidas) {
            this.contadorPreRegistroX += 1;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private int partidaVazia() {
        int index = 0;
        for (Partida partida : this.partidasl) {
            if (partida.temEspaco() == 0) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                //  System.out.println(this.registro[i][j]);
            }
        }
    }

    public void printpre() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                //  System.out.println(this.preRegistro[i][j]);
            }
        }
    }
}

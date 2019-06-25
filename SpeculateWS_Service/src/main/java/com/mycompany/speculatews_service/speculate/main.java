package com.mycompany.speculatews_service.speculate;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class main {
//
	public static void main(String[] args) {
//
//		// Dado dado = new Dado(5, 11);
//
		Speculate2 a = new Speculate2();
		System.out.println("1 "+a.preRegistro("J1", 1, "J2", 2));
		System.out.println("2 "+a.preRegistro("J3", 3, "J4", 4));
                System.out.println("3 "+a.registraJogador("J1"));
                System.out.println("4 "+a.temPartida(1));
                System.out.println("5 "+a.ehMinhaVez(1));
                System.out.println("6 "+a.obtemOponente(1));
                System.out.println("7 "+a.defineJogadas(1,10));
                System.out.println("8 "+a.registraJogador("J3"));
                System.out.println("9 "+a.temPartida(3));
                System.out.println("10 "+a.ehMinhaVez(3));
                System.out.println("11 "+a.obtemOponente(3));
                System.out.println("12 "+a.registraJogador("J2"));
                System.out.println("13 "+a.temPartida(2));
                System.out.println("14 "+a.ehMinhaVez(2));
                System.out.println("15 "+a.obtemOponente(2));
                
                System.out.println("16 "+a.defineJogadas(2,10));
                System.out.println("17 "+a.registraJogador("J1"));
                
                
              
//
//		a.print();
//
//		System.out.println(a.registraJogador("jean"));
//
//		a.print();
//
//		System.out.println(a.registraJogador("antonio"));
//
//		a.print();
//
//		System.out.println(a.registraJogador("jessica"));
//		System.out.println(a.registraJogador("pricila"));
//		System.out.println(a.registraJogador("pas"));
//
//		a.print();
//		System.out.println();
//		a.printpre();
//		System.out.println();
//		System.out.println();
//
//		// jessica
//		System.out.println("Tem partida>> " + a.temPartida(3));
//
//		System.out.println();
//		System.out.println();
//		// antonio
//		System.out.println(a.temPartida(2));
//
//		System.out.println();
//		System.out.println(">>>>");
//
//		// jessica
//		System.out.println(a.obtemOponente(3));
//
//		System.out.println();
//		System.out.println();
//		// antonio
//		System.out.println(a.obtemOponente(2));
//
//		System.out.println();
//		System.out.println();
//		// pricila
//		System.out.println(a.obtemOponente(6));
//
//		System.out.println(">>\n<<");
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
//
//		System.out.println(a.obtemNumBolas(1));
//		System.out.println(a.obtemNumBolasOponente(2));
//		System.out.println(a.obtemNumBolas(2));
//
//		System.out.println();
//		System.out.println("jogadado\n");
//
//		System.out.println(a.obtemNumBolas(2));
//		System.out.println(a.obtemNumBolasOponente(2));
//		int numJogadas1 = 2;
//		int numJogadas2 = 2;
//		a.defineJogadas(1, numJogadas1);
//		a.defineJogadas(1, numJogadas2);
//
////		System.out.println(a.jogaDado(2));
////		System.out.println(a.jogaDado(2));
////		System.out.println(a.jogaDado(2));
////
////		System.out.println(a.jogaDado(1));
////		System.out.println(a.obtemTabuleiro(1));
////
////		System.out.println();
////		System.out.println("define jogada "+a.defineJogadas(1, a.obtemNumBolas(1)));
////		
//		boolean x = true;
//		System.out.println("minhas bolas " + a.obtemNumBolas(1));
//		int contador = 0;
//		while (a.obtemNumBolas(1) != 0 || a.obtemNumBolas(2) != 0) {
//			System.out.println(a.ehMinhaVez(1));
//		System.out.println(a.ehMinhaVez(2));
//			if (x) {
//				if (numJogadas1 == 0) {
//					if (a.ehMinhaVez(1) != 1) {
//						x = false;
//					}
//					a.defineJogadas(2, a.obtemNumBolas(2));
//					numJogadas2 = a.obtemNumBolas(2);
//
//				}else {
//				System.out.println(a.jogaDado(1));
//				System.out.println(a.obtemTabuleiro(1));
//				
//				numJogadas1--;
//				}
//			} else {
//
//				if (numJogadas2 == 0) {
//					if (a.ehMinhaVez(1) != 1) {
//						x = true;
//					}
//					a.defineJogadas(1, a.obtemNumBolas(1));
//					numJogadas1 = a.obtemNumBolas(1);
//					
//				}
//				else {
//				System.out.println(a.jogaDado(2));
//				System.out.println(a.obtemTabuleiro(1));
//
//				numJogadas2--;
//				}
//				// break;
//			}
//			contador++;
//			if(a.obtemNumBolas(1)==0) {
//				break;
//			}if(a.obtemNumBolas(2)==1) {
//				break;
//			}
//		
//		}
//		
//		
//		System.out.println(a.jogaDado(23421));
//		System.out.println(a.obtemTabuleiro(1));
//		System.out.println(contador);
//		
//		System.out.println(">>>");
//		System.out.println(a.encerraPartida(1));
//		
//		System.out.println(">>>");
//		System.out.println("J1 "+a.ehMinhaVez(1));
//		System.out.println("J2 "+a.ehMinhaVez(2));
////
//		System.out.println(a.obtemNumBolas(1));
//		System.out.println(a.obtemNumBolas(2));
////		System.out.println();
////		System.out.println(a.partidasl.size());
////
////		System.out.println(a.partidasl.get(0).getJogador1().getNome());
////		System.out.println(a.partidasl.get(0).getJogador2().getNome());
////
////		System.out.println();
////		System.out.println(a.partidasl.get(1).getJogador1().getNome());
////		System.out.println(a.partidasl.get(1).getJogador2().getNome());
////
////		System.out.println();
////
////		System.out.println(a.partidasl.get(2).getJogador1().getNome());
////		System.out.println(a.partidasl.get(2).getJogador2().getNome());
//
	}

}

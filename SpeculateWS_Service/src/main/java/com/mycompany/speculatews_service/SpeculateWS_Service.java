/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.speculatews_service;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Jean_Burda
 */
@WebService(serviceName = "SpeculateWS_Service")
public class SpeculateWS_Service {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "preRegistro")
    public int preRegistro(@WebParam(name = "nomeJogador1") String nomeJogador1, @WebParam(name = "nomeJogador2") String nomeJogador2) {
        //TODO write your implementation code here:
        return 0;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registraJogador")
    public int registraJogador(@WebParam(name = "nomeJogador") String nomeJogador) {
        //TODO write your implementation code here:
        return 0;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "encerraPartida")
    public int encerraPartida(@WebParam(name = "idJogador") int idJogador) {
        //TODO write your implementation code here:
        return 0;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "temPartida")
    public String temPartida(@WebParam(name = "idJogador") int idJogador) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtemOponente")
    public String obtemOponente(@WebParam(name = "idJogador") int idJogador) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ehMinhaVez")
    public int ehMinhaVez(@WebParam(name = "idJogador") int idJogador) {
        //TODO write your implementation code here:
        return 0;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtemNumBolas")
    public int obtemNumBolas(@WebParam(name = "idJogador") int idJogador) {
        //TODO write your implementation code here:
        return 0;
    }
      @WebMethod(operationName = "obtemNumBolasOponente")
    public int obtemNumBolasOponente(@WebParam(name = "idJogador") int idJogador) {
        //TODO write your implementation code here:
        return 0;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtemTabuleiro")
    public String obtemTabuleiro(@WebParam(name = "idJogador") int idJogador) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "defineJogadas")
    public int defineJogadas(@WebParam(name = "idJogador") String idJogador) {
        //TODO write your implementation code here:
        return 0;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "jogaDado")
    public int jogaDado(@WebParam(name = "idJogador") int idJogador) {
        //TODO write your implementation code here:
        return 0;
    }

}

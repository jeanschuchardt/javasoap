/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hiws_client;

/**
 *
 * @author Jean_Burda
 */
public class Main {

    public static void main(String[] args) {
        try { // Call Web Service Operation
            org.me.hi.HiWS_Service service = new org.me.hi.HiWS_Service();
            org.me.hi.HiWS port = service.getHiWSPort();
            // TODO initialize WS operation arguments here
            java.lang.String nome = "Jean";
            // TODO process result here
            java.lang.String result = port.sayHi(nome);
            System.out.println("Result = " + result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

}

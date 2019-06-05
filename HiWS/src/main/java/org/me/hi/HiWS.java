/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.hi;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Jean_Burda
 */
@WebService(serviceName = "HiWS")
public class HiWS {

    /**
     * This is a sample web service operation
     * @param txt
     * @return 
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     * @param s
     * @return 
     */
    @WebMethod(operationName = "sayHi")
    public String sayHi(@WebParam(name = "s") String s) {
        //TODO write your implementation code here:
        return "voce digitou "+s;
    }
}

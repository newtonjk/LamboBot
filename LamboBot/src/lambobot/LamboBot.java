/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambobot;

import org.json.simple.parser.ParseException;

/**
 *
 * @author Default7
 */
public class LamboBot {

    /**
     * @param args the command line arguments
     * @throws org.json.simple.parser.ParseException
     */
    public static void main(String[] args) throws ParseException {
    
        NetClient http = new NetClient();
        http.getMarket();
    }
    

}

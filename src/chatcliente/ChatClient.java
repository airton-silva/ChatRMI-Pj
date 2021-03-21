/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatcliente;

import comum.ChatInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import views.WelcomeView;

/**
 *
 * @author Acer
 */
public class ChatClient {
    
        public static void main(String[] args) {
        
        try {        
            Registry registry = LocateRegistry.getRegistry("localhost", 9999);
            ChatInterface chat = (ChatInterface)registry.lookup("chatServer");  //Pegar Referncias Remotas      
            new WelcomeView(chat);  //Passar Parametros de referencia chat para view de boas vindas
            
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    
}

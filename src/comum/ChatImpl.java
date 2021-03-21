/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comum;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Acer
 */
public class ChatImpl extends UnicastRemoteObject implements ChatInterface, Serializable{
    
    List<String> users = new ArrayList<>();
    List<Message> messages = new ArrayList<>();    
    
    public ChatImpl() throws RemoteException {
        super();   
    }
    
     public boolean login(String username) throws RemoteException{
         
        boolean flag = false; //inicializo com false
        
        for (String user : users) {
            if (username.equals(user)) {
                flag = true;
                break;
            } else {
                flag = false;
            }
        }
        if (flag == false) {
            users.add(username);
            Message message = new Message();
            message.setUsername(username);
            message.setMsg(" juntar conversas "); 
            message.setType("juntar"); //join
            message.setDate(new Date());
            messages.add(message);
            
            return true;
        }else{
            return false;
        } 
         
     }
     
    public void logout(String username) throws RemoteException {
        
        users.remove(username);
        Message message = new Message();
        message.setUsername(username);
        message.setMsg(" Saiu da Conversa "); 
        message.setType("sair"); //left
        message.setDate(new Date());
        messages.add(message);
    }
    
    public void sendMessage(Message message) throws RemoteException {
        messages.add(message);
    }

    public List<Message> getAllMessages() throws RemoteException {
        
        for(Message m : messages){
            System.out.println(m.getUsername() + " " + m.getMsg());
        }
        return messages;
    }
    
    public List<String> getAllUsers() throws RemoteException{
        for(String u : users){
            System.out.println(u);
        }
        return users;
    }
    
}

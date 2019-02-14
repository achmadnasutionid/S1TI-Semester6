package printer;


import printer.Printer;
import printer.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Achmad Nasution
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Printer p = new Printer(System.out, 500);
        User user1 = new User(p);
        User user2 = new User(p);
        User user3 = new User(p);
        
        user1.workOn("0123456789");
        user2.workOn("abcdefghij");
        user3.workOn("!@#$%^&*()_+");
        
    }
    
}

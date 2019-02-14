/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printer;

/**
 *
 * @author Achmad Nasution
 */
public class User {
    
    private Printer printer = null;
    
    public User(Printer _printer) {
        printer = _printer;
    }
    
    public void workOn(String _document) {
        (new Thread(new Runnable() {
            @Override
            public void run() {
                printer.print(_document);
            }
        })).start();
    }
    
}

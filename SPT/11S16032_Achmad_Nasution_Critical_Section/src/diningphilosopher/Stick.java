/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diningphilosopher;

/**
 *
 * @author Achmad Nasution
 */
public class Stick {
    
    public static final int USED = 1;
    public static final int UNUSED = 2;
    private int state = UNUSED;
    private Philosopher user = null;
    private final String name;
    
    public Stick(String _name) {
        name = _name;
    }
    
    public String getName() {
        return(name);
    }
    
    public boolean use(Philosopher _philosopher) {
        if(user == null) {
            user = _philosopher;
            state = USED;
            return(true);
        }
        return(false);
    }
    
    public synchronized boolean release(Philosopher _philosopher) {
        if(user != null && user == _philosopher) {
            user = null;
            state = UNUSED;
            return(true);
        }
        return(false);
    }
    
    public boolean isUsed() {
        return(state == USED);
    }
    
    public boolean isAvailable() {
        return(!isUsed());
    }
    
}

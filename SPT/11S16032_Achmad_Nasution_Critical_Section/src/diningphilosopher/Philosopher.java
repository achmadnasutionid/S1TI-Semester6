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
public class Philosopher implements Runnable{
    
    private final String name;
    private Stick left = null;
    private Stick right = null;
    private int cycle = 0;
    
    public Philosopher(String _name) {
        name = _name;
    }
    
    public String getName() {
        return(name);
    }
    
    public void setLeftStick(Stick _stick) {
        left = _stick;
    }
    
    public void setRightStick(Stick _stick) {
        right = _stick;
    }
    
    public void setCycle(int _cycle) {
        cycle = _cycle;
    }
    
    public void pickUpSticks() {
        long sleepTime = 100;
        while(!left.use(this) || !right.use(this)) {
            say("missed the chopsticks");
            dropSticks();
            goSleeping(sleepTime);
            sleepTime *= 2;
        }
    }
    
    private void dropSticks() {
        left.release(this);
        right.release(this);
    }
    
    private void eat() {
        pickUpSticks();
        say("eating");
        goSleeping(1000);
        dropSticks();
    }
    
    private void think(){
        say("thinking");
        goSleeping(2000);
    }
    
    private void goSleeping(long _millis) {
        try {
            Thread.sleep(_millis);
        }
        catch(InterruptedException ie) {
            ie.printStackTrace();
        }
    }
    
    public void say(String _message) {
        System.out.println(name + ":" + _message);
    }
    
    @Override
    public void run() {
        for(int counter = 0; counter < cycle; ++counter) {
            eat();
            think();
        }
    }
    
}

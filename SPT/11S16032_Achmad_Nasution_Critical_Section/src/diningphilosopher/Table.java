/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diningphilosopher;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Achmad Nasution
 */
public class Table {
    
    private final List<Philosopher> philosophers;
    private final List<Stick> sticks;
    private final List<Thread> threads;
    
    public Table(int _numberOfSeat) {
        philosophers = new ArrayList<>();
        sticks = new ArrayList<>();
        threads = new ArrayList<>();
        
        for(int counter = 0; counter < _numberOfSeat; ++counter) {
            Philosopher philosopher = new Philosopher("P" + counter);
            philosopher.setCycle(5);
            philosophers.add(philosopher);
            threads.add(new Thread(philosopher));
            
            sticks.add(new Stick("S" + counter));
        }
        
        for(int counter = 0; counter < _numberOfSeat; ++counter) {
            philosophers.get(counter).setRightStick(sticks.get(counter));
            philosophers.get(counter).setLeftStick(sticks.get((counter + 1) % _numberOfSeat));
        }
    }
    
    public void startDining() {
        int numberOfSeat = philosophers.size();
        System.out.println("size:" + numberOfSeat);
        for(int counter = 0; counter < numberOfSeat; ++counter) {
            threads.get(counter).start();
        }
        
        try {
            for(int counter = 0; counter < numberOfSeat; ++counter) {
                threads.get(counter).join();
            }
        }
        catch(InterruptedException ie) {
            ie.printStackTrace();
        }
    }
    
}

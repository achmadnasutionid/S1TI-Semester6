/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cookieshop;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Achmad Nasution
 */
public class CookieShop {
    
    private final List<Actor> actors;
    private final List<Thread> threads;
    private final CookieJar jar;
    
    public CookieShop(int _numberOfProducer, int _numberOfConsumer, int _jarCapacity) {
        int numberOfActors = _numberOfProducer + _numberOfConsumer;
        actors = new ArrayList<>();
        threads = new ArrayList<>();
        jar = new CookieJar(_jarCapacity);
        for(int counter = 0; counter < _numberOfProducer; ++counter) {
            Actor actor = new Producer(("P" + counter), jar, (100 * (counter + 1)));
            actor.setCycle(_jarCapacity);
            actors.add(actor);
            threads.add(new Thread(actor));
        }
        
        for(int counter = 0; counter < _numberOfConsumer; ++counter) {
            Actor actor = new Consumer(("C" + counter), jar, (100 * (counter + 2)));
            actor.setCycle((_jarCapacity * _numberOfProducer) / _numberOfConsumer);
            actors.add(actor);
            threads.add(new Thread(actor));
        }
    }
    
    public void startInteracting() {
        int numberOfThread = threads.size();
        for(int counter = 0; counter < numberOfThread; ++counter) {
            threads.get(counter).start();
        }
        try {
            for(int counter = 0; counter < numberOfThread; ++counter) {
                threads.get(counter).join();
            }
        }
        catch(InterruptedException ie) {
            ie.printStackTrace();
        }
    }
    
}

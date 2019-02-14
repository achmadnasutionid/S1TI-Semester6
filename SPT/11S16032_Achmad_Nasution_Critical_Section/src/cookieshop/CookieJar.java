/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cookieshop;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Achmad Nasution
 */
public class CookieJar {
    
    public static final int DEFAULT_CAPACITY = 10;
    private Queue<Cookie> cookies = null;
    private int capacity = 0;
    
    public CookieJar(int _capacity) {
        if(_capacity > 0) {
            capacity = _capacity;
        }
        else {
            capacity = DEFAULT_CAPACITY;
        }
        cookies = new LinkedList<Cookie>();
    }
    
    public boolean isEmpty() {
        return(cookies.isEmpty());
    }
    
    public boolean isFull() {
        return(cookies.size() == capacity);
    }
    
    public synchronized void put(Cookie _cookie) {
        while(isFull()) {
            try {
                _cookie.getProducer().say("the jar is full");
                wait();
            }
            catch(InterruptedException ie) {
                ie.printStackTrace();
            }
            _cookie.getProducer().say("notified.");
        }
        _cookie.getProducer().say("adding (" + _cookie.getSeq() + ")");
        cookies.offer(_cookie);
        notifyAll();
    }
    
    public synchronized Cookie take(Consumer _consumer) {
        while(isEmpty()) {
            try {
                _consumer.say("the jar is empty");
                wait();
            }
            catch(InterruptedException ie) {
                ie.printStackTrace();
            }
            _consumer.say("notified.");
        }
        Cookie cookie = cookies.poll();
        cookie.consumedBy(_consumer);
        _consumer.say("taking (" + cookie.getSeq() + ")");
        notifyAll();
        return(cookie);
    }
    
}

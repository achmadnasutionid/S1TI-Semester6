/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cookieshop;

/**
 *
 * @author Achmad Nasution
 */
public class Producer extends Actor{

    public Producer(String _name, CookieJar _jar, long _delay) {
        super(_name, _jar, _delay);
    }

    @Override
    public void work() {
        Cookie cookie = new Cookie(this);
        jar.put(cookie);
    }
    
}

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
public class Consumer extends Actor{

    public Consumer(String _name, CookieJar _jar, long _delay) {
        super(_name, _jar, _delay);
    }

    @Override
    public void work() {
        Cookie cookie = jar.take(this);
        cookie.consumedBy(this);
    }
      
}

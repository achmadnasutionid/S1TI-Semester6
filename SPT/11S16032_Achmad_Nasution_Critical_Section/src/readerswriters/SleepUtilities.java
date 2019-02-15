/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readerswriters;

/**
 *
 * @author Achmad Nasution
 */
public class SleepUtilities extends Thread{
    
    private static final int NAP_TIME = 5;
    
    public static void nap() {
        nap(NAP_TIME);
    }
    
    public static void nap(int duration) {
        int sleeptime = (int) (NAP_TIME * Math.random());
        try {
            Thread.sleep(sleeptime * 1000);
        }
        catch(InterruptedException e) {
            
        }
    }
    
}

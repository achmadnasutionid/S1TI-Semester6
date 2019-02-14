/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanpakonkurensi;

/**
 *
 * @author Achmad Nasution
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Stopwatch stopwatch = new Stopwatch();

        long elapsedTime;
        long min = 0L;
        long max = 1000L;

        //Data PrimeCounter tanpa konkurensi
        //max dengan 1000L selesai dengan 0 sec
        //max dengan 10000L selesai dengan 0 sec
        //max dengan 100000L selesai dengan 4 sec
        //max dengan 1000000L selesai dengan 341 sec
        
        PrimeCounter pc = new PrimeCounter(min, max);

        stopwatch.record();
        pc.count();
        elapsedTime = stopwatch.capture();
        System.out.printf("finished in %d sec(s)\n", elapsedTime);
        
    }
    
}

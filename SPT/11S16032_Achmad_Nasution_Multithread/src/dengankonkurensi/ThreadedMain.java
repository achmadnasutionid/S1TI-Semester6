/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dengankonkurensi;

import tanpakonkurensi.Stopwatch;

/**
 *
 * @author Achmad Nasution
 */
public class ThreadedMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Stopwatch stopwatch = new Stopwatch();
        
        long elapsedTime;
        long min = 0L;
        long max = 1000000L;
        int numWorker = 4;
        
        //Data PrimeCounter dengan konkuransi
        //max dengan 1000L selesai dengan 0 sec
        //max dengan 10000L selesai dengan 0 sec
        //max dengan 100000L selesai dengan 4 sec
        //max dengan 1000000L selesai dengan 326 sec
        
        
        PrimeCounterManager pcm = new PrimeCounterManager(min, max, numWorker);
        
        stopwatch.record();
        pcm.count();
        elapsedTime = stopwatch.capture();
        System.out.printf("finished in %d sec(s)\n", elapsedTime);
    }
    
}

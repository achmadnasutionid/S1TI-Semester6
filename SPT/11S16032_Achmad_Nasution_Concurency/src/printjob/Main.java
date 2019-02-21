/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printjob;

/**
 *
 * @author Achmad Nasution
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PrintQueue printQueue = new PrintQueue();
        Thread[] threads = new Thread[12];
        for(int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Job(printQueue), "Thread" + i);
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
    
}

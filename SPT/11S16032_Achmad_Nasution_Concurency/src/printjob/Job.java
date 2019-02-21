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
public class Job implements Runnable{
    private PrintQueue printQueue;
    
    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }
    
    @Override
    public void run() {
        System.out.printf("%s: Goind to print a job\n", Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s: The doucment has been printed\n", Thread.currentThread().getName());
    }
    
}

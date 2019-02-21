/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printjob;

import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Achmad Nasution
 */
public class PrintQueue {
    private final Semaphore semaphore;
    private final boolean freePrinters[];
    private final Lock lockPrinters;
    
    public PrintQueue() {
        semaphore = new Semaphore(3);
        freePrinters = new boolean[3];
        for(int i = 0; i < 3; i++) {
            freePrinters[i] = true;
        }
        lockPrinters = new ReentrantLock();
    }
    
    public void printJob(Object document) {
        try {
            semaphore.acquire();
            int assignedPrinter = getPrinter();
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s - %s: PrintQueue: Printing a Job in Printer %d during %d seconds\n", new Date(), Thread.currentThread().getName(), assignedPrinter, duration);
            TimeUnit.SECONDS.sleep(duration);
            freePrinters[assignedPrinter] = true;
        }
        catch(InterruptedException e) {
            
        }
        finally {
            semaphore.release();
        }
    }
    
    private int getPrinter() {
        int ret = -1;
        try {
            lockPrinters.lock();
            for(int i = 0; i < freePrinters.length; i++) {
                if(freePrinters[i]) {
                    ret = i;
                    freePrinters[i] = false;
                    break;
                }
            }
        }
        catch (Exception e) {
            
        }
        finally {
            lockPrinters.unlock();
        }
        return ret;
    }
}

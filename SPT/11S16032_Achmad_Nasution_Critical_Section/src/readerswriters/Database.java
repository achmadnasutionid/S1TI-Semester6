/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readerswriters;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Achmad Nasution
 */
public class Database implements RWLock{
   
    private int readerCount;
    private Semaphore mutex;
    private Semaphore db;
    
    public Database() {
        this.readerCount = 0;
        this.mutex = new Semaphore(1);
        this.db = new Semaphore(1);
    }
    
    public void acquireReadLock(int readerNum) {
        try{
            mutex.acquire();
        }
        catch(InterruptedException e) {
            
        }
        ++readerCount;
        if(readerCount == 1) {
            try{
                db.acquire();
            }
            catch(InterruptedException e) {
                
            }
        }
        System.out.println("Reader " + readerNum + " is reading. Reader count = " + readerCount);
        mutex.release();
    }
    
    public void releaseReadLock(int readerNum) {
        try {
            mutex.acquire();
        }
        catch(InterruptedException e) {
            
        }
        --readerCount;
        if(readerCount == 0) {
            db.release();
        }
        System.out.println("Reader " + readerNum + " is done reading. Reader count = " + readerCount);
        mutex.release();
    }
    
    public void acquireWriteLock(int writerNum) {
        try {
            db.acquire();
        }
        catch(InterruptedException e) {
            
        }
        System.out.println("Writer " + writerNum + " is writing.");
    }
    
    @Override
    public void releaseWriteLock(int writerNum) {
        System.out.println("Writer " + writerNum + " is done writing.");
        db.release();
    }
    
}

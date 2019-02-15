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
public class Writer implements Runnable{

    private RWLock database;
    private int writerNum;
    
    public Writer(int w, RWLock d) {
        writerNum = w;
        database = d;
    }
    
    public void run() {
        while(true) {
            SleepUtilities.nap();
            System.out.println("writer " + writerNum + " wants to write.");
            database.acquireWriteLock(writerNum);
            SleepUtilities.nap();
            database.releaseWriteLock(writerNum);
        }
    }
    
}

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
public class Reader implements Runnable{

    private RWLock database;
    private int readerNum;
    
    public Reader(int readerNum, RWLock database) {
        this.readerNum = readerNum;
        this.database = database;
    }
    
    @Override
    public void run() {
        while(true) {
            SleepUtilities.nap();
            System.out.println("reader " + readerNum + " wants to read.");
            database.acquireReadLock(readerNum);
            SleepUtilities.nap();
            database.releaseReadLock(readerNum);
        }
    }
    
    
    
}

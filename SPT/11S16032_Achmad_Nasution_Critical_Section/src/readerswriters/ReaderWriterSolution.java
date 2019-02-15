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
public class ReaderWriterSolution {

    /**
     * @param args the command line arguments
     */
    
    public static final int NUM_OF_READERS = 3;
    public static final int NUM_OF_WRITERS = 2;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        RWLock database = new Database();
        
        Thread[] readerArray = new Thread[NUM_OF_READERS];
        Thread[] writerArray = new Thread[NUM_OF_WRITERS];
        
        for(int i = 0; i < NUM_OF_READERS; i++) {
            readerArray[i] = new Thread(new Reader(i, database));
            readerArray[i].start();
        }
        
        for(int i = 0; i < NUM_OF_WRITERS; i++) {
            writerArray[i] = new Thread(new Writer(i, database));
            writerArray[i].start();
        }
        
    }
    
}

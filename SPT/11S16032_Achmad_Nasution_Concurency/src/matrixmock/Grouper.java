/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixmock;

/**
 *
 * @author Achmad Nasution
 */
public class Grouper implements Runnable{

    private final Results results;
    
    public Grouper(Results results) {
        this.results = results;
    }
            
    @Override
    public void run() {
        int finalResult = 0;
        System.out.printf("Grouper: Processing results...\n");
        int data[] = results.getData();
        for(int number : data) {
            finalResult += number;
        }
        System.out.printf("Grouper: Total result: %d.\n", finalResult);
    }
    
}

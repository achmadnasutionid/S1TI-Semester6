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
public class Results {
    
    private final int data[];
    
    public Results(int size) {
        data = new int[size];
    }
    
    public void setData(int position, int value) {
        data[position] = value;
    }
    
    public int[] getData() {
        return data;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanpakonkurensi;

/**
 *
 * @author Achmad Nasution
 */
public class PrimeCounter {
    
    private long min = 0L;
    private long max = 0L;
    protected long current = 0L;

    public PrimeCounter(long _min, long _max) {
        min = (_min > 0) ? _min : 1L;
        max = _max;
        current = min;
    }

    public void count() {
        long counter = 0L;
        while(current <= max) {
            if(isPrime(current)) {
                counter++;
            }
            current++;
        }
        System.out.printf("%d primes were found between %d to %d\n", counter, min, max);
    }

    private boolean isPrime(long _num) {
        if(_num < 2) {
            return false;
        }
        for(long i = 2; i < _num; i++) {
            if((_num % i) == 0) {
                return false;
            }
        }
        return true;
    }
    
}

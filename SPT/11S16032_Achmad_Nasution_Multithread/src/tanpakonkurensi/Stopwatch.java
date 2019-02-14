/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanpakonkurensi;

import java.util.Calendar;

/**
 *
 * @author Achmad Nasution
 */
public class Stopwatch {
    
    private long record;

    public long getTime() {
        return (Calendar.getInstance().getTimeInMillis());
    }

    public void record() {
        record = getTime();
    }

    public long capture() {
        return ((getTime() - record) / 1000L);
    }
    
}

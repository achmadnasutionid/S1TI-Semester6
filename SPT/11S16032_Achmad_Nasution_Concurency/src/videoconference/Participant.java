/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoconference;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Achmad Nasution
 */
public class Participant implements Runnable{

    private final VideoConference conference;
    private final String name;
    
    public Participant(VideoConference conference, String name) {
        this.conference = conference;
        this.name = name;
    }
    
    @Override
    public void run() {
        long duration = (long) (Math.random() * 10);
         try {
             TimeUnit.SECONDS.sleep(duration);
         }
         catch(InterruptedException e) {
             
         }
         conference.arrive(name);
    }
    
    
}

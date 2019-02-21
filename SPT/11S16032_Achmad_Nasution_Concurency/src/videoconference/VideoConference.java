/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoconference;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author Achmad Nasution
 */
public class VideoConference implements Runnable{
    private final CountDownLatch controller;
    
    public VideoConference(int number){
        controller = new CountDownLatch(number);
    }
    
    public void arrive(String name) {
        System.out.printf("%s has arrived.\n", name);
        controller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants.\n", controller.getCount());
    }
    
    @Override
    public void run() {
        System.out.printf("VideoConference: Initialization: %d participants.\n", controller.getCount());
        try {
            controller.await();
            System.out.printf("VideoConference: All the participants have come\n");
            System.out.printf("VideoConference: Let's start...\n");
        }
        catch(InterruptedException e) {
            
        }
    }
    
}

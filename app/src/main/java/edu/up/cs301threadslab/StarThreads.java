package edu.up.cs301threadslab;


import java.util.Random;

/**
 * StarThreads
 *
 * Thread that automatically adds or removes
 * a star from a given StarAnimation object
 * every 40 ms
 *
 */
public class StarThreads {

    public void run(StarAnimation starAnim){
        Random rand = new Random();
        while(true){


            try{
                if (rand.nextBoolean()){
                    starAnim.addStar(); //add star
                }
                else if(rand.nextBoolean()){
                    starAnim.removeStar(); //remove star
                }
                Thread.sleep(40);
            }
            catch (InterruptedException e){
                // interrupted
            }
        }
    }

}

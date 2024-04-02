package edu.up.cs301threadslab;


import java.util.Random;

/**
 * StarThreads
 * <p>
 * Thread that automatically adds or removes
 * a star from a given StarAnimation object
 * every 40 ms
 */
public class StarThreads implements Runnable {
    StarAnimation sa;

    public StarThreads(StarAnimation starAnim) {
        sa = starAnim;
    }

    Random rand = new Random();
    @Override
    public void run() {
        while (true) {

                if (rand.nextBoolean()) {
                    sa.addStar(); //add star
                } else if (rand.nextBoolean()) {
                    sa.removeStar(); //remove star
                }

                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    // interrupted
                }
            }
        }
    }

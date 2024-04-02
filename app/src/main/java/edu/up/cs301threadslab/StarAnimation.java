package edu.up.cs301threadslab;

import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;

import java.util.Vector;
import java.util.Random;

/**
 * StarAnimation
 *
 * displays a star field animation
 */
public class StarAnimation extends Animation {

    /* the field of stars */
    public static final int INIT_STAR_COUNT = 100;
    private Vector<Star> field = new Vector<Star>();

    /* when this is set to 'false' the next animation frame won't twinkle */
    private boolean twinkle = true;

    /** ctor expects to be told the size of the animation canvas */
    public StarAnimation(int initWidth, int initHeight) {
        super(initWidth, initHeight);
    }

    /** whenever the canvas size changes, generate new stars */
    @Override
    public void setSize(int newWidth, int newHeight) {
        super.setSize(newWidth, newHeight);

        //Create the stars
        field = new Vector<Star>();
        for(int i = 0; i < INIT_STAR_COUNT; ++i) {
            addStar();
        }
    }

    /** adds a randomly located star to the field */
    public void addStar() {
        //Ignore this call if the canvas hasn't been initialized yet
        if ((width <= 0) || (height <= 0)) return;

        int x = rand.nextInt(width);
        int y = rand.nextInt(height);


        field.add(new Star(x, y));
    }//addStar

    /** removes a random star from the field */
    public void removeStar() {
        if (field.size() > 100) {
            int index = rand.nextInt(field.size());
            field.remove(index);
        }
    }//removeStar

    /** draws the next frame of the animation */
    @Override
    public void draw(Canvas canvas) {
        for (Star s : field) {
            s.draw(canvas);
            if (this.twinkle) {
                s.twinkle();
            }
        }

        this.twinkle = true;
    }//draw

    /** the seekbar progress specifies the amount of stars. */
    public int oldProg;
    @Override
    public void progressChange(int newProgress) {

        // if new prog greater than old prog, add stars
        if ( newProgress > oldProg){
            for (int i=0; i < newProgress-oldProg; i++) {
                for (int j = 0; j < 10; j++) {
                    addStar();
                }
            }
        }

        // if new prog less than old prog, remove stars
        else if (newProgress < oldProg){
            for (int i=0; i < oldProg - newProgress; i++) {
                for (int j = 0; j < 10; j++) {
                    removeStar();
                }
            }
        }

        this.twinkle = false;

        //make current progress the old progress
        oldProg = newProgress;

        /* og code to change brightness
        int brightness = 255 - (newProgress * 2);
        Star.starPaint.setColor(Color.rgb(brightness, brightness, brightness));
        this.twinkle = false;
        */

    }
}//class StarAnimation

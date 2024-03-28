package edu.up.cs301threadslab;

public class ThreadedAnimationView extends Thread{

    AnimationView av;

    public ThreadedAnimationView(AnimationView aniView){
        aniView = av;

    }

    @Override
    public void run(){
        while(true){
            av.postInvalidate();
            try{
                Thread.sleep(3000);
            }
            catch (InterruptedException e){
                //interrupted
            }
        }

    }
}

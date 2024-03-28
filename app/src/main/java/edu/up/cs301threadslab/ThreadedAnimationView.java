package edu.up.cs301threadslab;

public class ThreadedAnimationView extends Thread{

    AnimationView av;

    public ThreadedAnimationView(){
        av = new AnimationView(av.getContext());
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

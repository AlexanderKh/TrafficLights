package alex.timer;

import alex.Intersection;

public class GreenTimer extends Thread {
    public static final int DELAY = 5;

    private Intersection intersection;
    private int left;

    public GreenTimer(Intersection intersection){
        this.intersection = intersection;
        left = DELAY;
    }


    @Override
    public void run(){
        while (left > 0 && !isInterrupted()){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                left = 0;
            }
            left--;
        }
        intersection.endCycle();
    }
}

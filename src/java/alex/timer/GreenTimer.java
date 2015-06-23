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
                System.out.println("GREEN Timer INTERRUPTED");
                left = 0;
                return;
            }
            left--;
        }
        intersection.endCycle();
    }
}

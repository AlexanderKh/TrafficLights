package alex.timer;

import alex.Intersection;

public class RedTimer extends Thread {
    public static final int DELAY = 3;

    private Intersection intersection;
    private int left;

    public RedTimer(Intersection intersection){
        this.intersection = intersection;
        left = DELAY;
    }


    @Override
    public void run(){
        while (left > 0 && !isInterrupted()){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("RED Timer INTERRUPTED");
                return;
            }
            left--;
        }
        intersection.startGreenTimer();
    }
}

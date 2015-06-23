package alex.timer;

import alex.Intersection;

public class YellowTimer extends Thread {
    public static final int DELAY = 7;
    public static final int DELAY_DECREASEMENT = 5;

    private Intersection intersection;
    private int left;

    public YellowTimer(Intersection intersection){
        this.intersection = intersection;
        left = DELAY;
    }

    public void dec(){
        left -= DELAY_DECREASEMENT;
        if (left <= 0)
            intersection.startRedTimer();
    }

    @Override
    public void run(){
        while (left > 0 && !isInterrupted()){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("YELLOW Timer INTERRUPTED");
                left = 0;
                return;
            }
            left--;
        }
        intersection.startRedTimer();
    }
}

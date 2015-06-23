package alex;

import alex.lights.BigLight;
import alex.lights.SmallLight;
import alex.timer.GreenTimer;
import alex.timer.RedTimer;
import alex.timer.YellowTimer;

public class Intersection{
    private BigLight bigLight;
    private SmallLight smallLight;
    private boolean lButtonPushed;
    private boolean rButtonPushed;
    private YellowTimer yellowTimer;
    private GreenTimer greenTimer;
    private RedTimer redTimer;


    Intersection(){
        bigLight = new BigLight();
        smallLight = new SmallLight();
        lButtonPushed = false;
        rButtonPushed = false;
    }

    public void lButtonPush(){
        if (!rButtonPushed){
            startYellowTimer();
        } else if (yellowTimer != null) {
            yellowTimer.dec();
        }
        lButtonPushed = true;
    }

    public void rButtonPush(){
        if (!lButtonPushed){
            startYellowTimer();
        } else if (yellowTimer != null) {
            yellowTimer.dec();
        }
        rButtonPushed = true;
    }

    public void endCycle(){
        greenTimer = null;
        System.out.println("Cycle ended");
        updateLights();
        lButtonPushed = false;
        rButtonPushed = false;
    }

    public void startYellowTimer() {
        yellowTimer = new YellowTimer(this);
        yellowTimer.start();
        System.out.println("Started YELLOW timer");
        updateLights();
    }

    public void startRedTimer(){
        yellowTimer = null;
        redTimer = new RedTimer(this);
        redTimer.start();
        System.out.println("Started RED timer");
        updateLights();
    }

    public void startGreenTimer(){
        redTimer = null;
        greenTimer = new GreenTimer(this);
        greenTimer.start();
        System.out.println("Started GREEN timer");
        updateLights();
    }

    private void updateLights(){
        if (yellowTimer != null){
            bigLight.toggleGreen();
            smallLight.toggleRed();
        } else if (redTimer != null){
            bigLight.toggleYellow();
            smallLight.toggleRed();
        } else if (greenTimer != null){
            bigLight.toggleRed();
            smallLight.toggleGreen();
        } else {
            bigLight.toggleGreen();
            smallLight.toggleRed();
        }
    }

    public void stopRunning(){
        if (yellowTimer != null){
            yellowTimer.interrupt();
            yellowTimer = null;
        }
        if (greenTimer != null) {
            greenTimer.interrupt();
            greenTimer = null;
        }
        if (redTimer != null) {
            redTimer.interrupt();
            redTimer = null;
        }
    }

    public SmallLight getSmallLight() {
        return smallLight;
    }

    public BigLight getBigLight() {
        return bigLight;
    }
}

package alex;

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
        if (rButtonPushed == false){
            startYellowTimer();
        } else {
            yellowTimer.dec();
        }
    }

    public void rButtonPush(){
        if (lButtonPushed == false){
            startYellowTimer();
        } else {
            yellowTimer.dec();
        }
    }

    public void endCycle(){
        greenTimer.interrupt();
        greenTimer = null;
        updateLights();
    }

    public void startYellowTimer() {
        yellowTimer = new YellowTimer(this);
        yellowTimer.start();
        updateLights();
    }

    public void startRedTimer(){
        yellowTimer.interrupt();
        yellowTimer = null;
        redTimer = new RedTimer(this);
        redTimer.start();
        updateLights();
    }

    public void startGreenTimer(){
        redTimer.interrupt();
        redTimer = null;
        greenTimer = new GreenTimer(this);
        greenTimer.start();
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

    public SmallLight getSmallLight() {
        return smallLight;
    }

    public BigLight getBigLight() {
        return bigLight;
    }
}

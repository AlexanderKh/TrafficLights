package alex;

public class BigLight {
    private LightColor lightColor;

    public BigLight(){
        lightColor = LightColor.GREEN;
    }

    public void toggleYellow(){
        lightColor = LightColor.YELLOW;
    }

    public void toggleGreen(){
        lightColor = LightColor.GREEN;
    }

    public void toggleRed(){
        lightColor = LightColor.RED;
    }

    public LightColor getLightColor() {
        return lightColor;
    }
}


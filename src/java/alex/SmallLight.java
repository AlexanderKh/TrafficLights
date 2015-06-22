package alex;

public class SmallLight {
    private LightColor lightColor;

    public SmallLight(){
        lightColor = LightColor.RED;
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

package alex.lights;

public class BigLight {
    private LightColor lightColor;

    public BigLight(){
        lightColor = LightColor.GREEN;
    }

    public void toggleYellow(){
//        System.out.println("Big light color set to YELLOW");
        lightColor = LightColor.YELLOW;
    }

    public void toggleGreen(){
//        System.out.println("Big light color set to GREEN");
        lightColor = LightColor.GREEN;
    }

    public void toggleRed(){
//        System.out.println("Big light color set to RED");
        lightColor = LightColor.RED;
    }

    public LightColor getLightColor() {
//        System.out.println("Big Light returned color");
        return lightColor;
    }
}


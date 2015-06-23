package alex.lights;

public class SmallLight {
    private LightColor lightColor;

    public SmallLight(){
        lightColor = LightColor.RED;
    }

    public void toggleGreen(){
//        System.out.println("Small light color set to GREEN");
        lightColor = LightColor.GREEN;
    }

    public void toggleRed(){
//        System.out.println("Small light color set to RED");
        lightColor = LightColor.RED;
    }

    public LightColor getLightColor() {
//        System.out.println("Small Light returned color");
        return lightColor;
    }
}

package alex;

import alex.lights.BigLight;
import alex.lights.LightColor;
import alex.lights.SmallLight;

import javax.swing.*;
import java.awt.*;

public class Representation extends JPanel {
    BigLight bigLight;
    SmallLight smallLight;
    int panelHeight = 400;
    int panelWidth = 500;

    Representation(BigLight bigLight, SmallLight smallLight){
        super();
        this.bigLight = bigLight;
        this.smallLight = smallLight;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawRect(1, 1, panelWidth - 1, panelHeight - 1);
        g.drawRect(300, 150, 150, 50);
        g.drawRect(300, 250, 100, 50);
        if (bigLight.getLightColor() == LightColor.RED){
            g.setColor(Color.RED);
            g.fillOval(305, 155, 40, 40);
        }
        if (bigLight.getLightColor() == LightColor.YELLOW) {
            g.setColor(Color.YELLOW);
            g.fillOval(355, 155, 40, 40);
        }
        if (bigLight.getLightColor() == LightColor.GREEN){
            g.setColor(Color.GREEN);
            g.fillOval(405, 155, 40, 40);
        }
        if (smallLight.getLightColor() == LightColor.RED){
            g.setColor(Color.RED);
            g.fillOval(305, 255, 40, 40);
        }
        if (smallLight.getLightColor() == LightColor.GREEN){
            g.setColor(Color.GREEN);
            g.fillOval(355, 255, 40, 40);
        }
        g.setColor(Color.BLACK);
        g.drawOval(305, 155, 40, 40);
        g.drawOval(355, 155, 40, 40);
        g.drawOval(405, 155, 40, 40);
        g.drawOval(305, 255, 40, 40);
        g.drawOval(355, 255, 40, 40);
    }
}

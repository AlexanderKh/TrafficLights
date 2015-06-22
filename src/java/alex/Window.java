package alex;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private Intersection intersection;
    private Representation representation;
    private JButton lButton;
    private JButton rButton;

    private class lButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            intersection.lButtonPush();
        }
    }

    private class rButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            intersection.rButtonPush();
        }
    }

    Window(){
        super("Traffic Lights");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);
        intersection = new Intersection();
        representation = new Representation(intersection.getBigLight(),
                                            intersection.getSmallLight());
        representation.setBounds(0, 0, 500, 400);
        this.add(representation);
        lButton = new JButton("Left");
        lButton.addActionListener(new lButtonListener());
        lButton.setBounds(10, 410, 200, 80);
        this.add(lButton);
        rButton = new JButton("Right");
        rButton.addActionListener(new rButtonListener());
        rButton.setBounds(260, 410, 200, 80);
        this.add(rButton);
        this.setVisible(true);
    }
}

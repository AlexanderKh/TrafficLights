package alex;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private Intersection intersection;
    private Representation representation;
    RepaintClass repaintThread;
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

    private class RepaintClass extends Thread{
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                representation.repaint();
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Repaint Cycle INTERRUPTED");
                }
            }
        }
    }

    private class StopeListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            repaintThread.interrupt();
            intersection.stopRunning();
            System.exit(0);
        }
    }

    Window(){
        super("Traffic Lights");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setResizable(false);
        this.setLayout(null);
        intersection = new Intersection();
        representation = new Representation(intersection.getBigLight(),
                                            intersection.getSmallLight());
        representation.setBounds(0, 0, 500, 400);
        this.add(representation);
        lButton = new JButton("Left");
        lButton.addActionListener(new lButtonListener());
        lButton.setBounds(10, 410, 130, 60);
        this.add(lButton);
        rButton = new JButton("Right");
        rButton.addActionListener(new rButtonListener());
        rButton.setBounds(160, 410, 130, 60);
        this.add(rButton);
        repaintThread = new RepaintClass();
        JButton stope = new JButton("STOPE");
        stope.addActionListener(new StopeListener());
        stope.setBounds(310, 410, 130, 60);
        this.add(stope);
        this.setVisible(true);
        repaintThread.start();
    }
}

package leo.main;

import javax.swing.*;

public class Main {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public static void main(String [] args) {
        System.out.println("Hello Leo!!!");

        JFrame frame = new JFrame("Perspective");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);

        frame.add(new MainPanel());

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}

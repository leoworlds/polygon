package leo.main;

import org.json.JSONException;

import javax.swing.*;
import java.io.IOException;

public class Main {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public static void main(String [] args) throws IOException, JSONException {
        JFrame frame = new JFrame("Perspective");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);

        frame.add(new MainPanel(Conservator.read()));

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}

package leo.main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics gg) {
        Graphics2D g = (Graphics2D)gg;

        Screen.setSize(getWidth(), getHeight());

        g.setBackground(Color.decode("#2b2b2b"));
        g.clearRect(0, 0, getWidth(), getHeight());

        List<Polygon> polygons = new ArrayList<>();

        polygons.add(new Polygon(Color.RED,
                new Point(-200, -200, 200),
                new Point(200, -200, 200),
                new Point(200, -200, 1000),
                new Point(-200, -200, 1000)));

        polygons.add(new Polygon(Color.RED,
                new Point(-200, 200, 200),
                new Point(200, 200, 200),
                new Point(200, 200, 1000),
                new Point(-200, 200, 1000)));

        polygons.forEach(polygon -> draw(g, polygon));
    }

    private void draw(Graphics2D g, Polygon polygon) {

        g.setColor(polygon.getColor());

        List<Point> points = Screen.convert(Perspective.convert(polygon)).getPoints();

        for (int i = 0; i < points.size(); i++) {
            Point e1 = points.get(i);
            Point e2 = (i + 1) >= points.size() ? points.get(0) : points.get(i + 1);

            g.drawLine(e1.getX(), e1.getY(), e2.getX(), e2.getY());
        }
    }
}

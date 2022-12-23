package leo.main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static leo.main.Perspective.convert;

public class MainPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics gg) {
        Graphics2D g = (Graphics2D)gg;

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

        List<Point> points = polygon.getPoints();

        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = (i + 1) >= points.size() ? points.get(0) : points.get(i + 1);

            Point e1 = convert(p1);
            Point e2 = convert(p2);

            g.drawLine(
                    (e1.getX() + getWidth())/2,(e1.getY() + getHeight())/2,
                    (e2.getX() + getWidth())/2, (e2.getY() + getHeight())/2);
        }
    }
}

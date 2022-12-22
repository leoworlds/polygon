package leo.main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static leo.main.Perspective.persp;

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

            int x1 = persp(p1.getX(), p1.getZ());
            int y1 = persp(p1.getY(), p1.getZ());
            int x2 = persp(p2.getX(), p2.getZ());
            int y2 = persp(p2.getY(), p2.getZ());

            g.drawLine(
                    (x1 + getWidth())/2,(y1 + getHeight())/2,
                    (x2 + getWidth())/2, (y2 + getHeight())/2);
        }
    }
}

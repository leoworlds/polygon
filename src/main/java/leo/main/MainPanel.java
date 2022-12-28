package leo.main;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainPanel extends JPanel {

    private final Shape shape;

    public MainPanel(Shape shape) {
        this.shape = shape;
    }

    @Override
    protected void paintComponent(Graphics gg) {
        Graphics2D g = (Graphics2D)gg;

        Screen.setSize(getWidth(), getHeight());

        g.setBackground(Color.decode("#2b2b2b"));
        g.clearRect(0, 0, getWidth(), getHeight());

//        List<Polygon> polygons = new ArrayList<>();
//
//        polygons.add(new Polygon(Color.RED,
//                new Vertex(-200, -200, 200),
//                new Vertex(200, -200, 200),
//                new Vertex(200, -200, 1000),
//                new Vertex(-200, -200, 1000)));
//
//        polygons.add(new Polygon(Color.RED,
//                new Vertex(-200, 200, 200),
//                new Vertex(200, 200, 200),
//                new Vertex(200, 200, 1000),
//                new Vertex(-200, 200, 1000)));

        List<Polygon> polygons = shape.getPolygons();

        polygons.forEach(polygon -> draw(g, polygon));
    }

    private void draw(Graphics2D g, Polygon polygon) {

        g.setColor(polygon.getColor());

        List<Vertex> vertices = Screen.convert(Perspective.convert(polygon)).getVertices();

        for (int i = 0; i < vertices.size(); i++) {
            Vertex e1 = vertices.get(i);
            Vertex e2 = (i + 1) >= vertices.size() ? vertices.get(0) : vertices.get(i + 1);

            g.drawLine(e1.getX(), e1.getY(), e2.getX(), e2.getY());
        }
    }
}

package leo.main;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Conservator {

    private static final String X = "x";
    private static final String Y = "y";
    private static final String Z = "z";
    private static final String COLOR = "color";
    private static final String POLYGONS = "polygons";
    private static final String VERTICES = "vertices";

    private static final Path PATH = Paths.get("resources/shape.json");

    public static Shape read() {

        try {
            StringBuilder sb = new StringBuilder();
            for (String line : Files.readAllLines(PATH)) {
                sb.append(line);
            }

            String read = sb.toString();

            JSONArray ja = new JSONObject(read).getJSONArray(POLYGONS);

            List<Polygon> polygons = new ArrayList<>();
            for (int i = 0; i < ja.length(); i++) {
                JSONObject jo = ja.getJSONObject(i);
                String hexColor = jo.getString(COLOR);

                List<Vertex> vertices = new ArrayList<>();
                JSONArray jaPoints = jo.getJSONArray(VERTICES);
                for (int j = 0; j < jaPoints.length(); j++) {
                    JSONObject joPoint = jaPoints.getJSONObject(j);
                    Vertex vertex = new Vertex(joPoint.getInt(X), joPoint.getInt(Y), joPoint.getInt(Z));
                    vertices.add(vertex);
                }
                polygons.add(new Polygon(Color.decode(hexColor), vertices));
            }

            return new Shape(polygons);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void write() throws IOException, JSONException {

        List<Polygon> polygons = new ArrayList<>();
        polygons.add(new Polygon(Color.RED,
                new Vertex(-200, -200, 200),
                new Vertex(200, -200, 200),
                new Vertex(200, -200, 1000),
                new Vertex(-200, -200, 1000)));

        polygons.add(new Polygon(Color.RED,
                new Vertex(-200, 200, 200),
                new Vertex(200, 200, 200),
                new Vertex(200, 200, 1000),
                new Vertex(-200, 200, 1000)));

        List<Object> shapes = new ArrayList();

        for (Polygon polygon : polygons) {
            Map<String, Object> map = new HashMap<>();
            map.put(COLOR, toHex(polygon.getColor()));
            map.put(VERTICES, asList(polygon));
            shapes.add(map);
        }

        JSONObject jo = new JSONObject();
        jo.put(POLYGONS, shapes);

        Files.writeString(PATH, jo.toString());
    }

    private static String toHex(Color color) {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }

    private static List<Map<String, Integer>> asList(Polygon polygon) {
        List<Map<String, Integer>> list = new ArrayList<>();

        for (Vertex p : polygon.getVertices()) {
            Map<String, Integer> map = new HashMap<>();
            map.put(X, p.getX());
            map.put(Y, p.getY());
            map.put(Z, p.getZ());
            list.add(map);
        }

        return list;
    }
}

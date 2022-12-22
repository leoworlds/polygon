package leo.main;

public class Perspective {

    private static final int FOCUS = 500;

    public static int persp(int p, int z) {
        return FOCUS * p / z;
    }
}

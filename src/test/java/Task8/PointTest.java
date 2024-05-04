package Task8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void test_get_x() {
        Task8.Point point = new Task8.Point(3, 4);
        assertEquals(3, point.getX());
    }

    @Test
    void test_get_y() {
        Task8.Point point = new Task8.Point(3, 4);
        assertEquals(4, point.getY());
    }

    @Test
    void test_translate() {
        Task8.Point point = new Task8.Point(3, 4);
        Task8.Point translatedPoint = point.translate(1, 3);
        assertEquals(new Task8.Point(4, 7), translatedPoint);
    }

    @Test
    void test_scale() {
        Task8.Point point = new Task8.Point(3, 4);
        Task8.Point scaledPoint = point.scale(0.5);
        assertEquals(new Task8.Point(1.5, 2), scaledPoint);
    }

    @Test
    void test_to_string() {
        Task8.Point point = new Task8.Point(3, 4);
        assertEquals("Point(x=3.0, y=4.0)", point.toString());
    }

    @Test
    void test_main() {
        Task8.Point p = new Task8.Point(3, 4).translate(1, 3).scale(0.5);
        assertEquals(new Point(2.0, 3.5), p);
    }
}
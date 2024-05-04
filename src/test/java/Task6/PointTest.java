package Task6;

import Task6.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {

    @Test
    void test_get_x() {
        Task6.Point point = new Task6.Point(3, 4);
        assertEquals(3, point.getX());
    }

    @Test
    void test_get_y() {
        Task6.Point point = new Task6.Point(3, 4);
        assertEquals(4, point.getY());
    }

    @Test
    void test_translate() {
        Task6.Point point = new Task6.Point(3, 4);
        point.translate(1, 3);
        assertEquals(new Task6.Point(4, 7), point);
    }

    @Test
    void test_scale() {
        Task6.Point point = new Task6.Point(3, 4);
        point.scale(0.5);
        assertEquals(new Task6.Point(1.5, 2), point);
    }

    @Test
    void test_to_string() {
        Task6.Point point = new Task6.Point(3, 4);
        assertEquals("(3.0, 4.0)", point.toString());
    }

    @Test
    void test_main() {
        Task6.Point p = new Task6.Point(3, 4);
        p.translate(1, 3);
        p.scale(0.5);
        assertEquals(new Point(2.0, 3.5), p);
    }
}

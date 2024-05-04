package AdditionalTask;

import java.util.ArrayList;
import java.util.List;


public record Square(Point topLeft, Point bottomRight) {
    public static boolean isIntersects(Square a, Square b) {
            return  a.topLeft.getY() <= b.bottomRight.getY() ||
                    a.bottomRight.getY() >= b.topLeft.getY() ||
                    a.bottomRight.getX() <= b.topLeft.getX() ||
                    a.topLeft.getX() >= b.bottomRight.getX();
    }

    public static List<Point> intersections(Square c1, Square c2) {
        List<Point> intersectPoints = new ArrayList<>();
        if (c1.equals(c2)) {
            intersectPoints.add(c1.topLeft);
            intersectPoints.add(c1.bottomRight);
            return intersectPoints;

        } else if (isIntersects(c1, c2)) {
            if (c1.bottomRight.equals(c2.topLeft)) {
                intersectPoints.add(c1.bottomRight);
            } else if (c2.topLeft.equals(c1.bottomRight)) {
                intersectPoints.add(c2.topLeft);
            } else {
                double x1 = Math.max(c1.topLeft.getX(), c2.topLeft().getX());
                double y2 = Math.max(c1.bottomRight.getY(), c2.bottomRight().getY());

                double x2 = Math.min(c1.bottomRight.getX(), c2.bottomRight().getX());
                double y1 = Math.min(c1.topLeft.getY(), c2.topLeft().getY());

                intersectPoints.add(new Point(x1, y1));
                intersectPoints.add(new Point(x2, y2));
            }
        }
        return intersectPoints;
    }

//    TODO проверить на совпадение угла, совпадение стороны. Запретить неправильную инициализацию. Ответить на вопросы на листочке.
}

package Task6;

import java.util.Objects;

/**
 * Класс, представляющий точку на плоскости.
 */
public final class Point {
    private double x;
    private double y;

    /**
     * Конструктор для создания точки с заданными координатами.
     *
     * @param x координата по оси X
     * @param y координата по оси Y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Конструктор для создания точки в начале координат.
     * Координаты точки (0, 0).
     */
    public Point() {
        this(0, 0); // Используем другой конструктор с заданными координатами
    }

    /**
     * Получает координату точки по оси X.
     *
     * @return координата по оси X
     */
    public double getX() {
        return this.x;
    }

    /**
     * Получает координату точки по оси Y.
     *
     * @return координата по оси Y
     */
    public double getY() {
        return this.y;
    }

//    public Point translate(double dx, double dy) {
//        return new Point(this.x + dx, this.y + dy);
//    }

//    public Point scale(double scaleFactor) {
//        return new Point(this.x * scaleFactor, this.y * scaleFactor);
//    }


//    класс перестает быть immutable -> убираются все final поля

    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
    }


    public void scale(double scaleFactor) {
        x *= scaleFactor;
        y *= scaleFactor;
    }


    /**
     * Представляет точку в виде строки в формате (x, y).
     *
     * @return строковое представление точки
     */
    @Override
    public String toString() {
        return STR."(\{this.x}, \{this.y})";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    // Override equals() method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return Double.compare(point.x, this.x) == 0 &&
                Double.compare(point.y, this.y) == 0;
    }
}

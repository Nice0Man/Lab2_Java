package Task8;

import lombok.Data;
import lombok.Getter;


/**
 * Класс, представляющий точку на плоскости.
 */
@Getter
@Data
public final class Point {
    /**
     * -- GETTER --
     *  Получает координату точки по оси X.
     *
     * @return координата по оси X
     */
    private final double x;
    /**
     * -- GETTER --
     *  Получает координату точки по оси Y.
     *
     * @return координата по оси Y
     */
    private final double y;

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
     * Перемещает точку на заданное расстояние в направлении координат X и Y.
     *
     * @param dx расстояние по оси X, на которое нужно переместить точку
     * @param dy расстояние по оси Y, на которое нужно переместить точку
     * @return новая точка, полученная после перемещения
     */
    public Point translate(double dx, double dy) {
        return new Point(this.x + dx, this.y + dy);
    }

    /**
     * Изменяет масштаб по обеим координатам на заданный коэффициент.
     *
     * @param scaleFactor коэффициент масштабирования
     * @return новая точка, полученная после изменения масштаба
     */
    public Point scale(double scaleFactor) {
        return new Point(this.x * scaleFactor, this.y * scaleFactor);
    }
}

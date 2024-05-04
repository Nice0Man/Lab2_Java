package Task2;

import java.util.Random;
import java.util.Scanner;

public class MyScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Модифицирующий (вызов метода useTypeCache, изменяющего состояние)
        int var1 = scanner.nextInt();

        Random random = new Random();
        // Метод доступа
        int var2 = random.nextInt();
    }
}

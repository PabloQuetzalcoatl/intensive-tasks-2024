package com.walking.intensive.chapter1.task4;

import static java.lang.Math.sqrt;

/**
 * Дано уравнение:
 *
 * <p>ax² + bx + c = 0
 *
 * <p>Реализуйте метод solveEquation(), который параметрами принимает
 * коэффициенты - вещественные числа a, b и c.
 *
 * <p>Метод должен возвращать в виде строки количество решений, а также сами решения в указанном ниже формате:
 * <ul>
 * <li> "Количество решений: 2. Корни: -4;4"
 * <li> "Количество решений: 1. Корень: 0"
 * <li> "Количество решений: 0."
 * <li> "Бесконечное множество решений."
 * </ul>
 *
 * <p>Обратите внимание, что если корней уравнения два - они должны располагаться по возрастанию.
 *
 * <p>P.S. Квадратные уравнения решаются либо через теорему Виета, либо через дискриминант.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task4 {
    public static void main(String[] args) {

        double a = 1;
        double b = -8;
        double c = 15;

        System.out.println(solveEquation(a, b, c));

    }

    static double discriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    static boolean isQuadraticEquation(double a) {
        return a != 0;
    }

    static String solveLinearEquation(double a, double b) {
        if (a == 0) {
            if (b == 0) {
                return "Бесконечное множество решений.";
            }
            return "Количество решений: 0.";
        }
        double root = -b / a;
        return String.format("Количество решений: 1. Корень: %.1f", root);
    }

    static String solveQuadraticEquation(double a, double b, double c) {
        double D = discriminant(a, b, c);
        if (D < 0) {
            return "Количество решений: 0.";
        }
        double root1 = (-b + sqrt(D)) / 2 * a;
        if (D == 0) {
            return String.format("Количество решений: 1. Корень: %.1f", root1);
        }
        double root2 = (-b - sqrt(D)) / 2 * a;
        if (root1 < root2) {
            return String.format("Количество решений: 2. Корни: %.1f;%.1f", root1, root2);
        }
        return String.format("Количество решений: 2. Корни: %.1f;%.1f", root2, root1);
    }

    static String solveEquation(double a, double b, double c) {
        if (isQuadraticEquation(a)) {
            return solveQuadraticEquation(a, b, c);
        }
        return solveLinearEquation(b, c);
    }
}

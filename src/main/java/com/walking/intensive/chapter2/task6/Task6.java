package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
        System.out.println(getGcdByEuclideanAlgorithm(1071,462));
        System.out.println(getGcd(1071,462));
        System.out.println(getLcm(16,20));
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {
        if (m <= 0 || n <= 0) {
            return -1;
        }

        int lcm = Math.max(m, n);

        while (lcm % m != 0 || lcm % n != 0) {
            lcm++;
        }

        return lcm;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {
        if (m <= 0 || n <= 0) {
            return -1;
        }

        int gcd = Math.max(m, n);

        while (m % gcd != 0 || n % gcd != 0) {
            gcd--;
        }
        return gcd;
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     * Расчет должен производиться с помощью алгоритма Евклида
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcdByEuclideanAlgorithm(int m, int n) {
        if (m <= 0 || n <= 0) {
            return -1;
        }

        return getGcdByEuclideanAlgorithmRecursion(Math.max(m, n), Math.min(m, n));
    }

    /**
     * <p>Входные параметры - положительные целые числа.
     * Рекурсивный вариант алгоритма Евклида
     */
    static int getGcdByEuclideanAlgorithmRecursion(int m, int n) {
        if (n == 0) {
            return m;
        }

        return getGcdByEuclideanAlgorithmRecursion(n, m % n);
    }
}

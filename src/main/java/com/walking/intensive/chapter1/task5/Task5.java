package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task5 {
    public static void main(String[] args) {

        double[] heights = getAngles(12, 13, 5);

        System.out.println(heights[0]);
        System.out.println(heights[1]);
        System.out.println(heights[2]);
    }

    /**
     * Как известно, У треугольника сумма любых двух сторон должна быть больше третьей.
     * <p>
     * Иначе две стороны просто "лягут" на третью и треугольника не получится.
     */
    static boolean isTriangleCorrect(double a, double b, double c) {
        return (a + b) > c && (a + c) > b && (b + c) > a;
    }

    /**
     * Частным случаем Tеоремы Брахмагупты является формула Герона.
     *
     * <p>Реализуйте метод поиска площади треугольника формулой Герона.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - площадь треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaByHeron(double a, double b, double c) {
        if (!isTriangleCorrect(a, b, c)) {
            return -1;
        }

        double p = (a + b + c) / 2.0;
        double S = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        return S;
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        if (!isTriangleCorrect(a, b, c)) {
            return new double[0];
        }

        double[] heights = new double[3];
        double S = getAreaByHeron(a, b, c);

        heights[0] = 2 * S / a;
        heights[1] = 2 * S / b;
        heights[2] = 2 * S / c;
        Arrays.sort(heights);

        return heights;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if (!isTriangleCorrect(a, b, c)) {
            return new double[0];
        }

        double[] medians = new double[3];

        medians[0] = Math.sqrt(2 * b * b + 2 * c * c - a * a) / 2;
        medians[1] = Math.sqrt(2 * a * a + 2 * c * c - b * b) / 2;
        medians[2] = Math.sqrt(2 * a * a + 2 * b * b - c * c) / 2;
        Arrays.sort(medians);

        return medians;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        if (!isTriangleCorrect(a, b, c)) {
            return new double[0];
        }

        double[] bisectors = new double[3];
        double p = (a + b + c) / 2.0;

        bisectors[0] = 2 * Math.sqrt(a * b * p * (p - c)) / (a + b);
        bisectors[1] = 2 * Math.sqrt(a * c * p * (p - b)) / (a + c);
        bisectors[2] = 2 * Math.sqrt(c * b * p * (p - a)) / (c + b);
        Arrays.sort(bisectors);

        return bisectors;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        if (!isTriangleCorrect(a, b, c)) {
            return new double[0];
        }

        double[] angles = new double[3];

        angles[0] = Math.toDegrees(Math.acos((b * b + c * c - a * a) / (2 * b * c)));
        angles[1] = Math.toDegrees(Math.acos((a * a + c * c - b * b) / (2 * a * c)));
        angles[2] = 180 - angles[0] - angles[1];
        Arrays.sort(angles);

        return angles;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        if (!isTriangleCorrect(a, b, c)) {
            return -1;
        }

        double p = (a + b + c) / 2.0;
        double r = Math.sqrt((p - a) * (p - b) * (p - c) / p);

        return r;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (!isTriangleCorrect(a, b, c)) {
            return -1;
        }

        double p = (a + b + c) / 2.0;
        double R = a * b * c / (4 * Math.sqrt(p * (p - a) * (p - b) * (p - c)));
        return R;
    }

    /**
     * Дополнительная задача по желанию.
     *
     * <p>Реализуйте метод, который будет возвращать площадь треугольника.
     *
     * <p>Расчет площади должен быть произведем через поиск косинуса угла через теорему косинусов,
     * далее нахождение синуса через основное тригонометрическое тождество
     * и подстановку синуса в нужную формулу для площади треугольника.
     * (Всего основных способов поиска площади треугольника 6)
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaAdvanced(double a, double b, double c) {
        if (!isTriangleCorrect(a, b, c)) {
            return -1;
        }
        //теорема косинусов:
        // a2 = b2 + c2 -2bc cos(alpha) -> cos(alpha)=b2+c2-a2 / 2bc
        // где alpha - угол противолежащий стороне a

        //основное тригонометрическое тождество:
        //Sin2(alpha)+Cos2(alpha)=1
        // зная косинус альфа найдем синус альфа
        // sin(alpha) = sqrt(1-cos2(alpha))

        //Площадь треугольника:
        // S = (с*b)/2 * sin(alpha) здесь alpha угол между сторонами с и b

        double cosAlpha = (b * b + c * c - a * a) / (2 * b * c);
        double sinAlpha = Math.sqrt(1 - cosAlpha * cosAlpha);
        double S = sinAlpha * b * c / 2;

        return S;
    }
}

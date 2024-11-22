package com.walking.intensive.chapter2.task7;

/**
 * Пятиклассник Ваня придумал забаву. Он ввел понятие «дружественной пары» чисел.
 * Два различных натуральных числа N и M он назвал дружественными, если сумма делителей числа N
 * (включая 1, но исключая само N) равна числу M и наоборот.
 *
 * <p>Например, 220 и 284 – дружественные числа:
 *
 * <ul>
 * <li>Список делителей для 220: 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110. Их сумма равна 284;
 * <li>Список делителей для 284: 1, 2, 4, 71, 142. Их сумма равна 220.
 * </ul>
 *
 * <p>Реализуйте метод getFriendlyPair(), который принимает параметром число N,
 * где N - натуральное число не больше 1 000 000.
 *
 * <p>Метод должен вернуть наибольшее число из пары дружественных чисел,
 * сумма дружественных чисел которой максимальна среди всех пар дружественных
 * чисел, большее из которых меньше N.
 *
 * <p> Если входные данные некорректны - метод должен возвращать -1.
 *
 * <p>P.S. Решение не должно использовать массивы и прочие темы, которые пока не были затронуты в курсе.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task7 {
    public static void main(String[] args) {
        long m1 = System.currentTimeMillis();
        System.out.println(getFriendlyPair(6000));
        long m2 = System.currentTimeMillis();
        System.out.println("Total:"+(m2-m1)/1000.0);

    }

    /**
     * n Натуральное число
     * возвращяет сумму всех собственных делителей числа n
     * Собственным делителем числа называется всякий его делитель, отличный от самого числа.
     */
    static int getSumProperDivisor(int n) {
        int sum = 1; // 1 - всегда будет среди делителей
        int maxDivisor = (int)Math.sqrt(n);
        for (int i = 2; i <= maxDivisor; i++) {
            if (n % i == 0) {
                sum += i;
                sum += n/i;
            }
        }
        return sum;
    }

    /**
     * Проверяет является ли пара чисел m и n дружественной
     */
    static boolean isFriendlyPair(int n, int m){
        return m != n && getSumProperDivisor(n) == m && getSumProperDivisor(m) == n;
    }

    static int getFriendlyPair(int n) {
        // нужно найти все пары друж. чисел  в диапазоне от 1 до n
        //
        //поступим по простому попарно переберем все числа от 1 до n
        //и сравним их на дружественность
        int result = -1;
        for (int i=1;i<=n;i++){
            for (int j=i;j<=n;j++){
                if (isFriendlyPair(i, j)){
                    System.out.printf("%d %d - friendly pair%n",i,j);
                }
            }

        }

        return 0;
    }
}

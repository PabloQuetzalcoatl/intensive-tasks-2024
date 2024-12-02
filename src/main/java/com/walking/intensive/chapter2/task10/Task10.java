package com.walking.intensive.chapter2.task10;

/**
 * Реализуйте метод isPalindrome(), который проверяет, является ли строка палиндромом.
 *
 * <p>Метод должен игнорировать пунктуацию, пробелы и регистр.
 *
 * <p>P.S. Мой любимый палиндром: Муза! Ранясь шилом опыта, ты помолишься на разум.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task10 {
    public static void main(String[] args) {

        System.out.println(isPalindrome("Он ест сено!"));

    }

    static boolean isPalindrome(String inputString) {
        if (inputString == null || inputString.length() < 2) {
            return false;
        }

        inputString = inputString.replaceAll("[\\p{Punct}\s]", "");
        inputString = inputString.toLowerCase();

        int centralIndex = inputString.length() / 2;
        int lastIndex = inputString.length() - 1;

        for (int i = 0; i < centralIndex; i++) {
            if (inputString.charAt(i) != inputString.charAt(lastIndex - i)) {
                return false;
            }
        }

        return true;
    }
}

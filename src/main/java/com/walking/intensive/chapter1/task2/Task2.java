package com.walking.intensive.chapter1.task2;

/**
 * Реализуйте метод getFlatLocation(), который будет принимать параметрами следующие данные:
 * <ul>
 * <li> Количество этажей в доме;
 * <li> Количество подъездов;
 * <li> Номер нужной квартиры.
 * </ul>
 *
 * <p>Необходимо определить подъезд, этаж и расположение нужной квартиры относительно лифта,
 * руководствуясь следующими правилами:
 * <ul>
 * <li> На этаже 4 квартиры;
 * <li> Нумерация квартир возрастает по часовой стрелке.
 * </ul>
 *
 * <p>Примеры строки, возвращаемой из метода:
 * <ul>
 * <li> 1 кв – 1 подъезд, 1 этаж, слева от лифта, влево
 * <li> 2 кв – 1 подъезд, 1 этаж, слева от лифта, вправо
 * <li> 3 кв – 1 подъезд, 1 этаж, справа от лифта, влево
 * <li> 4 кв – 1 подъезд, 1 этаж, справа от лифта, вправо
 * </ul>
 *
 * <p>Если для дома с указанной этажностью и количеством подъездов квартиры с заданным номером не существует,
 * метод должен вернуть строку "Такой квартиры не существует".
 *
 * <p>Если хотя бы один из указанных параметров некорректный - например, отрицательное число или 0,
 * метод должен вернуть строку "Некорректные входные данные".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task2 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        System.out.println(getFlatLocation(2, 2, 2));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        //Сначала - проверки этажей и подъездов
        if (floorAmount <= 0 || entranceAmount <= 0) {
            return "Некорректные входные данные";
        }

        //Для некорректной кв. по условию - отдельное сообщение
        int maxFlatNumber = floorAmount * entranceAmount * 4;
        if (flatNumber <= 0 || flatNumber > maxFlatNumber) {
            return "Такой квартиры не существует";
        }

        //Нумерация квартир, подъездов etc, начинается с "1"
        //Но для дальнейших расчетов c использованием целочисленного деления удобно будет вести всю нумерацию с "0"
        //А при выводе просто приведем все к привычной нумерации прибавив 1
        int countFlatAtFloor = 4;
        int modFlatNumber = flatNumber - 1;
        int numEntrance = (modFlatNumber) / (countFlatAtFloor * floorAmount);
        int numFloor = ((modFlatNumber) % (countFlatAtFloor * floorAmount)) / 4;
        int ordFlatNumber = (modFlatNumber) % countFlatAtFloor;
        String location = (ordFlatNumber < 2) ? "слева от лифта" : "справа от лифта";
        String orientation = (ordFlatNumber % 2 == 0) ? "влево" : "вправо";
        return String.format("%d кв - %d подъезд, %d этаж, %s, %s", modFlatNumber + 1, numEntrance + 1, numFloor + 1, location, orientation);
    }
}

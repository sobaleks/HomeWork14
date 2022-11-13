import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
      //Написать программу для вывода на консоль названия дня недели по введенной дате.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год, месяц и день:");
        LocalDate localDate = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        System.out.println(localDate.getDayOfWeek());

        //Написать программу для вывода на экран дату следующего вторника
        System.out.println("Дата ближайшего вторника:");
        LocalDate today = LocalDate.now();
        while (today.getDayOfWeek() != DayOfWeek.TUESDAY) {
            today = today.plusDays(1);
        }
        System.out.println(today);

        //Написать программу, которая проверяет, что строка начинается буквой “J”или “N” и заканчивается “A”.
        System.out.println("Введите строку");
        Predicate<String> isCorrect = str -> ((str.charAt(0) == 'J') || (str.charAt(0) == 'N')) && (str.charAt(str.length() - 1) == 'A');
        System.out.println(isCorrect.test(scanner.next()));

        //Написать лямбда выражение, которое принимает на вход объект типа Box и выводит на консоль сообщение
        // “Отгрузили ящик с весом n” где n – поле в классе которое содержит вес ящика.
        Consumer<Box> weightOfBox = box -> System.out.println("Отгрузили ящик весом " + box.weight);
        weightOfBox.accept(new Box(8));

        //Написать лямбда выражение, которое принимает на вход число и возвращает значение “Положительное число”,
        // “Отрицательное число” или  “Ноль”.
        Function<Integer, String> value = chislo -> {
            String result;
            if (chislo > 0) {
                result = "Положительное";
            } else if (chislo < 0) {
                result = "Отрицательное";
            } else {
                result = "Ноль";
            }
            return result;
        };
        System.out.println(value.apply(11));

        //Написать лямбда выражение, которое возвращает случайное число от 0 до 10.
        Supplier<Integer> randomInt = () -> new Random().nextInt(0, 11);
        System.out.println(randomInt.get());
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        System.out.println();
        System.out.println("Выберите пожалуйста вариант задания:");
        System.out.println("1. Ввести число приветствия");
        System.out.println("2. Ввести имя приветствия");
        System.out.println("3. Ввести массив чисел");
        System.out.println("0. Выход");

        scanner = new Scanner(System.in);
        switch (scanner.next()) {
            case "1":
                sayHello();
                mainMenu();
                break;
            case "2":
                sayHelloWithMyName();
                mainMenu();
                break;
            case "3":
                numbersDivisibleThree();
                mainMenu();
                break;
            case "0":
                System.out.println("Пока!");
                break;
        }
    }

    //Составить алгоритм: если введенное число больше 7, то вывести “Привет”
    public static void sayHello () {
        System.out.println("Введите, пожалуйста, число:");
        try {
            scanner = new Scanner(System.in);
            if (scanner.nextInt() > 7) {
                System.out.println("Привет");
            }
        } catch (Exception ex) { }

    }

    //Составить алгоритм: если введенное имя совпадает с Вячеслав, то вывести
    //“Привет, Вячеслав”, если нет, то вывести "Нет такого имени"
    public static void sayHelloWithMyName () {
        System.out.println("Введите пожалуйста имя:");
        scanner = new Scanner(System.in);
        if (scanner.nextLine().toLowerCase().equals("вячеслав")) {
            System.out.println("Привет, Вячеслав");
        } else {
            System.out.println("Нет такого имени");
        }
    }

    //Составить алгоритм: на входе есть числовой массив, необходимо вывести
    //элементы массива кратные 3
    public static void numbersDivisibleThree () {
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Введите несколько чисел через пробел (массив чисел):");

        scanner = new Scanner(System.in);
        String inputNumbers = scanner.nextLine();
        String[] numberStrings = inputNumbers.split(" ");

        for (String numberString : numberStrings) {
            try {
                int number = Integer.parseInt(numberString);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("В массиве присутствуют нечисловые данные");
                return;
            }
        }


        List<Integer> results = new ArrayList<>();
        for (int elem : numbers) {
            if (elem % 3 == 0) {
                results.add(elem);
            }
        }

        if (results.isEmpty()) {
            System.out.println("Массив, не содержит элементы кратные 3");
        } else {
            System.out.println("Элементы массива, кратные 3:");
            for (int num : results) {
                System.out.print(num + " ");
            }
        }
    }
}
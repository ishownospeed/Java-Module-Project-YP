import java.util.Scanner;

public class Check {
    private final Scanner scanner = new Scanner(System.in);

    public void splitRequest() {
        System.out.println("На скольких человек необходимо разделить счёт?");
        while (true) {
            if (scanner.hasNextInt()) {
                int countMembers = scanner.nextInt();
                if (countMembers == 1) {
                    System.out.println("Счёт не может быть разделён, если гость один\nВведите корректное количество гостей");
                } else if (countMembers < 1) {
                    System.out.println("Количество гостей не может быть отрицательным или быть нулевым\nВведите корректное количество гостей");
                } else {
                    new Calculator().printResult(countMembers);
                    scanner.close();
                    break;
                }
            } else {
                scanner.nextLine();
                System.out.println("\nУкажите правильное количество гостей, только цифры");
            }
        }
    }
}
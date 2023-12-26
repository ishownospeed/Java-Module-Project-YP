import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculator {
    private final Scanner scanner = new Scanner(System.in);
    private final Map<String, Double> goods = new HashMap<>();

    private void addGoods() {
        System.out.println("Введите название товара");
        String good = scanner.next();
        System.out.println("Введите стоимость товара в формате \"рубли,копейки\"");
        double priceGood = scanner.nextDouble();
        goods.put(good, priceGood);
        System.out.println("Товар: '" + good + '\'' +" успешно добавлен\n");
    }

    public void printResult(int countMembers) {
        addGoods();
        while(true) {
            System.out.println("Хотите ли добавить ещё один товар?");
            String userResponse = scanner.next();
            if (isControlAnswer(userResponse)) {
                countingTotals(countMembers);
                break;
            }
            addGoods();
        }
    }

    private boolean isControlAnswer(String response) {
        return response.toLowerCase().equalsIgnoreCase("Завершить");
    }

    private void countingTotals(int countMembers) {
        System.out.println("\nДобавленные товары:");
        printGoods();
        System.out.printf("Сумма: %.2f %s, которую должен заплатить каждый человек из %d гостей",
                (sumGoods() / countMembers), rubleOutput(sumGoods() / countMembers), countMembers
                );
    }

    private String rubleOutput(double sum) {
        String result = "";
        int ruble = (int) (sum % 10);

        switch (ruble) {
            case 1:
                result = "рубль";
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 0:
                result = "рублей";
                break;
            case 2:
            case 3:
            case 4:
                result = "рубля";
                break;
        }
        return result;
    }

    private double sumGoods() {
        double sum = 0;
        for (double good : goods.values()) {
            sum += good;
        }
        return sum;
    }

    private void printGoods() {
        for (String good : goods.keySet()) {
            System.out.printf("%s %.2f%n", good, goods.get(good));
        }
    }

}

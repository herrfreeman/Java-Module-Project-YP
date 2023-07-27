import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello world!");

        int guestCount;

        while (true) {
            System.out.print("На скольких гостей разделить счёт: ");
            guestCount = scanner.nextInt();
            if (guestCount <= 1) {
                System.out.println("Ошибка! Количество гостей должно быть больше 1");
            } else {
                break;
            }
        }

        Calculator calculator = new Calculator(guestCount);

        String command = "";
        while (!command.equalsIgnoreCase("завершить")) {

            System.out.print("Введите наименование товара: ");
            String productName = scanner.next();
            System.out.print("Введите стоимость товара: ");
            float productCost = Float.parseFloat(scanner.next());
            calculator.addProduct(productName, productCost);
            System.out.print("Введите \"завершить\" чтобы закончить ввод товаров или любой символ чтобы продолжить: ");
            command = scanner.next();
        }
        calculator.showTotal();
    }
}


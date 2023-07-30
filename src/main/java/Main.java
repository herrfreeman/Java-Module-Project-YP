import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); //Чтобы принимать float с "." вместо ","

        int guestCount;

        while (true) {
            System.out.print("На скольких гостей разделить счёт: ");

            guestCount = scanInt(scanner);
            if (guestCount <= 1) {
                System.out.println("Ошибка! Количество гостей должно быть больше 1");
            } else {
                break;
            }
        }

        Calculator calculator = new Calculator(guestCount);

        String command = "";
        while (!command.equalsIgnoreCase("завершить")) {

            Product product = new Product();
            System.out.print("Введите наименование товара: ");
            product.name = scanner.next();
            System.out.print("Введите стоимость товара [руб.коп]: ");
            product.cost = scanFloat(scanner);
            calculator.addProduct(product);

            System.out.print("Введите \"завершить\" чтобы закончить ввод товаров или любой символ чтобы продолжить: ");
            command = scanner.next();
        }
        calculator.showTotal();
    }

    public static int scanInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.print("Ошибка! Введено некорректное значение. Введите целое числовое значение: ");
                scanner.next();
            }
        }
    }

    public static float scanFloat(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextFloat();
            } catch (Exception e) {
                System.out.print("Ошибка! Введено некорректное значение. Введите целое или дробное значение: ");
                scanner.next();
            }
        }
    }
}


import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); //Чтобы принимать float с "." вместо ","
        scanner.useDelimiter("\n"); //Позволяет вводить строки с пробелами

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

            System.out.print("Введите наименование товара: ");
            String productName = scanNotEmptyString(scanner);
            System.out.print("Введите стоимость товара [руб.коп]: ");
            float productCost = scanFloatBiggerOrEqualThan(scanner,0.01f);

            calculator.addProduct(new Product(productName,productCost));

            System.out.print("Введите \"завершить\" чтобы закончить ввод товаров или любой символ чтобы продолжить добавление товаров: ");
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
                scanner.skip(".*");
            }
        }
    }

    public static float scanFloatBiggerOrEqualThan(Scanner scanner, float biggerThan) {
        float input = scanFloat(scanner);
        while(input < biggerThan) {
            System.out.printf(Locale.US, "Ошибка! Введите значение больше или равное %.2f: ", biggerThan);
            input = scanFloat(scanner);
        }
        return input;
    }

    public static float scanFloat(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextFloat();
            } catch (Exception e) {
                System.out.print("Ошибка! Введено некорректное значение. Введите целое или дробное значение через \".\": ");
                scanner.skip(".*"); //пролистывает сканер до конца т.к. в нем остается некорректное значение
            }
        }
    }

    public static String scanNotEmptyString(Scanner scanner) {
        String input = scanString(scanner);
        while(input.isEmpty()) {
            System.out.print("Ошибка! Введите непустую строку: ");
            input = scanString(scanner);
        }
        return input;
    }

    public static String scanString(Scanner scanner) {
        while (true) {
            try {
                return scanner.next();
            } catch (Exception e) {
                System.out.print("Ошибка! Введено некорректное значение. Введите строку: ");
                scanner.skip(".*");
            }
        }
    }
}


import java.util.ArrayList;
import java.util.Locale;

public class Calculator {
    int guestCount;
    ArrayList<Product> goods;

    Calculator(int guestCountInit) {
        this.guestCount = guestCountInit;
        this.goods = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        goods.add(product);
        System.out.printf("Товар [%s] добавлен\n", product.getDescrption());
    }

    public static String getCurrencyName(float quantity) {
        int last2Digitst = (int)quantity%100;

        if  (last2Digitst >= 11 && last2Digitst <= 19 ) {
            return "рублей";
        } else {

            int lastDigit = (int) quantity % 10;
            if (lastDigit == 1) {
                return "рубль";
            } else if (lastDigit >= 2 && lastDigit <= 4) {
                return "рубля";
            } else {
                return "рублей";
            }
        }
    }
    public void showTotal() {

        System.out.println("Добавленные товары:");
        float totalCost = 0f;
        for (Product item : this.goods) {
            System.out.printf(" - %s\n", item.getDescrption());
            totalCost += item.getCost();
        }

        float costPerMan = totalCost/this.guestCount;
        String currencyName = getCurrencyName(costPerMan);

        System.out.printf(Locale.US,"Итого: %.2f \nГостей: %d \nСумма на каждого гостя: %.2f %s\n", totalCost, this.guestCount, costPerMan, currencyName);
    }

}

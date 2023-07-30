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
    }

    public static String getCurrencyName(float qty) {
        //int last2Digitst = ((int)Math.floor(qty))%100;
        int last2Digitst = (int)qty%100;

        if  (last2Digitst >= 11 && last2Digitst <= 19 ) {
            return "рублей";
        } else {

            int lastDigit = (int) qty % 10;
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
            System.out.printf(Locale.US," - %s %.2f%n", item.name, item.cost);
            totalCost += item.cost;
        }

        float costPerMan = totalCost/this.guestCount;
        String currencyName = getCurrencyName(costPerMan);

        System.out.printf(Locale.US,"Итого: %.2f \nГостей: %d \nСумма на каждого гостя: %.2f %s", totalCost, this.guestCount, costPerMan, currencyName);
    }

}

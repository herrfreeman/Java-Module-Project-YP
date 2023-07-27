public class Calculator {
    int guestCount;
    String goods;
    float totalCost;
    Calculator(int guestCountInit) {
        this.guestCount = guestCountInit;
        this.goods = "";
        this.totalCost = 0.0f;
    }

    public void addProduct(String productName, float productCost) {

        this.goods += String.format("\n %s : ",productName) + String.format("%.2f",productCost).replace(",",".");
        this.totalCost += productCost;
    }

    public void showTotal() {

        float costPerMan = this.totalCost/this.guestCount;
        int lastDigit = (int)costPerMan%10;
        String currencyName;
        if (lastDigit == 1) {
            currencyName = "рубль";
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            currencyName = "рубля";
        } else {
            currencyName = "рублей";
        }

        System.out.println("Добавленные товары: " + this.goods);
        System.out.println(String.format("Итого: %.2f",this.totalCost).replace(",","."));
        System.out.println("Гостей: " + this.guestCount);
        System.out.println(String.format("Сумма на каждого гостя: %.2f %s", costPerMan, currencyName).replace(",","."));

    }

}

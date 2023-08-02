import java.util.Locale;

public class Product {
    private String name;
    private float cost;

    Product(String name, float cost){
        this.name = name;
        this.cost = cost;
    }

    public String getDescrption() {
        return String.format(Locale.US,"%s %.2f", this.name, this.cost);
    }

    public float getCost() {
        return this.cost;
    }

}

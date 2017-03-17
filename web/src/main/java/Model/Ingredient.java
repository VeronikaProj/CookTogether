package Model;

/**
 * Created by Ника on 16.03.2017.
 */
public class Ingredient {

    private int id;
    private Product product;
    private String amount;

    public Ingredient(int id,Product product,String amount){
        this.product=product;
        this.amount = amount;
        this.id=id;
    }

    public Product getProduct() {
        return product;
    }

    public String getAmount() {
        return amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

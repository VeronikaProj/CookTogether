package Model;

/**
 * Created by Ника on 16.03.2017.
 */
public class Ingredient {

    private Product product;
    private String amount;

    public Ingredient(Product product,String amount){
        this.product=product;
        this.amount = amount;
    }

}

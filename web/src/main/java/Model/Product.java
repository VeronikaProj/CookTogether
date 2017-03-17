package Model;

/**
 * Created by Ника on 16.03.2017.
 */
public class Product {

    private int id;

    private String name;

    public Product(int id, String name){
        this.id=id;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

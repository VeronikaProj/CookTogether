package Model;

/**
 * Created by Ника on 16.03.2017.
 */
public enum DishType {
    SOUP(1,"суп","soup.gif"),
    DRINK(2,"напиток","drink.gif"),
    SALAD(3, "салат","salad.gif"),
    DESSERT(4, "десерт","dessert.gif"),
    MAIN_DISH(5,"основное блюдо", "main_dish.gif"),
    GARNISH(6,"гарнир", "garnish.gif");

    private int id;
    private String value;
    private String pictureFilename;

    DishType(int id, String value, String pictureFilename) {
        this.id = id;
        this.value = value;
        this.pictureFilename = pictureFilename;
    }

    public String getValue() {
        return value;
    }

    public String getPictureFilename() {
        return value;
    }

    public int getId() {
        return id;
    }
}

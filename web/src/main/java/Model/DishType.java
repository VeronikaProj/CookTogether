package Model;

/**
 * Created by Ника on 16.03.2017.
 */
public enum DishType {
    SOUP(1,"Суп","soup.gif"),
    DRINK(2,"Напиток","drink.gif"),
    SALAD(3, "Салат","salad.gif"),
    DESSERT(4, "Десерт","dessert.gif"),
    MAIN_DISH(5,"Основное блюдо", "main_dish.gif"),
    GARNISH(6,"Гарнир", "garnish.gif");

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

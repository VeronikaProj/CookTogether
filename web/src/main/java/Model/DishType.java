package Model;

/**
 * Created by Ника on 16.03.2017.
 */
public enum DishType {
    SOUP(1,"Суп"),
    DRINK(2,"Напиток"),
    SALAD(3, "Салат"),
    DESSERT(4, "Десерт"),
    MAIN_DISH(5,"Основное блюдо"),
    GARNISH(6,"Гарнир");

    private int id;
    private String value;

    DishType(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getId() {
        return id;
    }
}

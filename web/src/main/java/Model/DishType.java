package Model;

import java.io.UnsupportedEncodingException;

/**
 * Created by Ника on 16.03.2017.
 */
public enum DishType {
    SOUP(1,"суп","/pictures/soup.gif"),
    DRINK(2,"напиток","/pictures/drink.gif"),
    SALAD(3, "салат","/pictures/salad.gif"),
    DESSERT(4, "десерт","/pictures/dessert.gif"),
    MAIN_DISH(5,"основное блюдо", "/pictures/main_dish.gif"),
    GARNISH(6,"гарнир", "/pictures/garnish.gif");

    private int id;
    private String value;
    private String pictureFilename;

    DishType(int id, String value, String pictureFilename) {
        this.id = id;
        this.value = value;
        this.pictureFilename = pictureFilename;
    }

    public String getValue() {
        try {
            return new String(value.getBytes("windows-1251"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "dish_type";
    }

    public String getPictureFilename() {
        return pictureFilename;
    }

    public int getId() {
        return id;
    }
}

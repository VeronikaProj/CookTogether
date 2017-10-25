package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ника on 16.03.2017.
 */
public class Recipe {

    private int id;
    private String name;
    private User user;
    private Date date;
    private DishType type;
    private byte[] picture;
    private int    numberOfPortions;
    private int    time;
    private String recipe;
    private int likes;
    private ArrayList<Ingredient> ingredients;


    public Recipe(int id,
                  User user,
                  String name,
                  Date date,
                  DishType type,
                  int    numberOfPortions,
                  int    time,
                  String recipe,
                  int likes,
                  byte[] picture,
                  ArrayList<Ingredient> ingredients){
        this.id=id;
        this.user=user;
        this.name=name;
        this.date=date;
        this.type=type;
        this.numberOfPortions=numberOfPortions;
        this.time=time;
        this.recipe=recipe;
        this.likes=likes;
        this.ingredients=ingredients;
        this.picture=picture;

    }

    public Recipe() {
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }


    public byte[] getPicture() {
        return picture;
    }

    public DishType getType() {
        return type;
    }

    public int getNumberOfPortions() {
        return numberOfPortions;
    }

    public String getRecipe() {return recipe;   }

    public int getTime() {
        return time;
    }

    public int getLikes() {
        return likes;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}

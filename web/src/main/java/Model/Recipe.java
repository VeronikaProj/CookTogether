package Model;

import java.util.ArrayList;
import java.util.Date;

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
}

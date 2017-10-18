package DAO;

import Model.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ника on 17.03.2017.
 */
public class RecipeDao {

//    id                 INT AUTO_INCREMENT PRIMARY KEY,
//    id_user            INT NOT NULL,
//    name               VARCHAR(100) NOT NULL,
//    date               DATETIME,
//    id_type            INT NOT NULL,
//    id_picture         INT,
//    number_of_portions INT NOT NULL,
//    period              VARCHAR(100),
//    recipe              VARCHAR(600),
//    likes                INT,
//    FOREIGN KEY (id_type) REFERENCES Dish_type (id),
//    FOREIGN KEY (id_picture) REFERENCES Picture (id),
//    FOREIGN KEY (id_user) REFERENCES User (id),

    public static final String SELECT_ALL_SQL =
            "SELECT rr.id as idRecipe,rr.id_user,rr.name,date,type_code_name,picture,number_of_portions,date " +
                    ",time, recipe,likes,id_product,id_user,first_name,last_name,amount, i.id as iId, id_product, " +
                    "p.name as prodName "+
                    "FROM Recipe rr JOIN Dish_type t on rr.id_type=t.id JOIN Ingredient i " +
                    "on rr.id = i.id_recipe INNER JOIN Product p ON i.id_product = p.id " +
                    "JOIN User u ON rr.id_user=u.id ORDER BY rr.id";



    private DataSource dataSource;

    public RecipeDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public int create(Recipe recipe) {
        int id=-1;
        int idUser=recipe.getUser().getId();
        int idType=recipe.getType().getId();

        try (Connection connection = dataSource.getConnection();

             PreparedStatement preparedStatement0 = connection.prepareStatement(
                     "INSERT INTO Picture (picture) VALUES (?);",
                     Statement.RETURN_GENERATED_KEYS);



             PreparedStatement preparedStatement1 = connection.prepareStatement(
                     "insert into Recipe (id_user, name, date, id_type," +
                             " id_picture, number_of_portions, time, recipe, likes)" +
                             " values (?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)){
            preparedStatement1.setObject(5,null);
            if(recipe.getPicture()!=null){
            preparedStatement0.setObject(1,recipe.getPicture());
            preparedStatement1.executeUpdate();
                try (ResultSet generatedKeys = preparedStatement1.getGeneratedKeys()) {
                    if (generatedKeys.next())
                        preparedStatement1.setObject(5,generatedKeys.getInt(1));
                }
            }

            preparedStatement1.setObject(1, idUser);
            preparedStatement1.setObject(2, recipe.getName());
            preparedStatement1.setObject(3,recipe.getDate());
            preparedStatement1.setObject(4,idType);
            preparedStatement1.setObject(6,recipe.getNumberOfPortions());
            preparedStatement1.setObject(7,recipe.getTime());
            preparedStatement1.setObject(8,recipe.getLikes());
            preparedStatement1.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement1.getGeneratedKeys()) {
                if (generatedKeys.next())
                    recipe.setId(generatedKeys.getInt(1));
                IngredientDao ingredientDao=new IngredientDao(this.getDataSource());
                for(Ingredient c:recipe.getIngredients()){
                    c.setRecipeId(recipe.getId());
                    ingredientDao.create(c);
                }
            }


        }
        catch(Exception e){}// TODO: написать обработку!!!! в т.ч. логирование
        return id;
    }

    public int remove(Recipe recipe) {
        int id=-1;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Recipe where id=?");){

            preparedStatement.setObject(1,recipe.getId());

            preparedStatement.executeUpdate();
            id=recipe.getId();

        }
        catch (SQLException e){} //TODO:написать обработку!!!! в т.ч. логирование

        return id;
    }

    public List<Recipe> getAll() {
        List<Recipe> recipes = new ArrayList<>();
        ArrayList<Ingredient> ingredients=new ArrayList<>();
        Recipe recipe=new Recipe();
        int idLast=0;
        Blob blob;
        User user;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL)) {
           // UserDao userDao=new UserDao(this.getDataSource());
            while (resultSet.next()) {
                int idRecipe=resultSet.getInt("idRecipe");
                if (idRecipe!=idLast) {
                    recipe.setIngredients(ingredients);
                    recipes.add(recipe);
                    ingredients.clear();
                    blob =  resultSet.getBlob("picture");
                    user=new User(resultSet.getInt("id_user"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"));
                    //int blobLength = (int) blob.length();

                    byte[] blobAsBytes;
                    if(blob==null)
                        blobAsBytes=null;
                    else {blobAsBytes=blob.getBytes(1, (int)blob.length());
                    blob.free();};
                    recipe=new Recipe(idRecipe, user,
                                resultSet.getString("name"),
                                resultSet.getDate("date"),
                                DishType.valueOf(resultSet.getString("type_code_name")),
                                resultSet.getInt("number_of_portions"),
                                resultSet.getInt("time"),
                                resultSet.getString("recipe"),
                                resultSet.getInt("likes"),
                                blobAsBytes,
                                null
                            );



                }
                ingredients.add(new Ingredient(resultSet.getInt("iId"),
                        new Product(resultSet.getInt("id_product"),
                                resultSet.getString("prodName")),
                        resultSet.getString("amount")));
                idLast=idRecipe;

            }
            recipe.setIngredients(ingredients);
            recipes.add(recipe);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        recipes.remove(0);
        return recipes;
    }

    public int numberOfRecipes(){
        int numberOfRecipes=0;
        try (Connection connection = dataSource.getConnection();){
             Statement statement=connection.createStatement();
             ResultSet resultSet=statement.executeQuery("SELECT COUNT (*) FROM Recipe");
             resultSet.next();
             numberOfRecipes=resultSet.getInt(1);
             int k=1+numberOfRecipes;
        }
        catch (SQLException e){
            e.printStackTrace();} //TODO:написать обработку!!!! в т.ч. логирование

        return numberOfRecipes;

    }

    public List<Recipe> getNew(int offset, int amount) {
        List<Recipe> recipes = new ArrayList<>();
        ArrayList<Ingredient> ingredients=new ArrayList<>();
        Recipe recipe=new Recipe();
        int idLast=0;
        Blob blob;
        User user;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT id_r_recipe, id_user, recipe_name, date, type_code_name, likes, picture, number_of_portions, time, recipe, id_product, id_user," +
                     "first_name,last_name, amount, i.id as ingredient_id,name from (SELECT  name as recipe_name ,rr.id as id_r_recipe,recipe,date,likes,picture,time,type_code_name,type, id_user,first_name,last_name,number_of_portions FROM Recipe rr JOIN Dish_type t on rr.id_type=t.id " +
                     "JOIN user u ON rr.id_user=u.id ORDER BY date offset ? limit ?) JOIN Ingredient i " +
                        "on id_r_recipe = i.id_recipe INNER JOIN Product p ON i.id_product = p.id ");
             ) {
            statement.setInt(1, offset);
            statement.setInt(2, amount);
            Statement st=connection.createStatement();
            // statement.setInt(2, amount);
            ResultSet resultSet=statement.executeQuery();

            while (resultSet.next()) {
                int idRecipe=resultSet.getInt("id_r_recipe");
                if (idRecipe!=idLast) {
                    recipe.setIngredients(ingredients);
                    recipes.add(recipe);
                    ingredients.clear();
                    blob =  resultSet.getBlob("picture");
                    user=new User(resultSet.getInt("id_user"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"));
                    //int blobLength = (int) blob.length();

                    byte[] blobAsBytes;
                    if(blob==null)
                        blobAsBytes=null;
                    else {blobAsBytes=blob.getBytes(1, (int)blob.length());
                        blob.free();};
                    recipe=new Recipe(idRecipe, user,
                            resultSet.getString("recipe_name"),
                            resultSet.getDate("date"),
                            DishType.valueOf(resultSet.getString("type_code_name")),
                            resultSet.getInt("number_of_portions"),
                            resultSet.getInt("time"),
                            resultSet.getString("recipe"),
                            resultSet.getInt("likes"),
                            blobAsBytes,
                            null
                    );



                }
                ingredients.add(new Ingredient(resultSet.getInt("ingredient_id"),
                        new Product(resultSet.getInt("id_product"),
                                resultSet.getString("name")),
                        resultSet.getString("amount")));
                idLast=idRecipe;

            }
            recipe.setIngredients(ingredients);
            recipes.add(recipe);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if (!recipes.isEmpty()) {
            recipes.remove(0);
        }
        return recipes;
    }

    public  DataSource getDataSource() {
        return dataSource;
    }
}

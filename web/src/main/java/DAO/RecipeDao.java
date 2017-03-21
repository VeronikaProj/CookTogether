package DAO;

import Model.Ingredient;
import Model.Product;
import Model.Recipe;

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

//    public static final String SELECT_ALL_SQL =
//            "SELECT i.id,p.id, name,date,type,amount " +
//                    "FROM recipe i,Ingredient p,Picture"+
//                    "WHERE i.id_product=p.id";

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
             PreparedStatement preparedStatement0 = connection.prepareStatement("DELETE FROM Ingredient where id_recipe=?");
             PreparedStatement preparedStatement1 = connection.prepareStatement("DELETE FROM Recipe where id=?")){

            preparedStatement0.setObject(1,recipe.getId());
            preparedStatement0.executeUpdate();

            preparedStatement1.setObject(1,recipe.getId());
            preparedStatement1.executeUpdate();

            id=recipe.getId();

        }
        catch (SQLException e){} //TODO:написать обработку!!!! в т.ч. логирование

        return id;
    }

//    public Ingredient read(Ingredient id){
//        Ingredient ingredient=null;
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement statement = connection.prepareStatement("SELECT name,i.id,p.id, name,amount " +
//                     "FROM ingredient i,product p"+
//                     "WHERE p.id=i.id_product AND id=?")){
//            ResultSet resultSet = statement.executeQuery();
//            Product product=new Product(
//                    resultSet.getInt("p.id"),
//                    resultSet.getString("name")
//            );
//            ingredient=new Ingredient(
//                    resultSet.getInt("i.id"),
//                    product,
//                    resultSet.getString("amount")
//            );
//        }
//        catch (Exception e){};
//        return ingredient;
//
//    }
//
//    public List<Product> getAll() {
//        List<Product> products = new ArrayList<>();
//
//        try (Connection connection = dataSource.getConnection();
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL)) {
//
//            while (resultSet.next()) {
//                products.add(new Product(
//                        resultSet.getInt("id"),
//                        resultSet.getString("name")
//                ));
//            }
//        }
//        catch (Exception e){
//
//        }
//        return products;
//    }


    public  DataSource getDataSource() {
        return dataSource;
    }
}

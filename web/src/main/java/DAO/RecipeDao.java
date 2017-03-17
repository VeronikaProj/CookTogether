package DAO;

import Model.Ingredient;
import Model.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ника on 17.03.2017.
 */
public class RecipeDao {
//
//
//
//    public static final String SELECT_ALL_SQL =
//            "SELECT i.id,p.id, name,amount " +
//                    "FROM ingredient i,product p"+
//                    "WHERE i.id_product=p.id";
//
//    private DataSource dataSource;
//
//    public IngredientDao(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//
//    public int create(Ingredient ingredient) {
//        int id=-1;
//        ProductDao d =new ProductDao(this.getDataSource());
//        int idProduct=d.create(ingredient.getProduct());
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(
//                     "INSERT INTO Ingredient (id_product,amount) " +
//                             "VALUES (?,?)", Statement.RETURN_GENERATED_KEYS)) {
//
//            preparedStatement.setObject(1, idProduct);
//            preparedStatement.setObject(2, ingredient.getAmount());
//            preparedStatement.executeUpdate();
//
//            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
//                if (generatedKeys.next())
//                    id=generatedKeys.getInt(1);
//            }
//
//        }
//        catch(Exception e){}// TODO: написать обработку!!!! в т.ч. логирование
//        return id;
//    }
//
//    public int remove(Ingredient ingredient) {
//        int id=-1;
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ingredient where id=?")) {
//            preparedStatement.setObject(1,ingredient.getId());
//            preparedStatement.executeUpdate();
//            id=ingredient.getId();
//        }
//        catch (SQLException e){} //TODO:написать обработку!!!! в т.ч. логирование
//
//        return id;
//    }
//
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
//
//
//    public  DataSource getDataSource() {
//        return dataSource;
//    }
}

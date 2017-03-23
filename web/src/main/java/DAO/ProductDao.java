package DAO;

import Model.Product;
import Model.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ника on 17.03.2017.
 */
public class ProductDao {



    public static final String SELECT_ALL_SQL =
            "SELECT id, name " +
                    "FROM product";

    private DataSource dataSource;

    public ProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public int create(Product product) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO product (name) " +
                             "VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setObject(1, product.getName());
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next())
                    product.setId(generatedKeys.getInt(1));
            }
            //TODO: если запись уже существует, добавить запрос id по имени продукта
        }
        catch(Exception e){}// TODO: написать обработку!!!! в т.ч. логирование
        return product.getId();
    }

    public int remove(Product product) {
        int id=-1;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM product where id=?")) {
            preparedStatement.setObject(1,product.getId());
            preparedStatement.executeUpdate();
            id=product.getId();
        }
        catch (SQLException e){} //TODO:написать обработку!!!! в т.ч. логирование

        return id;
    }

    public Product read(int id){
        Product product=null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT id, name" +
                     "FROM Product WHERE id=?")){
            ResultSet resultSet = statement.executeQuery();

            product=new Product(
                    resultSet.getInt("id"),
                    resultSet.getString("name")
            );
        }
        catch (Exception e){};
        return product;

    }

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL)) {

            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                ));
            }
        }
        catch (Exception e){

        }
        return products;
    }

}

package DAO;

import Model.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ника on 16.03.2017.
 */
public class UserDao {



    public static final String SELECT_ALL_SQL =
            "SELECT id, first_name, last_name, date_of_birth, lang_Ru," +
                    "email, password_hash, photo, is_male " +
                    "FROM User";

    private DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public int create(User user) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO User (first_name, last_name, date_of_birth, lang_Ru," +
                             "email, password_hash,is_male ,photo) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setObject(1, user.getFirstName());
            preparedStatement.setObject(2, user.getLastName());
            preparedStatement.setObject(3, user.getDateOfBirth());
            preparedStatement.setObject(4, user.getLangRu());
            preparedStatement.setObject(5, user.getEmail());
            preparedStatement.setObject(6, user.getPasswordHash());
            preparedStatement.setObject(7, user.getIsMale());
            preparedStatement.setObject(8, user.getPhoto());

            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next())
                    user.setId(generatedKeys.getInt(1));
            }
        }
        catch(Exception e){}//написать обработку!!!! в т.ч. логирование
        return user.getId();
    }

    public int remove(User user) {
        int id=-1;
        // remove user's favorites
         //       user's subscriptions and followers
         //       user's recipes( and ingredients)
         try (Connection connection = dataSource.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM USER where id=?")) {
                preparedStatement.setObject(1,user.getId());
             preparedStatement.executeUpdate();
             id=user.getId();
         }
          catch (SQLException e){} //написать обработку!!!! в т.ч. логирование

        return id;
     } //доделать целостность

    public User read(int id){
        User user=null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT id, first_name, last_name, date_of_birth, lang_Ru," +
                     "email, password_hash,is_male, photo " +
                     "FROM User WHERE id=?")){
             statement.setObject(1,id);
             ResultSet resultSet = statement.executeQuery();
             Blob blob=  resultSet.getBlob("photo");
             int blobLength = (int) blob.length();
             byte[] blobAsBytes = blob.getBytes(1, blobLength);
             blob.free();

             user=new User(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getDate("date_of_birth").toLocalDate(),
                        resultSet.getBoolean("lang_Ru"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("is_male"),
                        blobAsBytes

                );
            }
        catch (Exception e){}
        return user;

    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        Blob blob;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL)) {

            while (resultSet.next()) {
                blob =  resultSet.getBlob("photo");


                byte[] blobAsBytes;
               // byte[] blobAsBytes = blob.getBytes(1,(int)blobLength);
                if(blob==null)
                    blobAsBytes=null;
                else {
                    blobAsBytes=blob.getBytes(1, (int)blob.length());
                    blob.free();};
               // blob.free();

                users.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getDate("date_of_birth").toLocalDate(),
                        resultSet.getBoolean("lang_Ru"),
                        resultSet.getString("email"),
                        resultSet.getString("password_hash"),
                        resultSet.getBoolean("is_male"),
                        blobAsBytes

                ));
            }
        }
        catch (Exception e){

        }
        return users;
    }


    public User getUserByEmail(String email) {
        User user=null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT id, first_name, last_name, date_of_birth, lang_Ru," +
                     "email, password_hash,is_male, photo " +
                     "FROM User WHERE email=?")){
            statement.setObject(1,email);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            Blob blob=  resultSet.getBlob("photo");
            byte[] blobAsBytes;
            // byte[] blobAsBytes = blob.getBytes(1,(int)blobLength);
            if(blob==null)
                blobAsBytes=null;
            else {
                blobAsBytes=blob.getBytes(1, (int)blob.length());
                blob.free();};

            user=new User(
                    resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getDate("date_of_birth").toLocalDate(),
                    resultSet.getBoolean("lang_Ru"),
                    resultSet.getString("email"),
                    resultSet.getString("password_hash"),
                    resultSet.getBoolean("is_male"),
                    blobAsBytes

            );
        }
        catch (Exception e){}
        return user;
    }
}

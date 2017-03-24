package DAO;

import Model.Product;
import Model.Recipe;
import org.h2.command.dml.Select;
import org.junit.Before;
import org.junit.Test;
import org.h2.jdbcx.*;

import javax.annotation.Resource;
import javax.sql.DataSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created by Ника on 23.03.2017.
 */
public class RecipeDaoTest {



    @Test
    public void testGetAll() throws Exception {

        int id;
        Class.forName("org.h2.Driver");
        JdbcDataSource dataSource=new JdbcDataSource();
        dataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");

        String path= new File("src/main/resources/Sql/h2").getAbsolutePath();
        Pattern pattern = Pattern.compile("^\\d+\\.sql$");
        Path sqlDirPath =Paths.get(path);
        Connection connection = dataSource.getConnection();





        try (

             Statement statement = connection.createStatement();
             DirectoryStream<Path> paths = Files.newDirectoryStream(sqlDirPath)) {
            for (Path filePath : paths) {

                if (pattern.matcher(filePath.toFile().getName()).find()) {
                    statement.addBatch(
                            Files.lines(filePath)
                                    .collect(Collectors.joining())
                    );
                }

            }
            statement.executeBatch();


        } catch (SQLException e) {

        } catch (IOException e) {}


            RecipeDao recipeDao = new RecipeDao(dataSource);
            Collection<Recipe> recipes = recipeDao.getAll();
            assertNotNull(recipes);
            assertEquals( 3,recipes.size());




    }
}
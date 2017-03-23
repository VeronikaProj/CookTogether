package Listeners;

import DAO.UserDao;
import DAO.RecipeDao;
import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

/**
 * Created by Ника on 21.03.2017.
 */




@WebListener
public class Injector implements ServletContextListener {

    @Resource(name = "jdbc/TestDB")
    private DataSource dataSource;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        UserDao userDao = new UserDao(dataSource);
        RecipeDao recipeDao = new RecipeDao(dataSource);
        sce.getServletContext().setAttribute("UserDao", userDao);
        sce.getServletContext().setAttribute("RecipeDao",recipeDao);

    }

}

package Controllers;

import DAO.RecipeDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static Model.User.FIRST_NAME_KEY;

/**
 * Created by Ника on 21.03.2017.
 */
@WebServlet("/InitPage/")
public class InitPageController extends HttpServlet {

    private RecipeDao recipeDao;

    public static final String WELCOME_KEY = "Welcome";
    public static final String ALL_RECIPES_KEY = "AllRecipes";

    @Override
    public void init(ServletConfig config) throws ServletException {
        recipeDao = (RecipeDao) config.getServletContext().getAttribute("RecipeDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String s = Optional.ofNullable(req.getSession().getAttribute(FIRST_NAME_KEY))
                .map(o -> String.format("Hello, %s!", o))
                .orElse("Hello!");

        req.setAttribute(WELCOME_KEY, s);
        req.setAttribute(ALL_RECIPES_KEY, recipeDao.getAll());
        int id=recipeDao.getAll().size();
        req.getRequestDispatcher("/WEB-INF/index.jsp")
                .forward(req, resp);
    }
}

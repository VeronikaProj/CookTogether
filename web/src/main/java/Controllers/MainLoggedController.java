package Controllers;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


import DAO.RecipeDao;
import Model.Recipe;
import internationalization.ResourceProperty;

import static Controllers.ParamNames.*;
import static Model.User.FIRST_NAME_KEY;

//import static Controllers.LoginController.USER_ID;
//import static Controllers.LoginController.USER_NAME;


/**
 * Created by Ника on 28.03.2017.
 */
@WebServlet("/news")

public class MainLoggedController extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private RecipeDao recipeDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        recipeDao = (RecipeDao) config.getServletContext().getAttribute(RECIPE_DAO);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
        try{
            session.getAttribute(LANGUAGE);
        }
        catch(Exception e) {
            session.setAttribute(LANGUAGE, RU);
        }
        int id;

        try {
            id = (int) session.getAttribute(USER_ID);
            int page=1;
            int recordsPerPage=2;
            if(request.getParameter("page")!=null) { //Pagination was taken from https://stackoverflow.com/questions/31410007/how-to-do-pagination-in-jsp
                page= Integer.parseInt(request.getParameter("page"));
            }
            int noOfRecords = recipeDao.numberOfRecipes();
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);


            List<Recipe> list = recipeDao.getNew((1-page)*page,recordsPerPage);
            request.setAttribute("recipeList", list);
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);

             request.getRequestDispatcher("/WEB-INF/news/")
                    .forward(request,response);
        }
        catch (Exception e){
            request.getRequestDispatcher("/WEB-INF/loginError/")
                    .forward(request,response);
        }



    }
}

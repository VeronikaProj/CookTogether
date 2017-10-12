package Controllers;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;


import DAO.RecipeDao;
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
      //      response.sendRedirect("/WEB-INF/news.jsp");
             request.getRequestDispatcher("/WEB-INF/news/")
                    .forward(request,response);
        }
        catch (Exception e){
            request.getRequestDispatcher("/WEB-INF/loginError/")
                    .forward(request,response);
        }



    }
}

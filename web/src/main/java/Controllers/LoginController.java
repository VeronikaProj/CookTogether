package Controllers;

import DAO.RecipeDao;
import DAO.UserDao;
import Model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ника on 28.03.2017.
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

    private UserDao userDao;
    static final String USER_ID="userId";
    static final String USER_NAME="userName";
    private String email;
    private String password;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        email = request.getParameter("email");
        password = request.getParameter("password");

        User user=userDao.getUserByEmail(email);
        if ((user==null)||(!user.getPasswordHash().equals(password))){
            request.getRequestDispatcher("/WEB-INF/loginError/").forward(request,response);

        }
        else {
            String name =user.getFirstName()+" "+user.getLastName();
                    request.getSession().setAttribute(USER_ID, user.getId());
            request.getSession().setAttribute(USER_NAME, name);
            response.sendRedirect("/news");
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

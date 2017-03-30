package Controllers;

import DAO.UserDao;
import Model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import static Controllers.ParamNames.*;

/**
 * Created by Ника on 30.03.2017.
 */
@WebServlet("/profile")
public class ProfileController extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = (UserDao) config.getServletContext().getAttribute(USER_DAO);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        int id=0;
        int targetId;
        try {
             id = (int) session.getAttribute(ID);

        }
        catch (NullPointerException e)
        {request.getRequestDispatcher("/WEB-INF/loginError").forward(request,response);}
        try {
             targetId = Integer.parseInt(request.getParameter(ID));
        }catch (NullPointerException e) {targetId=id;}
        User u;
        u=userDao.read(targetId);
        request.setAttribute(USER,u);
        String path="";
        if (id==targetId)
            path="/WEB-INF/myProfile";
        else path="/WEB-INF/profile";
        request.getRequestDispatcher(path).forward(request,response);
    }
}

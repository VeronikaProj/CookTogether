package Controllers;



import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static Controllers.ParamNames.*;


@WebServlet("/logout")
public class LogOutController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try{
            HttpSession session=request.getSession();
            session.removeAttribute(USER_ID);
            session.removeAttribute(USER_NAME);
            request.getRequestDispatcher("/").forward(request,response);
        }
        catch(Exception e){

        }
    }
}

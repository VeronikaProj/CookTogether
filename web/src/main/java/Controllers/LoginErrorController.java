package Controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static Controllers.ParamNames.LANGUAGE;
import static Controllers.ParamNames.RU;

@WebServlet("/loginError")
public class LoginErrorController extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//            HttpSession session=request.getSession();
//            session.getAttribute(LANGUAGE);
           // session.setAttribute(LANGUAGE,RU);
            request.getRequestDispatcher("/WEB-INF/loginError/index.jsp")
                    .forward(request,response);

        }
}


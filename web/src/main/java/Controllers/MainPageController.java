package Controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import internationalization.ResourceProperty;

import static Controllers.ParamNames.*;

//import static Controllers.LoginController.USER_ID;
//import static Controllers.LoginController.USER_NAME;


/**
 * Created by Ника on 28.03.2017.
 */
@WebServlet("/")

public class MainPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      HttpSession session=request.getSession();


        if (session.getAttribute(USER_ID)==null){

        }


    }
}

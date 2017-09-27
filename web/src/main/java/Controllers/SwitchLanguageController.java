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
import static Controllers.ParamNames.EN;

@WebServlet("/changeLanguage")
public class SwitchLanguageController extends HttpServlet {
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        }
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            HttpSession session=request.getSession();
           try{

           if (session.getAttribute(LANGUAGE).equals(RU)) {
               session.removeAttribute(LANGUAGE);
               session.setAttribute(LANGUAGE,EN);
           }
           else
           {
               session.removeAttribute(LANGUAGE);
               session.setAttribute(LANGUAGE,RU);
           }
            }
            catch(Exception e) {
                session.setAttribute(LANGUAGE, EN);
            }
        response.sendRedirect("/");

        }
    }



package Listeners;

import internationalization.Dictionary;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import static Controllers.ParamNames.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Ника on 29.03.2017.
 */
@WebListener
public class DictionaryInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        Path sqlDirPath = Paths.get(
//                sce.getServletContext().getRealPath("WEB-INF\\classes\\internationalization"));
//        String path=sqlDirPath.toUri().getPath();
//        path="D:\\ucheba\\Java\\apache-tomcat-9.0.0.M17\\webapps\\ROOT\\WEB-INF\\classes\\internationalization\\prop.properties";
//
        Dictionary d=new Dictionary("internationalization.prop");
        sce.getServletContext().setAttribute(DICTIONARY,d);
        //todo: Implement conversion of properties file native2ascii each time app starts
    }
}

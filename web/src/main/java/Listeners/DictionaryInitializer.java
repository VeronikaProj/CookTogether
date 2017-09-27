package Listeners;

import internationalization.Dictionary;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import static Controllers.ParamNames.*;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Ника on 29.03.2017.
 */
@WebListener
public class DictionaryInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        Dictionary d=new Dictionary("internationalization.prop");
        sce.getServletContext().setAttribute(DICTIONARY,d);

    }
}

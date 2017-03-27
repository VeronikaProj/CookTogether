package internationalization;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Ника on 27.03.2017.
 */
public class ResourceProperty {
    ResourceBundle bundle;
    public ResourceProperty(Locale locale){
        bundle= ResourceBundle.getBundle("prop.properties",locale);
    }
    public String getValue(String key){
        return bundle.getString(key);
    }

}

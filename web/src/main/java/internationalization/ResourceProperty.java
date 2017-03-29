package internationalization;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Ника on 27.03.2017.
 */
public class ResourceProperty {
    ResourceBundle bundle;
    public ResourceProperty(String base,Locale locale){
        bundle= ResourceBundle.
                getBundle(base,locale);
//         getBundle("resorces/internationalization/prop.properties",locale);
    }
    public String getValue(String key){
        return bundle.getString(key);
    }

}

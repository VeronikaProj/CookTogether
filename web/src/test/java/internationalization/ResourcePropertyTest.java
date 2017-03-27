package internationalization;

import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Created by Ника on 27.03.2017.
 */
public class ResourcePropertyTest {
    @Test
    public void getValue() throws Exception {
        ResourceProperty prop=new ResourceProperty(new Locale("ru","Ru"));
        assertEquals("пароль",prop.getValue("password"));
    }

}
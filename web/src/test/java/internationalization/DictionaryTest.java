package internationalization;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static Controllers.ParamNames.*;

/**
 * Created by Ника on 29.03.2017.
 */
public class DictionaryTest {
    @Test
    public void getValue() throws Exception {

        Dictionary d=new Dictionary("src\\test\\resources\\prop");
        assertEquals("добавить рецепт",d.getValue(RU,"newRecipe"));


    }

}
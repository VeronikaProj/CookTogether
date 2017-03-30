package internationalization;


import Controllers.ParamNames;

import java.util.Locale;
 import static Controllers.ParamNames.*;
/**
 * Created by Ника on 29.03.2017.
 */
public class Dictionary {

    private ResourceProperty ruWords;
    private ResourceProperty enWords;

    public Dictionary(String base){

        ruWords=new ResourceProperty(base,new Locale("ru","Ru"));
        enWords=new ResourceProperty(base,Locale.ENGLISH);

    }
    public String getValue (String language,String key){
        if (language==null) language=RU;
        switch (language){
            case EN:{
                return enWords.getValue(key);
            }
            case RU:{
                return ruWords.getValue(key);
            }
            default:{
                return ruWords.getValue(key);// Throw Exception
            }
        }
    }
}

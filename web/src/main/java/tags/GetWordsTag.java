package tags;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;


import internationalization.Dictionary;
import internationalization.ResourceProperty;

import java.io.IOException;

import static Controllers.ParamNames.*;

/**
 * Created by Ника on 28.03.2017.
 */
public class GetWordsTag extends BodyTagSupport {

private String bodyString;

    @Override
    public int doEndTag() throws JspTagException {
        try {
            ServletContext context=pageContext.getRequest().getServletContext();
            Dictionary dictionary=(Dictionary) context.getAttribute(DICTIONARY);
            String language=(String)pageContext.getSession().getAttribute(LANGUAGE);
            String str=dictionary.getValue(language,getBodyContent().getString());
            pageContext.getOut().write(str);

            //pageContext.getOut().write("i'm tired :(");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}

package tags;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import internationalization.ResourceProperty;

/**
 * Created by Ника on 28.03.2017.
 */
public class GetWordsTag extends BodyTagSupport {


    private ResourceProperty resourceProperty;
    public void setResourceProperty( ResourceProperty resourceProperty){
     this.resourceProperty=resourceProperty;
    }

    @Override
    public int doAfterBody() throws JspTagException {
        try{

            pageContext.getOut().write(
                    resourceProperty.getValue(getBodyContent().getString()));
            return SKIP_BODY;
        }
        catch (Exception e){

            e.printStackTrace();//todo : правильный отлов и логировнаие!
            return EVAL_BODY_INCLUDE;
        }


    }
}

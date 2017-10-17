package sait.tags;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author 734972
 */
public class DebugTag extends TagSupport {

 
    @Override
    public int doStartTag() throws JspException {
        
        ServletRequest request = pageContext.getRequest();
        String domain = request.getServerName();
        
        if (domain.startsWith("test") || domain.equals("localhost")) {
            String debug = request.getParameter("debug");
            if (debug != null) {
                return EVAL_BODY_INCLUDE;
            }
            else {
                return SKIP_BODY;
            }
        }
        return SKIP_BODY;
    }
    
}

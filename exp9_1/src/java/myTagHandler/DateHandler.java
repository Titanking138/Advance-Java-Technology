/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTagHandler;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author admin
 */
public class DateHandler extends TagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     * @throws javax.servlet.jsp.JspException
     */
    
    @Override
     public int doStartTag() throws JspException {
         JspWriter out = pageContext.getOut();

        try{
            out.print(Calendar.getInstance().getTime());
        }
        catch(IOException e)
        {
        }
        return SKIP_BODY;
    }
    
    
}

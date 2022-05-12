/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myTagHandler;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;



/**
 *
 * @author arjun
 */
public class HeaderHandler extends TagSupport{
    
    String align;
    String border;
    String bgcolor, color, font;
    int size;

    public void setAlign(String align) {
        this.align = align;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
   

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        
        try {
            out.print("<div  style = 'color:"+this.color+"; font-family:"+this.font+"; border-style:"+this.border+"; background-color : "+this.bgcolor + ";font-size:"+this.size+"; text-align : "+this.align+"' > IT074 Kevla Merja </div>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return SKIP_BODY;
    }

    
    
    
}

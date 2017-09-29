/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projjsp;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

/**
 *
 * @author u14189
 */
public class LoginClienteTag extends SimpleTagSupport{
    private String login;
    private String senha;
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public void doTag() throws JspException, IOException {
        JspContext context = getJspContext();
        JspWriter out  = context.getOut();
    
    Clientes clientes = new Clientes();
    
    if((login!= null && !login.trim().equals("")) && ((senha!= null && !senha.trim().equals("")))){
        try {
            if (clientes.cadastrado(login))
                out.println("<jsp:forward page=\"clienteLogado.jsp\"/>)");
            else{
                out.println("Cliente não cadastrado.");    
                }
        } catch (Exception ex) {
            Logger.getLogger(LoginAdmTag.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    JspFragment bodyFragment = getJspBody();
    StringWriter sw = new StringWriter();
    
    bodyFragment.invoke(sw);
    StringBuffer bodyBuffered = sw.getBuffer();
    out.println(bodyBuffered);
    }
    
    
    
    
}

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

/**
 *
 * @author u14189
 */

public class LoginAdmTag extends SimpleTagSupport {
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
       /* if (user!= null && !user.trim().equals("")) {
            out.println("Hello, " + user + "!");
        } else {
        out.println("Hello, World!");
        } */
    
    Administradores adms = new Administradores();
    
    if((login!= null && !login.trim().equals("")) && ((senha!= null && !senha.trim().equals("")))){
        try {
            if (adms.cadastrado(login, senha))
                out.println("ok");
            else{
                out.println("Administrador não cadastrado.");    
                }
        } catch (Exception ex) {
            Logger.getLogger(LoginAdmTag.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
}
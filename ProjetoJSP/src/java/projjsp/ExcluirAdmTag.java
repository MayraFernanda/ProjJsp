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
public class ExcluirAdmTag extends SimpleTagSupport{
    private String login; 

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspContext context = getJspContext();
        JspWriter out  = context.getOut();

        Administradores adm = new Administradores();
    
        if(login!= null){
            try {
                if (adm.cadastrado(login))
                    adm.excluir(login);   
                else{
                    out.println("Administrador não cadastrado.");
                    }
            } catch (Exception ex) {
                Logger.getLogger(LoginAdmTag.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

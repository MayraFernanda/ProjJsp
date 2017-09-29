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
public class ExcluirClienteTag extends SimpleTagSupport{
    
    private int id; 

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspContext context = getJspContext();
        JspWriter out  = context.getOut();

        Clientes clientes = new Clientes();
    
        if(id!= 0){
            try {
                if (clientes.cadastrado(id))
                    clientes.excluir(id);   
                else{
                    out.println("Cliente não cadastrado.");
                    }
            } catch (Exception ex) {
                Logger.getLogger(LoginAdmTag.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

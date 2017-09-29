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
public class ExcluirProdutoTag extends SimpleTagSupport{
   private int cod; 

    public void setCod(int cod) {
        this.cod = cod;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspContext context = getJspContext();
        JspWriter out  = context.getOut();

        
        Produtos p = new Produtos();
    
        if(cod!= 0){
            try {
                if (p.cadastrado(cod))
                    p.excluir(cod);   
                else{
                    out.println("Produto não cadastrado.");
                    }
            } catch (Exception ex) {
                Logger.getLogger(LoginAdmTag.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
}

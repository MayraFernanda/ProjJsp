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
public class CadastrarClienteTag extends SimpleTagSupport {
    
    private int id; 
    private String nome, endereco, telefone, email, senha; 

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspContext context = getJspContext();
        JspWriter out  = context.getOut();

        Clientes clientes = new Clientes();
    
        if((id!= 0) && ((senha!= null && !senha.trim().equals("")))){
            try {
                if (clientes.cadastrado(email))
                    out.println("Cliente não cadastrado.");
                else{
                    clientes.incluir(id, nome, endereco, telefone, email, senha);
                    }
            } catch (Exception ex) {
                Logger.getLogger(LoginAdmTag.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

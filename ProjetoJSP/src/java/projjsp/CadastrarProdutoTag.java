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
public class CadastrarProdutoTag extends SimpleTagSupport{
    private int cod, estoque; 
    private String nome, imagem;
    private float preco;

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    

    @Override
    public void doTag() throws JspException, IOException {
        JspContext context = getJspContext();
        JspWriter out  = context.getOut();

        Produtos p = new Produtos();
    
        if((cod!= 0)){
            try {
                if (p.cadastrado(cod))
                    out.println("Produto já cadastrado.");
                else{
                    p.incluir(cod, nome, imagem, preco, estoque);
                    }
            } catch (Exception ex) {
                Logger.getLogger(LoginAdmTag.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

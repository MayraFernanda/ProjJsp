/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projjsp;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author u14189
 */
public class Carrinho {
    Produto p = new Produto();
    Produtos produtos = new Produtos();
    ArrayList<Integer> carrinho = new ArrayList<>();
    
     public boolean adicionar(int cod) throws Exception{
        carrinho.add(cod);
        return true;
    }
     
    public List<Produto> mostraCarrinho() throws Exception{
        ArrayList<Produto> car = new ArrayList<>();
        
        for(int i=0;i<carrinho.size();i++){
         car.add(produtos.getProduto(Integer.toString(carrinho.get(i))));
        }
        return car;
    }
    
    
}

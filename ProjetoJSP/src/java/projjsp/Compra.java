/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projjsp;

/**
 *
 * @author u14189
 */
public class Compra {
    @Override
    public String toString() {
        return "Compra{" + "numero " + numero + ", id " + id +
               ", cartao " + cartao + ", estado " + estado +"}";
    }
    
    private int numero;
    private int id; 
    private String cartao;
    private int estado; 

    public int getNumero() {
        return numero;
    }

    public int getId() {
        return id;
    }

    public String getCartao() {
        return cartao;
    }

    public int getEstado() {
        return estado;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }   
    
    public Compra(){
    }
    
    public Compra(int numero, int id, String cartao, int estado){
        this.numero = numero;
        this.id = id;
        this.cartao = cartao;
        this.estado = estado;
    
    }
}

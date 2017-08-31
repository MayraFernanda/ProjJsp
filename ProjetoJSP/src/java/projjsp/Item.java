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
public class Item {
     @Override
    public String toString() {
        return "Item{" + "numero " + numero + ", cod " + cod + "qtd " + qtd +"}";
    }
    
    private int numero;
    private int cod; 
    private int qtd;    

    public int getNumero() {
        return numero;
    }

    public int getCod() {
        return cod;
    }

    public int getQtd() {
        return qtd;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    
}

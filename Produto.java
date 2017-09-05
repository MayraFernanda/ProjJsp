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
public class Produto {
    @Override
    public String toString() {
        return "Produto{" + "cod " + cod + ", nome " + nome + ", imagem " + imagem +
               ", preco " + preco + ", estoque " + estoque +"}";
    }
    
    private int cod;
    private String nome;
    private String imagem;
    private float preco;
    private int estoque;

    public int getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public String getImagem() {
        return imagem;
    }

    public float getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setCod(int cod) {
        this.cod = cod;
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

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public Produto(){
    }
    
    public Produto(int cod, String nome, String imagem, float preco, int estoque){
        this.cod = cod;
        this.nome = nome;
        this.imagem = imagem;
        this.preco = preco;
        this.estoque = estoque;
    }
    
}

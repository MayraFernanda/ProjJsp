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
public class Cliente {
    @Override
    public String toString() {
        return "Cliente{" + "id " + id + ", nome " + nome + ", endereço " + endereco+
               ", telefone " + telefone+ ", email " + email+ ", senha " + senha +"}";
    }
    
    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String senha;

    // � claro que os m�todos obrigat�rios deveriam ser feitos
    // para a implementa��o ficar completa

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

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

   
    public Cliente(){
    }
    
    public Cliente(int id, String nome, String endereco, String telefone, String email, String senha){
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }
    
}

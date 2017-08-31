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
public class Administrador {
    @Override
    public String toString() {
        return "Administrador{" + "login " + login + ", senha " + senha +"}";
    }
    
    private String login;
    private String senha; 

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Administrador(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
    
    public Administrador(){
      
    }
}

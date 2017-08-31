/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projjsp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author u14189
 */
public class Clientes {
    public boolean cadastrado (int id) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * FROM Clientes WHERE id='"+id+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            ResultSet resultado = (ResultSet) stmt.executeQuery();

            retorno = resultado.first();
        }
        catch (SQLException erro)
        {
            throw new Exception(erro);
        }

        return retorno;
    }
    
    public boolean cadastrado (Cliente cliente) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * FROM Clientes WHERE id='"+cliente.getId()+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            ResultSet resultado = (ResultSet) stmt.executeQuery();

            retorno = resultado.first();
        }
        catch (SQLException erro)
        {
            throw new Exception(erro);
        }

        return retorno;
    }
    

    public boolean incluir (int id, String nome, String endereco, String telefone, String email, String senha) throws Exception
    {
        if (id == 0)
            throw new Exception ("Id não fornecido");
        
        if (nome == null)
            throw new Exception ("Nome não fornecido");
        
        if (endereco == null)
            throw new Exception ("Endereço não fornecido");
        
        if (telefone == null)
            throw new Exception ("Telefone não fornecido");
        
        if (email == null)
            throw new Exception ("Email não fornecido");
        
        if (senha == null)
            throw new Exception ("Senha não fornecida");

        try
        {
            String sql;

            sql = "INSERT INTO Clientes VALUES ('id','nome', 'endereco','telefone', 'email', 'senha')";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            stmt.executeUpdate ();
            
            if (cadastrado(id))
                return true;
            
            return false;
        }
        catch (SQLException erro)
        {
            throw new Exception(erro);
        }   
    }

    public boolean excluir (int id) throws Exception
    {
        if (!cadastrado(id))
            throw new Exception ("Cliente não cadastrado");

        try
        {
            String sql;

            sql = "DELETE FROM Clientes WHERE id='id'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            stmt.executeUpdate ();
            
            if (cadastrado(id))
                return false;
            
            return true;
        }
        catch (SQLException erro)
        {
            throw new Exception(erro);
        }
    }

    public boolean alterar (int id, Cliente cliente) throws Exception
    {
        if (cliente==null)
            throw new Exception ("Cliente não fornecido");

        if (!cadastrado(id))
            throw new Exception ("Cliente não fornecido");

        try
        {
            String sql;

            sql = "UPDATE Clientes SET id='"+cliente.getId()+"', nome='"+cliente.getNome()+"', endereco='"+cliente.getEndereco()+"',telefone='"+cliente.getTelefone()+"',email='"+cliente.getEmail()+"',senha='"+cliente.getSenha()+"'  WHERE id='"+id+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            stmt.executeUpdate ();
            
            if (cadastrado(cliente))
                return true;
            
            return false;
        }
        catch (SQLException erro)
        {
            throw new Exception(erro);
        }
    }
    
    
    public Cliente getCliente (int id) throws Exception
    {
        Cliente cliente = null;

        try
        {
            String sql;

            sql = "SELECT * FROM Clientes WHERE id ='"+id+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            ResultSet resultado = (ResultSet)stmt.executeQuery();

            if (!resultado.first())
                throw new Exception ("Não cadastrado");

            cliente = new Cliente (resultado.getInt("id"), resultado.getString("nome"),
                                   resultado.getString("endereco"), resultado.getString("telefone"),
                                   resultado.getString("email"), resultado.getString("senha"));
        }
        catch (SQLException erro)
        {
            throw new Exception(erro);
        }

        return cliente;
    }
    
    
    public String getCliente (String email) throws Exception
    {
        String retorno = ""; 
        try
        {
            String sql;

            sql = "SELECT * FROM Clientes WHERE email ='"+email+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            ResultSet resultado = (ResultSet)stmt.executeQuery();

            if (!resultado.first())
                throw new Exception ("Não cadastrado");

            retorno = resultado.getString("email");
        }
        catch (SQLException erro)
        {
            throw new Exception(erro);
        }

        return retorno;
    }
    
    public boolean senhaCorreta (String login, String senha) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * FROM Clientes WHERE login='"+login+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            ResultSet resultado = (ResultSet)stmt.executeQuery();

            retorno = resultado.next();
            
            if (resultado.getString(2) != senha)
                return retorno;
            else 
                retorno = true;
                return retorno;
        }
        catch (SQLException erro)
        {
            //throw new Exception ("Erro ao procurar Cliente");
            throw new Exception(erro);
        }
    }

}

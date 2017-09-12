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
public class Administradores {
    public boolean cadastrado (String login, String senha) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * FROM Administradores WHERE login='"+login+"' AND senha='"+senha+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            ResultSet resultado = (ResultSet)stmt.executeQuery();

            retorno = resultado.next();
        }
        catch (SQLException erro)
        {
            throw new Exception (erro);
        }

        return retorno;
    }
    
    public boolean cadastrado (Administrador Administrador) throws Exception
    {
    	boolean retorno = false;
    	
    	try
    	{
            String sql;
            sql = "SELECT * FROM Administradores WHERE login='"+Administrador.getLogin()+"' AND senha='"+Administrador.getSenha()+"'";
            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            
            ResultSet resultado = (ResultSet)stmt.executeQuery();
            
            if(resultado.next())
                return true;
            return false;
    	}
    	catch(SQLException erro)
    	{
    		return false;
    	}        	
    }
    
    public boolean cadastrado (String login) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * FROM Administradores WHERE login='"+login+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            ResultSet resultado = (ResultSet)stmt.executeQuery();

            retorno = resultado.next();
        }
        catch (SQLException erro)
        {
            throw new Exception (erro);
        }

        return retorno;
    }
    
    public boolean senhaCorreta (String login, String senha) throws Exception 
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * FROM Administradores WHERE login='"+login+"' AND senha='"+senha+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            ResultSet resultado = (ResultSet)stmt.executeQuery();

            retorno = resultado.next();
        }
        catch (SQLException erro)
        {
            throw new Exception (erro);
        }
        return retorno;
    }

    public boolean incluir (Administrador Administrador) throws Exception
    {
        if (Administrador==null)
            throw new Exception ("Administrador não fornecido.");

        try
        {
            String sql;

            sql = "INSERT INTO Administradores (login,senha) VALUES ('"+Administrador.getLogin()+"','"+Administrador.getSenha()+"')";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);

            stmt.executeUpdate();
            
            if (cadastrado(Administrador))
                return true;
            
            return false;
        }
        catch (SQLException erro)
        {
            throw new Exception (erro);
        }   
    }

    public boolean excluir (String login) throws Exception
    {
        if (!cadastrado(login))
            throw new Exception ("Adminstrador não cadastrado");

        try
        {
            String sql;
            
            sql = "DELETE FROM Administradores WHERE login ='"+login+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);

            stmt.executeUpdate ();
            
            if (cadastrado(login))
                return false;
            
            return true;
        }
        catch (SQLException erro)
        {
            throw new Exception (erro);
        }
    }

    public boolean alterar (String login, Administrador administrador) throws Exception
    {
        if (administrador==null)
            throw new Exception ("Login nao fornecido");

        if (!cadastrado(login))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "UPDATE Administradores SET login='"+administrador.getLogin()+"', senha='"+administrador.getSenha()+"' WHERE login='"+login+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            stmt.executeUpdate ();
            
            if (cadastrado(login))
                return true;
            
            return false;
        }
        catch (SQLException erro)
        {
            throw new Exception (erro);
        }
    }
    
    public boolean alterarSenha (String login, String novaSenha) throws Exception 
    {
        if (!cadastrado(login))
            throw new Exception ("Nao cadastrado");

        try
        {            
            String sql;

            sql = "UPDATE Administradores SET senha='"+novaSenha+"' WHERE login='"+login+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            stmt.executeUpdate ();
            
            if (cadastrado(login, novaSenha))
               return true;
            
            return false;
        }
        catch (SQLException erro)
        {
            throw new Exception (erro);
        }
    }
    

    public Administrador getAdministrador(String login) throws Exception
    {
        Administrador administrador = null;

        try
        {
            String sql;

            sql = "SELECT * FROM Administradores WHERE login ='"+login+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            ResultSet resultado = (ResultSet) stmt.executeQuery();            
            
            if (!resultado.next())
                return null;

            administrador = new Administrador(resultado.getString("login"), resultado.getString("senha"));
        }
        catch (SQLException erro)
        {
            erro.printStackTrace(System.err);
            throw new Exception (erro);
        }

        return administrador;
    }

    public List getAdministradores () throws Exception
    {
        List<Administrador> lista = null;

        try
        {
            String sql;

            sql = "SELECT * FROM Administradores";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);

            ResultSet resultado = (ResultSet) stmt.executeQuery();
            
            if (resultado.next()){
                Administrador linha = new Administrador();
                linha.setLogin(resultado.getString(1));
                linha.setSenha(resultado.getString(2));
                lista.add(linha);
                
                while (resultado.next()){
                    linha.setLogin(resultado.getString(1));
                    linha.setSenha(resultado.getString(2));
                    lista.add(linha);
                }
            }
        }
        catch (SQLException erro)
        {
            throw new Exception (erro);
        }

        return lista;
    }
}

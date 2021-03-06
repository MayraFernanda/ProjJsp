/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projjsp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author u14189
 */
public class Produtos {
    public boolean cadastrado (int cod) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * FROM Produtos WHERE cod='"+cod+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            ResultSet resultado = (ResultSet) stmt.executeQuery();

            retorno = resultado.next();
        }
        catch (SQLException erro)
        {
            throw new Exception (erro);
        }

        return retorno;
    }
    
    public boolean cadastrado (Produto produto) throws Exception
    {
    	boolean retorno = false;
    	
    	try
    	{
            String sql;
            sql = "SELECT * FROM Produtos WHERE id='"+produto.getCod()+"'";
            
            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            ResultSet resultado = (ResultSet) stmt.executeQuery();
            
            retorno = resultado.next();
    	}
    	catch(SQLException erro)
    	{
    		throw new Exception (erro);
    	}
    	
    	return retorno;
    }

    public boolean incluir (Produto produto) throws Exception
    {
        if (produto==null)
            throw new Exception ("Produto não fornecido");

        try
        {
            String sql;

            sql = "INSERT INTO Produtos VALUES ('"+produto.getCod()+"','"+produto.getNome()+"', '"+produto.getImagem()+"', '"+produto.getPreco()+"', '"+produto.getEstoque()+"')";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            stmt.executeUpdate ();
            
            if (cadastrado(produto))
                return true;
            
            return false;
        }
        catch (SQLException erro)
        {
            throw new Exception (erro);
        }   
    }
    
    public boolean incluir (int cod, String nome, String imagem, float preco, int estoque) throws Exception
    {
        try
        {
            String sql;

            sql = "INSERT INTO Produtos VALUES ('"+cod+"','"+nome+"', '"+imagem+"', '"+preco+"', '"+estoque+"')";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            stmt.executeUpdate ();
            
            if (cadastrado(cod))
                return true;
            
            return false;
        }
        catch (SQLException erro)
        {
            throw new Exception (erro);
        }   
    }

    public boolean excluir (int cod) throws Exception
    {
        if (!cadastrado(cod))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "DELETE FROM Produtos WHERE cod='"+cod+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            stmt.executeUpdate (); 
            
            if (cadastrado(cod))
                return false;
            
            return true;
        }
        catch (SQLException erro)
        {
            throw new Exception (erro);
        }
    }

    public boolean alterar (int cod, Produto produto) throws Exception
    {
        if (produto==null)
            throw new Exception ("Produto nao fornecido");

        if (!cadastrado(cod))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "UPDATE Produtos SET cod='"+produto.getCod()+"', nome='"+produto.getNome()+"', imagem='"+produto.getImagem()+"', preco='"+produto.getPreco()+"', estoque='"+produto.getEstoque()+"' WHERE cod='"+cod+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            stmt.executeUpdate ();
            
            if (cadastrado(produto))
                return true;
            
            return false;
        }
        catch (SQLException erro)
        {
            throw new Exception (erro);
        }
    }
    
    public boolean alterar (int cod, String nome, String imagem, float preco, int estoque) throws Exception
    {
        if (!cadastrado(cod))
            throw new Exception ("Livro nao cadastrado");

        try
        {
            String sql;

            sql = "UPDATE Produtos SET cod='"+cod+"', nome='"+nome+"', imagem='"+imagem+"', preco='"+preco+"', estoque='"+estoque+"' WHERE cod='"+cod+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            stmt.executeUpdate ();
            
            if (cadastrado(cod))
                return true;
            
            return false;
        }
        catch (SQLException erro)
        {
            throw new Exception (erro);
        }   
    }
    

  /*  public Produto getProduto(int cod) throws Exception
    {
        Produto produto = null;

        try
        {
            String sql;

            sql = "SELECT * FROM Produtos WHERE cod ='"+cod+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            ResultSet resultado = (ResultSet) stmt.executeQuery();

            if (!resultado.next())
                throw new Exception ("Nao cadastrado");

            produto = new Produto(resultado.getInt("cod"), resultado.getString("nome"), resultado.getString("imagem"),
                                  resultado.getFloat("preco"), resultado.getInt("estoque"));
        }
        catch (SQLException erro)
        {
            throw new Exception (erro);
        }

        return produto;
    } */
    
    public Produto getProduto(String codigo) throws Exception
    {
        Produto produto = null;
        int cod = Integer.parseInt(codigo);

        try
        {
            String sql;

            sql = "SELECT * FROM Produtos WHERE cod ='"+cod+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            ResultSet resultado = (ResultSet) stmt.executeQuery();

            if (!resultado.next())
                throw new Exception ("Nao cadastrado");

            produto = new Produto(resultado.getInt("cod"), resultado.getString("nome"), resultado.getString("imagem"),
                                  resultado.getFloat("preco"), resultado.getInt("estoque"));
        }
        catch (SQLException erro)
        {
            throw new Exception (erro);
        }

        return produto;
    }
    
  /*  public Produto getProduto (String parteNome) throws Exception
    {
        Produto produto = null;

        try
        {
            String sql;

            sql = "SELECT * FROM Produtos WHERE nome like '"+parteNome+"'%''";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            ResultSet resultado = (ResultSet) stmt.executeQuery();

            if (!resultado.next())
                throw new Exception ("Nao cadastrado");

            produto = new Produto(resultado.getInt("cod"), resultado.getString("nome"), resultado.getString("imagem"),
                                  resultado.getFloat("preco"), resultado.getInt("estoque"));
        }
        catch (SQLException erro)
        {
            throw new Exception (erro);
        }

        return produto;
    } */

    public ArrayList<Produto> getProdutos () throws Exception
    {
        ArrayList<Produto> lista = new ArrayList<>();

        try
        {
            String sql;

            sql = "SELECT * FROM Produtos";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            ResultSet resultado = (ResultSet) stmt.executeQuery();

            
            while (resultado.next()){
                Produto linha = new Produto();
                linha.setCod(resultado.getInt(1));
                linha.setNome(resultado.getString(2));
                linha.setImagem(resultado.getString(3));
                linha.setPreco(resultado.getFloat(4));
                linha.setEstoque(resultado.getInt(5));
                lista.add(linha);
            }           
        }
        catch (SQLException erro)
        {
            throw new Exception (erro);
        }

        return lista;
    }
}

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
public class Compras {
     public boolean cadastrado(int numero) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * FROM Compras WHERE numero='"+numero+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            ResultSet resultado = (ResultSet) stmt.executeQuery();

            retorno = resultado.first();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar compra");
        }

        return retorno;
    }
    
    public boolean cadastrado(Compra compra) throws Exception
    {
    	boolean retorno = false;
    	
    	try
    	{
            String sql;
            sql = "SELECT * FROM Compras WHERE id='"+compra.getNumero()+"'";
            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            ResultSet resultado = (ResultSet) stmt.executeQuery();
            
            retorno = resultado.first();
    	}
    	catch(SQLException erro)
    	{
    		throw new Exception ("Erro ao procurar compra");
    	}
    	
    	return retorno;
    }
    

    public boolean incluir (Compra compra) throws Exception
    {
        if (compra==null)
            throw new Exception ("Compra nao fornecida");

        try
        {
            String sql;

            sql = "INSERT INTO Compras VALUES ('"+compra.getNumero()+"','"+compra.getId()+"', '"+compra.getCartao()+"', '"+compra.getEstado()+"')";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            stmt.executeUpdate ();
            
            if (cadastrado(compra))
                return true;
            
            return false;
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir compra");
        }   
    }

    public boolean excluir (int numero) throws Exception
    {
        if (!cadastrado(numero))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "DELETE FROM Compras WHERE numero='"+numero+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            stmt.executeUpdate ();
            
            if (cadastrado(numero))
                return false;
            
            return true;
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao excluir Compra");
        }
    }

    public boolean alterar (int numero, Compra compra) throws Exception
    {
        if (compra==null)
            throw new Exception ("Compra nao fornecido");

        if (!cadastrado(numero))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "UPDATE Compras SET numero='"+compra.getNumero()+"', id='"+compra.getId()+"', cartao='"+compra.getCartao()+"', estado='"+compra.getEstado()+"' WHERE numero='"+numero+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            stmt.executeUpdate ();
            
            if (cadastrado(compra))
                return true;
            
            return false;
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados de compra");
        }
    }
    

    public Compra getCompra (int numero) throws Exception
    {
        Compra compra = null;

        try
        {
            String sql;

            sql = "SELECT * FROM Compras WHERE numero ='"+numero+"'";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            ResultSet resultado = (ResultSet) stmt.executeQuery();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            compra = new Compra(resultado.getInt("numero"), resultado.getInt("Id"), 
                                resultado.getString("cartao"), resultado.getInt("estado"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar usuario");
        }

        return compra;
    }

    public List getCompras () throws Exception
    {
        List<Compra> lista = null;

        try
        {
            String sql;

            sql = "SELECT * FROM Compras";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);
            ResultSet resultado = (ResultSet) stmt.executeQuery();
            
            if (resultado.first()){
                Compra linha = new Compra();
                linha.setNumero(resultado.getInt(1));
                linha.setId(resultado.getInt(2));
                linha.setCartao(resultado.getString(2));
                linha.setEstado(resultado.getInt(2));
                lista.add(linha);
                
                while (resultado.next()){
                   linha.setNumero(resultado.getInt(1));
                   linha.setId(resultado.getInt(2));
                   linha.setCartao(resultado.getString(2));
                   linha.setEstado(resultado.getInt(2));
                   lista.add(linha);
                }
            }
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar compras");
        }

        return lista;
    }
}

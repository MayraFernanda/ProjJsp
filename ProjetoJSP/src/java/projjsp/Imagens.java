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
public class Imagens {
    
    public boolean incluir (String img ) throws Exception
    {
        if (img==null)
            throw new Exception ("imagem não fornecido.");

        try
        {
            String sql;

            sql = "INSERT INTO Imagem VALUES ('"+img+"')";

            PreparedStatement stmt = DAOs.getBD().prepareStatement (sql);

            stmt.executeUpdate();
            
            return false;
        }
        catch (SQLException erro)
        {
            throw new Exception (erro);
        }   
    }  
}

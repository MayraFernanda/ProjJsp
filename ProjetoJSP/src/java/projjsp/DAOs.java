/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projjsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author u14189
 */
public class DAOs {
    
    private static Connection bd;

    private static Administradores administradores;
    private static Clientes clientes;
    private static Compras compras;
    private static Produtos produtos;
        
    static
    {
        try
        {            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance(); //Instanciação
            bd = DriverManager.getConnection("jdbc:sqlserver://regulus:1433;databasename=BD14189", "BD14189", "BD14189");

            DAOs.administradores = new Administradores();
            DAOs.clientes = new Clientes();
            DAOs.compras = new Compras();
            DAOs.produtos = new Produtos();
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException erro)
        {
            System.err.println ("Problemas de conexao com o BD");
            erro.printStackTrace(System.err);
            System.exit(0); // aborta o programa
        }
    }

    public static Connection getBD ()
    {
        return DAOs.bd;
    }

    public static Administradores getAdministradores ()
    {
        return DAOs.administradores;
    }
    
    public static Clientes getClientes ()
    {
        return DAOs.clientes;
    }
    
     public static Compras getCompras ()
    {
        return DAOs.compras;
    }
     
      public static Produtos getProdutos ()
    {
        return DAOs.produtos;
    }
    
    
}

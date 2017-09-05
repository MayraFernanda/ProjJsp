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
public class ProjJSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
      
        
        
        
      
        
    /*    Administradores adms = new Administradores();
        
        if(adms.senhaCorreta("admin", "nimda"))
            System.out.println("esta cadastrado");
        else
            System.out.println("não está cadastrado");
       */ 
      
      Cliente cliente = new Cliente(1, "Ana","endereço","32323232","email@gmail","senhaAna");
        
      Clientes clientes = new Clientes();
      Compras compras = new Compras();
        
        if(compras.cadastrado(2))
            System.out.println("esta cadastrado");
        else
            System.out.println("não está cadastrado");
    
    }
    
}

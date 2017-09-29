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
public class Imagem {
    private String base64;

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public Imagem(String base64) {
        this.base64 = base64;
    }

    @Override
    public String toString() {
        return "Imagem{" + "base64=" + base64 + '}';
    }
    
    
}

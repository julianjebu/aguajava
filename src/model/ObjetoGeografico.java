package model;



/**
 *
 *@author Julian Esteban Bonolis Urrego NRC 1991
 */
public class ObjetoGeografico {
    
    private String nombre_cuerpo;
    private int numero_id;
    private String nombre_municipio;

    public ObjetoGeografico(String nombre_cuerpo, int numero_id, String nombre_municipio) {
        this.nombre_cuerpo = nombre_cuerpo;
        this.numero_id = numero_id;
        this.nombre_municipio = nombre_municipio;
    }
   
    
    public String getNombre_cuerpo() {
        return nombre_cuerpo;
    }

    public int getNumero_id() {
        return numero_id;
    }

    public String getNombre_municipio() {
        return nombre_municipio;
    }

   

    
    
    
}

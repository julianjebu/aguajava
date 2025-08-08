package model;

import connection.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

  
/**
 *
 * @@author Julian Esteban Bonolis Urrego NRC 1991
 */
public class CuerpoDeAgua extends ObjetoGeografico{
    private String tipo_cuerpo_agua;
    private String tipo_de_agua;
    private float Irca;

    public CuerpoDeAgua(String nombre_cuerpo,int numero_id,String nombre_municipio,String tipo_cuerpo_agua, String tipo_de_agua, float irca   ) {
        super(nombre_cuerpo, numero_id, nombre_municipio);
        this.tipo_cuerpo_agua = tipo_cuerpo_agua;
        this.tipo_de_agua = tipo_de_agua;
        this.Irca = irca;
    }
   
     
    
         public  String  nivel( ){
        String nivel = "";
      
        if( this.Irca > 80 &&  this.Irca <=100){
            nivel  = "INVIABLE SANITARIAMENTE";
        }else if( this.Irca > 35 &&  this.Irca <=80){
            nivel = "ALTO";
        }else if( this.Irca > 14 &&  this.Irca <=35){
            nivel = "MEDIO";
            
        }else if( this.Irca > 5 && this.Irca <=14){
            nivel = "BAJO";
       
        }else if( this.Irca >= 0 &&  this.Irca <=5){
            nivel = "SIN RIESGO";
          
        }else{
            nivel = "";
        }
            
         return nivel;
    }

   

    public float getIrca() {
        return Irca;
    }
     
     
  
    
 
 }


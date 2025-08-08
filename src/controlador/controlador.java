
package controlador;

import connection.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CuerpoDeAgua;

/**
 *
 * @author RYZEN
 */
public class controlador {
     ArrayList <CuerpoDeAgua> niveles = new ArrayList();
     
     
       
    public static String cuerpo_DeAgua(String nombre, int id, String municipio, String cuerpo,String tipoCuerpo, float Irca) {
        String sql = "INSERT INTO datos (id,Nombre, municipio, TipoCuerpoAgua,TipoAgua,Irca) VALUES(" + id +","+"'"+nombre+"'"+ ","+"'"+municipio+"'"+","
        + "'"+cuerpo+"'"+","+"'"+tipoCuerpo+"'"+","+Irca+");";
                
        String result = "";

        try (Connection conn = Connect.Connet(); Statement stmt = conn.createStatement()) {
            int rs = stmt.executeUpdate(sql);
            stmt.close();
            if (rs == 1) {
                result = "cuerpo de agua creado ";
            } else {
                result = "cueropo de agua no ha podido ser creado.";
            }
        } catch (SQLException e) {
            result = e.getMessage();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return result;
    }
    
    public String []obtenerdatos(int id){
        String Datos[] = new String[6];
         try {
             String query = "SELECT * from datos where id=" + id; 
            Connection conn = Connect.Connet(); Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            
            Datos[0] =  resultSet.getString(1);
            Datos[1] = resultSet.getString(2);
            Datos[2] = resultSet.getString(3);
            Datos[3] = resultSet.getString(4);
            Datos[4] = resultSet.getString(5);
            Datos[5] = resultSet.getString(6);
            stmt.close();
         } catch (SQLException ex) {
             Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return Datos;
    }
    
    public  String eliminardatos(int id)  {
        String sql = "DELETE from datos " + " WHERE id = " + id +";";
        String result = "";
        try (Connection conn = Connect.Connet(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            stmt.close();
            if (rs.next()) {
                result = "cuerpo eliminado satisfactoriamente";
            } else {
                result = "cuerpo no fue eliminado";
            }
        } catch (SQLException e) {
            result = e.getMessage();
           // System.err.println(e.getClass().getName() + ": " + e.getMessage()+"errrorr");
        }
        return result;
    }
      
    
    
    public void llenarArray() throws SQLException{
        
        niveles.clear();
        String Query_Consultar = "SELECT * FROM CuerpoDeAgua;";
        Connection conn = Connect.Connet();
        String sentencia =  "SELECT id,Nombre,municipio,TipoCuerpoAgua,TipoAgua,Irca "
                           + "FROM datos";
      
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sentencia);
        while(rs.next()){
        CuerpoDeAgua cuerpoagua = new CuerpoDeAgua(rs.getString("nombre"),Integer.parseInt(rs.getString("id")),rs.getString("municipio")
          ,rs.getString("TipoCuerpoAgua"),rs.getString("TipoAgua"),Float.parseFloat(rs.getString("Irca"))); // se crea el nuevo cuerpo 
        
        niveles.add(cuerpoagua); // y mandos los objetos a un array
       }
    
    
    }
    
    public String NivelesCuerpos(){
        
        String riesgo = "";
        for (int i = 0; i < niveles.size(); i++) { 
            riesgo += niveles.get(i).nivel() + "\n"; 
            
        }
     return riesgo;
    }
    
    public String totalmedios(){
     
     /*String totalmedios = "";
       totalmedios = String.valueOf(CuerpoDeAgua.getNivel_medio() +"\n");
     return totalmedios ;*/
     
      String menores;
        int contador = 0;
        for (int i = 0; i < niveles.size(); i++) {
            if(niveles.get(i).getIrca() >= 0 && niveles.get(i).getIrca() <= 35){
                contador++;
            }
        
        }
        menores = contador + "\n";
        return menores;
    }
    
    public String nombresmedios(){
        String nombresmedios = "";
        for (int i = 0; i <niveles.size(); i++) {
            if("MEDIO".equals(niveles.get(i).nivel())){
                nombresmedios += niveles.get(i).getNombre_cuerpo() + "\n";
            }
        }
        
        
        return nombresmedios;
    }
    
    public String menormedio(){
        String cadena = "";
        float menor = 9999;
        String nombre = "";
        String codigo = "";
      
        for (int i = 0; i < niveles.size(); i++) {
            if (menor > niveles.get(i).getIrca()){     
                menor = niveles.get(i).getIrca();   
                nombre = niveles.get(i).getNombre_cuerpo();
                codigo = String.valueOf(niveles.get(i).getNumero_id());
                
                cadena = nombre+" "+codigo; 
             }
        }
        return cadena ;
    }
    
      public String actualizarCuerpo(String nombre, int numero, String municipio,float IRCA,String tipoCuerpo,String tipoAgua){
        String sql = "UPDATE datos SET  nombre = '" + nombre + "', municipio = '" + municipio + "'," + "tipoCuerpoAgua = '" + tipoCuerpo+"', tipoAgua = '" +tipoAgua+"'"
                + " WHERE id = " + numero+ ";";
        String result = "";

        try (Connection conn = Connect.Connet(); Statement stmt = conn.createStatement()) {
            int rs = stmt.executeUpdate(sql);
            stmt.close();
            if (rs == 1) {
                result = "cuerpo de agua actualizado";
            }
        } catch (SQLException e) {
            result = e.getMessage();
            System.err.println(e.getMessage());
        }
        return result;
    
    }
   
    
    

   
    
}

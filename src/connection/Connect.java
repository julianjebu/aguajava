
package connection;

 import java.nio.file.Path;
 import java.nio.file.Paths;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.SQLException;
/**
 *
 * @author Julian Esteban Bonolis Urrego NRC 1991
 */
public class Connect {
    
        public static Connection Connet(){
        
    String sjdbc = "jdbc:sqlite";

    Path path =  Paths.get("src/Connection/datos.db");
    
    String url = sjdbc + ":\\"+path.toAbsolutePath();
    //String url = sjdbc;
    
        Connection conn = null;
      
    
        try {
            conn = DriverManager.getConnection(url);
        
            System.out.println("estoy dentro");
        } catch (SQLException e ) {
            
            System.out.println(e.getMessage());
        }
        
        return conn;
      
    
    }

   
}

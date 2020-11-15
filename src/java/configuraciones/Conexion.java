
package configuraciones;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author DELL
 */
public class Conexion {
    Connection con = null;

    String url="jdbc:mysql://127.0.0.1:3306/mydb?serverTimezone=UTC";
    String user="root";
    String pass="12345";
//        String url="jdbc:mysql://localhost/mydb?serverTimezone=UTC";
//      String user="root";
//      String pass=".123_P45sW0rd";
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        } catch (Exception e){
        }
        return con;
    }
 
}



package Utils;
import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlDBConexion 
{
    public static Connection getConexion()
    {
        Connection cn = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/marketplace","root","");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return cn;
    }
}
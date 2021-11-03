package livraria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoMysql {

    public static Connection conectaBanco(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/db_livraria?" + "user=root&password=demo");

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro ao conectar no banco de dados!", ex);
            
        }
    }    
}

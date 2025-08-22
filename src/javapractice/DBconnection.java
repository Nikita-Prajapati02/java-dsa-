package javapractice;

import com.sun.jdi.connect.spi.Connection;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static Connection conn;
    public static void openConnection(String dbUrl,String username,String password){
        try {

            conn= (Connection) DriverManager.getConnection(dbUrl,username,password);
            System.out.println("Connected Successfully To The Database");
        }catch(SQLException ex) {
            System.out.println("Can Not Open Connectiopn In DBConnection");
            ex.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException{
        if(conn==null) {
            throw new SQLException("Connection Not Open");
        }
        return conn;
    }
    public static void closeConnection() {
        if(conn!=null) {
            try {
                conn.close();
                System.out.println("Connection Close Successfully!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

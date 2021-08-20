package Model;

import java.sql.*;

public class ConnectPostgre {
    private static Connection con = null;

    static final String DB_URL = "jdbc:postgresql://localhost:5432/NewTest";
    static final String USER = "postgres";
    static final String PASS = "passgre";

    public static Connection ConnectDatabase(){
       try{
           if(con == null){
               con = DriverManager.getConnection(DB_URL, USER, PASS);
           }
           return con;
       } catch (Exception e){
           System.out.println(e.getMessage());
           System.out.println(e.getStackTrace());
           return null;
       }

    }
}

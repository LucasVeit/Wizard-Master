package Model.DAO;

import Model.ConnectPostgre;

import java.sql.Connection;

public class QueriesDAO {
    private static Connection con = ConnectPostgre.ConnectDatabase();

}

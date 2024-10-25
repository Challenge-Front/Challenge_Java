package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBConnectionImpl implements DBConnection{
    private static DBConnectionImpl dbConnection;

    private static Connection connection;

    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private DBConnectionImpl() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(
                    DBConfig.getUrl(),
                    DBConfig.getUser(),
                    DBConfig.getPassword()
            );
        } catch (ClassNotFoundException e) {
            logger.severe("não foi localizada a classe Driver do Oracle");
        }

    }

    public static synchronized DBConnectionImpl getInstance() throws SQLException {
        if(dbConnection == null || connection.isClosed()){
            dbConnection = new DBConnectionImpl();
        }
        return dbConnection;
    }


    @Override
    public Connection get() throws SQLException {
        return null;
    }
}

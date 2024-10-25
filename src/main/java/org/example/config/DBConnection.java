package org.example.config;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnection {
    Connection get() throws SQLException;
}

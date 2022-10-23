package com.employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import utils.WithProperties;

public class DatabaseConnection extends WithProperties {

  private static Connection conn;
  
  private DatabaseConnection() {}
  public static Connection getInstance() throws IOException, SQLException {
    if (conn == null) {
      conn =
        DriverManager.getConnection(
          p.getProperty("url"),
          p.getProperty("username"),
          p.getProperty("password")
        );
      return conn;
    }
    return conn;
  }
}

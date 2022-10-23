package com.employee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

  private static Connection conn;
  private static Properties props = new Properties();

  public static Connection getInstance() throws IOException, SQLException {
    props.load(
      DatabaseConnection.class.getResourceAsStream(
          "../config/config.properties"
        )
    );

    if (conn == null) {
      conn =
        DriverManager.getConnection(
          props.getProperty("url"),
          props.getProperty("username"),
          props.getProperty("password")
        );
      return conn;
    }

    return conn;
  }
}

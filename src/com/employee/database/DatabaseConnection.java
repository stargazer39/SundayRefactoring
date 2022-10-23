package com.employee.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.employee.common.Constants.Props;
import com.employee.service.EmployeeService;

import utils.WithProperties;

public class DatabaseConnection extends WithProperties {

  private static Connection conn;
  public static final Logger log = Logger.getLogger(DatabaseConnection.class.getName());
  
  private DatabaseConnection() {}
  public static Connection getInstance() throws IOException, SQLException {
	// If there's no already existing connection, connect first.
    if (conn == null) {
      conn =
        DriverManager.getConnection(
          p.getProperty(Props.DB_URL),
          p.getProperty(Props.DB_USERNAME),
          p.getProperty(Props.DB_PASSWORD)
        );
      return conn;
    }
    return conn;
  }
  
  public static void closeConnection() {
	  if(conn == null) {
		  log.info("Connection does not exists.");
		  return;
	  }
	  try {
		  conn.close();
	  }catch(Exception e) {
		  log.warning( e.getMessage());
	  }
  }
}

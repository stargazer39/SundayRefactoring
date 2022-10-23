package com.employee.database;

import com.employee.common.Constants;
import com.employee.common.Constants.Props;
import com.employee.service.EmployeeService;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.WithProperties;

/**
 * This class is use to connect to the database,
 * Uses singleton design pattern
 * 
 */
public class DatabaseConnection extends WithProperties {

  private static Connection conn;
  public static final Logger log = Logger.getLogger(
    DatabaseConnection.class.getName()
  );

  private DatabaseConnection() {}

  /**
   * 
   * @return Returns a instance to a database connection.
   * 
   * @throws IOException
   * @throws SQLException
   * @throws ClassNotFoundException 
   */
  public static Connection getInstance() throws IOException, SQLException, ClassNotFoundException {
    // If there's no already existing connection, connect first.
    if (conn == null) {
      Class.forName(p.getProperty(Constants.Props.DB_DRIVER));
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
  
  /**
   * Closes the database connection to the database
   */
  public static void closeConnection() {
    if (conn == null) {
      log.info("Connection does not exists.");
      return;
    }
    try {
      conn.close();
    } catch (Exception e) {
      log.warning(e.getMessage());
    }
  }
}

package com.employee.main;

import com.employee.database.DatabaseConnection;
import com.employee.service.EmployeeService;
import com.employee.utils.XMLQueryUtil;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

public class MainClass {

  public static final Logger log = Logger.getLogger(MainClass.class.getName());

  /**
   * This is the main entry for the app
   */
  public static void main(String[] args) {
	// Instantiate the EmployeeService
    EmployeeService controller = new EmployeeService();

    try {
      XMLQueryUtil.requestTransform();
      controller.displayEmployees();
      controller.createEmployeeTable();
      controller.saveEmployeesToDb();
      controller.displayEmployee();
      
      // Close the database connection since there's no use after this.
      DatabaseConnection.closeConnection();
    } catch (SQLException e) {
      log.log(
        Level.SEVERE,
        "Error occurred when saving to database - \n" + e.getMessage()
      );
    } catch (Exception e) {
      log.log(Level.SEVERE, e.getMessage());
    }
  }
}

package com.employee.main;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import com.employee.database.DatabaseConnection;
import com.employee.service.EmployeeService;
import com.employee.utils.XMLQueryUtil;

public class MainClass {
  public static final Logger log = Logger.getLogger(MainClass.class.getName());
  /**
   * @param args
   */
  public static void main(String[] args) {
    EmployeeService controller = new EmployeeService();
    
    try {
      XMLQueryUtil.requestTransform();
      controller.displayEmployees();
      controller.updateEmployees();
      controller.saveEmployeesToDb();
      controller.displayEmployee();
      
      DatabaseConnection.closeConnection();
    } catch (SQLException e) {
    	log.log(Level.SEVERE, "Error occurred when saving to database - \n" + e.getMessage());
    } catch (Exception e) {
    	log.log(Level.SEVERE, e.getMessage());
    }
  }
}

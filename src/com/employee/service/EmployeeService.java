package com.employee.service;

import com.employee.common.Constants;
import com.employee.common.WithProperties;
import com.employee.database.DatabaseConnection;
import com.employee.model.Employee;
import com.employee.utils.EmployeeQueryUtil;
import com.employee.utils.XMLQueryUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

public class EmployeeService extends AbstractService {

  private final ArrayList<Employee> employeeList = new ArrayList<Employee>();

  private static Connection connection;
  public static final Logger log = Logger.getLogger(
    EmployeeService.class.getName()
  );

  private static Statement s;
  private PreparedStatement ps;

  public EmployeeService() {
    try {
      connection = DatabaseConnection.getInstance();
    } catch (IOException e) {
      log.log(Level.SEVERE, "IO Exception Occured - \n" + e.getMessage());
    } catch (SQLTimeoutException e) {
      log.log(
        Level.SEVERE,
        "SQLTimeoutException Occured - \n" + e.getMessage()
      );
    } catch (SQLException e) {
      log.log(Level.SEVERE, "SQLException Occured - \n" + e.getMessage());
    }
  }

  public void displayEmployees() {
    try {
      int s = XMLQueryUtil.xmlPaths().size();
      for (int i = 0; i < s; i++) {
        Map<String, String> employeeMap = XMLQueryUtil.xmlPaths().get(i);
        Employee employee = new Employee();

        employee.setEmployeeId(
          employeeMap.get(Constants.XMLPathKeys.EMPLOYEE_ID)
        );
        employee.setFullName(
          employeeMap.get(Constants.XMLPathKeys.EMPLOYEE_NAME)
        );
        employee.setAddress(
          employeeMap.get(Constants.XMLPathKeys.EMPLOYEE_ADDRESS)
        );
        employee.setfacultyName(
          employeeMap.get(Constants.XMLPathKeys.FACULTY_NAME)
        );
        employee.setDepartment(
          employeeMap.get(Constants.XMLPathKeys.DEPARTMENT)
        );
        employee.setDesignation(
          employeeMap.get(Constants.XMLPathKeys.DESIGNATION)
        );

        employeeList.add(employee);
        System.out.println(employee.toString() + "\n");
      }
    } catch (Exception e) {
      log.log(Level.SEVERE, e.getMessage());
    }
  }

  public void updateEmployees() {
    try {
      s = connection.createStatement();
      s.executeUpdate(EmployeeQueryUtil.getEmployeeById("q2"));
      s.executeUpdate(EmployeeQueryUtil.getEmployeeById("q1"));
    } catch (SQLException e) {
      log.log(
        Level.SEVERE,
        "Error occurred when saving to database - \n" + e.getMessage()
      );
    } catch (Exception e) {
      log.log(Level.SEVERE, e.getMessage());
    }
  }

  public void saveEmployeesToDb() {
    try {
      ps = connection.prepareStatement(EmployeeQueryUtil.getEmployeeById("q3"));
      connection.setAutoCommit(false);
      for (int i = 0; i < employeeList.size(); i++) {
        Employee employee = employeeList.get(i);
        ps.setString(
          Constants.ColumnIndexes.COLUMN_INDEX_ONE,
          employee.getEmployeeId()
        );
        ps.setString(
          Constants.ColumnIndexes.COLUMN_INDEX_TWO,
          employee.getFullName()
        );
        ps.setString(
          Constants.ColumnIndexes.COLUMN_INDEX_THREE,
          employee.getAddress()
        );
        ps.setString(
          Constants.ColumnIndexes.COLUMN_INDEX_FOUR,
          employee.getFacultyName()
        );
        ps.setString(
          Constants.ColumnIndexes.COLUMN_INDEX_FIVE,
          employee.getDepartment()
        );
        ps.setString(
          Constants.ColumnIndexes.COLUMN_INDEX_SIX,
          employee.getDesignation()
        );
        ps.addBatch();
      }
      ps.executeBatch();
      connection.commit();
    } catch (SQLException e) {
      log.log(
        Level.SEVERE,
        "Error occurred when saving to database - \n" + e.getMessage()
      );
    } catch (Exception e) {
      log.log(Level.SEVERE, e.getMessage());
    }
  }

  public void employeeGetById(String eid) {
    Employee employee = new Employee();
    try {
      ps = connection.prepareStatement(EmployeeQueryUtil.getEmployeeById("q4"));
      ps.setString(Constants.ColumnIndexes.COLUMN_INDEX_ONE, eid);
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        employee.setEmployeeId(
          resultSet.getString(Constants.ColumnIndexes.COLUMN_INDEX_ONE)
        );
        employee.setFullName(
          resultSet.getString(Constants.ColumnIndexes.COLUMN_INDEX_TWO)
        );
        employee.setAddress(
          resultSet.getString(Constants.ColumnIndexes.COLUMN_INDEX_THREE)
        );
        employee.setfacultyName(eid);
        employee.setDepartment(
          resultSet.getString(Constants.ColumnIndexes.COLUMN_INDEX_FIVE)
        );
        employee.setDesignation(
          resultSet.getString(Constants.ColumnIndexes.COLUMN_INDEX_SIX)
        );
      }

      ArrayList<Employee> empList = new ArrayList<Employee>();
      empList.add(employee);
      printEmployee(empList);
    } catch (SQLException e) {
      log.log(
        Level.SEVERE,
        "Error occurred when saving to database - \n" + e.getMessage()
      );
    } catch (Exception e) {
      log.log(Level.SEVERE, e.getMessage());
    }
  }

  public void deleteEmployee(String eid) {
    try {
      ps = connection.prepareStatement(EmployeeQueryUtil.getEmployeeById("q6"));
      ps.setString(1, eid);
      ps.executeUpdate();
    } catch (SQLException e) {
      log.log(
        Level.SEVERE,
        "Error occurred when saving to database - \n" + e.getMessage()
      );
    } catch (Exception e) {
      log.log(Level.SEVERE, e.getMessage());
    }
  }

  public void displayEmployee() {
    ArrayList<Employee> employeeList = new ArrayList<Employee>();
    try {
      ps = connection.prepareStatement(EmployeeQueryUtil.getEmployeeById("q5"));
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        Employee employee = new Employee();
        employee.setEmployeeId(
          resultSet.getString(Constants.ColumnIndexes.COLUMN_INDEX_ONE)
        );
        employee.setFullName(
          resultSet.getString(Constants.ColumnIndexes.COLUMN_INDEX_TWO)
        );
        employee.setAddress(
          resultSet.getString(Constants.ColumnIndexes.COLUMN_INDEX_THREE)
        );
        employee.setfacultyName(
          resultSet.getString(Constants.ColumnIndexes.COLUMN_INDEX_FOUR)
        );
        employee.setDepartment(
          resultSet.getString(Constants.ColumnIndexes.COLUMN_INDEX_FIVE)
        );
        employee.setDesignation(
          resultSet.getString(Constants.ColumnIndexes.COLUMN_INDEX_SIX)
        );
        employeeList.add(employee);
      }
      printEmployee(employeeList);
    } catch (SQLException e) {
      log.log(
        Level.SEVERE,
        "Error occurred when saving to database - \n" + e.getMessage()
      );
    } catch (Exception e) {
      log.log(Level.SEVERE, e.getMessage());
    }
  }

  public void printEmployee(ArrayList<Employee> l) {
    System.out.println(
      "Employee ID" +
      "\t\t" +
      "Full Name" +
      "\t\t" +
      "Address" +
      "\t\t" +
      "Faculty Name" +
      "\t\t" +
      "Department" +
      "\t\t" +
      "Designation" +
      "\n"
    );
    System.out.println(
      "================================================================================================================"
    );
    for (int i = 0; i < l.size(); i++) {
      Employee e = l.get(i);
      System.out.println(
        e.getEmployeeId() +
        "\t" +
        e.getFullName() +
        "\t\t" +
        e.getAddress() +
        "\t" +
        e.getFacultyName() +
        "\t" +
        e.getDepartment() +
        "\t" +
        e.getDesignation() +
        "\n"
      );
      System.out.println(
        "----------------------------------------------------------------------------------------------------------------"
      );
    }
  }
}

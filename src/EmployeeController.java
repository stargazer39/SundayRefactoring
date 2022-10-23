import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

import com.employee.DatabaseConnection;

public class EmployeeController extends WithProperties {

  private final ArrayList<Employee> el = new ArrayList<Employee>();

  private static Connection connection;
  public static final Logger log = Logger.getLogger(EmployeeController.class.getName());
  
  private static Statement s;
  private PreparedStatement ps;

  public EmployeeController() {
    try {
      connection = DatabaseConnection.getInstance();
    } catch (IOException e) {
    	log.log(Level.SEVERE, e.getMessage());
    } catch (SQLException e) {
    	log.log(Level.SEVERE, e.getMessage());
    }
  }

  public void a2() {
    try {
      int s = c3.xmlPaths().size();
      for (int i = 0; i < s; i++) {
        Map<String, String> l = c3.xmlPaths().get(i);
        Employee employee = new Employee();

        employee.setEmployeeId(l.get("XpathEmployeeIDKey"));
        employee.setFullName(null);
        employee.setAddress(l.get("XpathEmployeeAddressKey"));
        employee.setfacultyName(l.get("XpathFacultyNameKey"));
        employee.setDepartment(l.get("XpathDepartmentKey"));
        employee.setDesignation(l.get("XpathDesignationKey"));

        el.add(employee);
        System.out.println(employee.toString() + "\n");
      }
    } catch (Exception e) {
    	
    }
  }

  public void a3() {
    try {
      s = connection.createStatement();
      s.executeUpdate(c2.Q("q2"));
      s.executeUpdate(c2.Q("q1"));
    } catch (Exception e) {}
  }

  public void a4() {
    try {
      ps = connection.prepareStatement(c2.Q("q3"));
      connection.setAutoCommit(false);
      for (int i = 0; i < el.size(); i++) {
        Employee e = el.get(i);
        ps.setString(1, e.getEmployeeId());
        ps.setString(2, e.getFullName());
        ps.setString(3, e.getAddress());
        ps.setString(4, e.getFacultyName());
        ps.setString(5, e.getDepartment());
        ps.setString(6, e.getDesignation());
        ps.addBatch();
      }
      ps.executeBatch();
      connection.commit();
    } catch (Exception e) {}
  }

  public void employeeGetById(String eid) {
    Employee e = new Employee();
    try {
      ps = connection.prepareStatement(c2.Q("q4"));
      ps.setString(1, eid);
      ResultSet R = ps.executeQuery();
      while (R.next()) {
        e.setEmployeeId(R.getString(1));
        e.setFullName(R.getString(2));
        e.setAddress(R.getString(3));
        e.setfacultyName(eid);
        e.setDepartment(R.getString(5));
        e.setDesignation(R.getString(6));
      }
      ArrayList<Employee> l = new ArrayList<Employee>();
      l.add(e);
      displayEmployee(l);
    } catch (Exception ex) {}
  }

  public void EMPLOYEEDELETE(String eid) {
    try {
      ps = connection.prepareStatement(c2.Q("q6"));
      ps.setString(1, eid);
      ps.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void a5() {
    ArrayList<Employee> l = new ArrayList<Employee>();
    try {
      ps = connection.prepareStatement(c2.Q("q5"));
      ResultSet r = ps.executeQuery();
      while (r.next()) {
        Employee e = new Employee();
        e.setEmployeeId(r.getString(1));
        e.setFullName(r.getString(2));
        e.setAddress(r.getString(3));
        e.setfacultyName(r.getString(4));
        e.setDepartment(r.getString(5));
        e.setDesignation(r.getString(6));
        l.add(e);
      }
    } catch (Exception e) {
    	
    }
    displayEmployee(l);
  }

  public void displayEmployee(ArrayList<Employee> l) {
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

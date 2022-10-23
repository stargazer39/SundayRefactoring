import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

public class MainClass {

  /**
   * @param args
   */
  public static void main(String[] args) {
	System.out.println("Hello");
    EmployeeController a1 = new EmployeeController();
    try {
      c3.requestTransform();
      a1.displayEmployees();
      a1.updateEmployees();
      a1.saveEmployeesToDb();
      //			employeeService.eMPLOYEEGETBYID("EMP10004");
      //			employeeService.EMPLOYEEDELETE("EMP10001");
      a1.a5();
    } catch (Exception e) {}
  }
}

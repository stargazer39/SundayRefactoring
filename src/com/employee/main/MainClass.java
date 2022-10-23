package com.employee.main;


import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import com.employee.EmployeeController;
import com.employee.XMLQueryUtil;

public class MainClass {

  /**
   * @param args
   */
  public static void main(String[] args) {
	System.out.println("Hello");
    EmployeeController controller = new EmployeeController();
    try {
      XMLQueryUtil.requestTransform();
      controller.displayEmployees();
      controller.updateEmployees();
      controller.saveEmployeesToDb();
      controller.displayEmployee();
      
    } catch (Exception e) {
    	
    }
  }
}

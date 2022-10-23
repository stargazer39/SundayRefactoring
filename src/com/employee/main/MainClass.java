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
    EmployeeController a1 = new EmployeeController();
    try {
      XMLQueryUtil.requestTransform();
      a1.displayEmployees();
      a1.updateEmployees();
      a1.saveEmployeesToDb();
      a1.displayEmployee();
      
    } catch (Exception e) {
    	
    }
  }
}

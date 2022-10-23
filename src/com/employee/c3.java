package com.employee;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.employee.common.Constants;

public class c3 extends WithProperties {

  private static final ArrayList<Map<String, String>> l = new ArrayList<Map<String, String>>();

  private static Map<String, String> employeeMap = null;

  public static void requestTransform() throws Exception {
    Source x = new StreamSource(new File("src/e/EmployeeRequest.xml"));
    Source s = new StreamSource(new File("src/e/Employee-modified.xsl"));
	Result o = new StreamResult(new File("src/e/EmployeeResponse.xml"));
    TransformerFactory.newInstance().newTransformer(s).transform(x, o);
  }

  public static ArrayList<Map<String, String>> xmlPaths() throws Exception {
    Document d = DocumentBuilderFactory
      .newInstance()
      .newDocumentBuilder()
      .parse("src/e/EmployeeResponse.xml");
    
    XPath x = XPathFactory.newInstance().newXPath();
    
    int n = Integer.parseInt(
      (String) x
        .compile("count(" + Constants.XMLQueryCommon.EMPLOYEE_QUERY  +")")
        .evaluate(d, XPathConstants.STRING)
    );
    
    for (int i = 1; i <= n; i++) {
        employeeMap = new HashMap<String, String>();
        employeeMap.put(
      		  Constants.XMLPathKeys.EMPLOYEE_ID,
          (String) x
            .compile(Constants.XMLQueryCommon.EMPLOYEE_QUERY+"[" + i + "]/" + Constants.XMLEmployeeTagNames.EMPLOYEE_ID + "/text()")
            .evaluate(d, XPathConstants.STRING)
        );
        employeeMap.put(
          Constants.XMLPathKeys.EMPLOYEE_NAME,
          (String) x
            .compile(Constants.XMLQueryCommon.EMPLOYEE_QUERY +"[" + i + "]/"+ Constants.XMLEmployeeTagNames.EMPLOYEE_NAME +"/text()")
            .evaluate(d, XPathConstants.STRING)
        );
        employeeMap.put(
      		  Constants.XMLPathKeys.EMPLOYEE_ADDRESS,
          (String) x
            .compile(Constants.XMLQueryCommon.EMPLOYEE_QUERY +"[" + i + "]/" + Constants.XMLEmployeeTagNames.EMPLOYEE_ADDRESS + "/text()")
            .evaluate(d, XPathConstants.STRING)
        );
        employeeMap.put(
      		  Constants.XMLPathKeys.FACULTY_NAME,
          (String) x
            .compile(Constants.XMLQueryCommon.EMPLOYEE_QUERY +"[" + i + "]/" + Constants.XMLEmployeeTagNames.FACULTY_NAME + "/text()")
            .evaluate(d, XPathConstants.STRING)
        );
        employeeMap.put(
      		  Constants.XMLPathKeys.DEPARTMENT,
          (String) x
            .compile(Constants.XMLQueryCommon.EMPLOYEE_QUERY +"[" + i + "]/" + Constants.XMLEmployeeTagNames.DEPARTMENT + "/text()")
            .evaluate(d, XPathConstants.STRING)
        );
        employeeMap.put(
      		  Constants.XMLPathKeys.DESIGNATION,
          (String) x
            .compile(Constants.XMLQueryCommon.EMPLOYEE_QUERY +"[" + i + "]/" + Constants.XMLEmployeeTagNames.DESIGNATION + "/text()")
            .evaluate(d, XPathConstants.STRING)
        );
        l.add(employeeMap);
      }
      return l;
    }
}

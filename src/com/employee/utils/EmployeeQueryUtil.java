package com.employee.utils;

import com.employee.common.Constants;
import com.employee.common.WithProperties;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EmployeeQueryUtil extends WithProperties {

  public static String queryById(String id) throws Exception {
    NodeList nodeList;
    Element element = null;
    nodeList =
      DocumentBuilderFactory
        .newInstance()
        .newDocumentBuilder()
        .parse(new File(Constants.Config.EMPLOYEE_QUERY_XML_PATH))
        .getElementsByTagName("query");

    for (int x = 0; x < nodeList.getLength(); x++) {
      element = (Element) nodeList.item(x);
      if (element.getAttribute("id").equals(id)) break;
    }
    return element.getTextContent().trim();
  }
}

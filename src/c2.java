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

public class c2 extends WithProperties {

  public static String Q(String id) throws Exception {
    NodeList n;
    Element e = null;
    n =
      DocumentBuilderFactory
        .newInstance()
        .newDocumentBuilder()
        .parse(new File("src/e/EmployeeQuery.xml"))
        .getElementsByTagName("query");
    
    for (int x = 0; x < n.getLength(); x++) {
      e = (Element) n.item(x);
      if (e.getAttribute("id").equals(id)) break;
    }
    return e.getTextContent().trim();
  }
}

package XML;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Dom4jTest {
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document dom = reader.read("books.xml");
        Element root = dom.getRootElement();
        List<Element> elements = root.elements();

        for (Element element : elements) {
            System.out.println(element.getName());
            System.out.println("\tid = "+element.attributeValue("id"));
            List<Element> es1 = element.elements();
            for (Element et1 : es1) {
                System.out.println("\t"+et1.getName()+"="+et1.getText());
            }
            System.out.println("---------------------------------------");
        }
    }
}

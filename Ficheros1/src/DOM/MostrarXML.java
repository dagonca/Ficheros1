package DOM;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MostrarXML {
	public static void main(String[] args) {
		try{
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder= factory.newDocumentBuilder();
		Document document = builder.parse(new File("C:\\Users\\21438581\\workspace\\Alumno.xml"));
		NodeList empleados = document .getElementsByTagName("alumno");
		for(int i=0;i<empleados.getLength();i++){
			Node emp = empleados.item(i);
			if(emp.getNodeType()==Node.ELEMENT_NODE){
				Element elemento=(Element) emp;
				System.out.print("COD: "+getNodo("codigo",elemento));
				System.out.println("\t Nombre: "+getNodo("nombre",elemento));
				System.out.println("\t Media: "+getNodo("media",elemento));
				
			}
		}
		
		}catch(Exception e){System.out.println(e);}
	}

	private static String getNodo(String etiqueta, Element elem) {
		// TODO Auto-generated method stub
		NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
		Node valor =(Node) nodo.item(0);
		return valor.getNodeValue() ;
	}
}

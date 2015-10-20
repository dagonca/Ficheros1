package XML;

import java.io.*;

import javax.xml.parsers.*;


import org.w3c.dom.*;

public class LeerFichero {

	public static void main(String[] args) {
		try{
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder= factory.newDocumentBuilder();
		Document document = builder.parse(new File("C:\\Users\\21438581\\workspace\\Empleados.xml"));
		NodeList empleados = document .getElementsByTagName("empleado");
		for(int i=0;i<empleados.getLength();i++){
			Node emp = empleados.item(i);
			if(emp.getNodeType()==Node.ELEMENT_NODE){
				Element elemento=(Element) emp;
				System.out.print("ID: "+getNodo("id",elemento));
				System.out.print("\t Nombre: "+getNodo("nombre",elemento));
				System.out.print("\t Departamento: "+getNodo("dep",elemento));
				System.out.println("\t Salario: "+getNodo("salario",elemento));
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

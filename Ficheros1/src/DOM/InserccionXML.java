package DOM;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


//Librerías DOMEO, parseadores y transformers.
import org.w3c.dom.*;

import XML.Empleado;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
public class InserccionXML {

	public static void main(String[] args) 
	{
		//Datos .dat
		int id[]={1,2,3};
		String nombres[] = {"Pepe1","Pepe2","Pepe3","Pepe4","Pepe5","Pepe6","Pepe7","Pepe8"};
		int cod[] = {1,2,3,4,5,6,7,8};
		double media[]={7.5,1.0,1.5,5.2,8.2,5.6,9.5,10.0};
		Alumno al=null;
		
		//Streams y fichero
		String nombreFichero="C:\\Users\\21438581\\workspace\\Alumno.dat";
		File f = new File("C:\\Users\\21438581\\workspace\\Alumno.dat");
		
	
		FileOutputStream fos =null;
		ObjectOutputStream oos = null;
		
		//Rellenado
		try{
			fos = new FileOutputStream(nombreFichero);
			oos = new ObjectOutputStream(fos);
			
			
			for(int i =0 ; i<cod.length; i++){
				al = new Alumno(cod[i],nombres[i],media[i]);
				oos.writeObject(al);
				System.out.println("alumno " + al.getNombre() + " guardado");
			}
		}catch(IOException ioe){
			ioe.getMessage();
		}finally{
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//Lectura
		try
		{
			FileInputStream fis= new FileInputStream(nombreFichero);
			ObjectInputStream ois= new ObjectInputStream(fis);	
			//DOMEO
			DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation= builder.getDOMImplementation();
			Document document = implementation.createDocument(null, "Alumno",null); // "Alumno: Nodo padre"
			//4 líneas replicadas en uso de DOM.
			document.setXmlVersion("1.0"); //asignamos la version de nuestro XML

			
			try
			{
				while(true)
				{
					al=(Alumno) ois.readObject();
					//crea nodo hijo
					Element raiz = document.createElement("alumno"); 
					document.getDocumentElement().appendChild(raiz); 
					//rellena de elementos el nodo hijo
					//Nombre nodo, valor, a que nodo, en que documento.
					CrearElemento("codigo",Integer.toString(al.getCod()),raiz,document); 
					CrearElemento("nombre",al.getNombre(),raiz, document);
					CrearElemento("media",Double.toString(al.getMedia()), raiz, document);


				}	
			}catch(EOFException eofe){
				Source source = new DOMSource(document);
				Result result = new StreamResult(new java.io.File("C:\\Users\\21438581\\workspace\\Alumno.xml"));
				Transformer transformer = 
						TransformerFactory.newInstance().newTransformer();
				//da por finalizado el DOM
				transformer.transform(source,  result);
				

				ois.close();
			} 
		}catch (Exception e) {
			System.out.println(e);
		}
		
	
		
			
	
	}
	static void CrearElemento(String datoEmple, String valor,Element raiz, Document document){
		Element elem = document.createElement(datoEmple); 
		Text text = document.createTextNode(valor); 
		raiz.appendChild(elem); 
		elem.appendChild(text);
	}


}

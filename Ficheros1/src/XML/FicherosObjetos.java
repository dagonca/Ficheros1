package XML;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//Librerías DOMEO, parseadores y transformers.
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;




public class FicherosObjetos {

	public static void main(String[] args) 
	{
		//Datos .dat
		int id[]={1,2,3};
		String nombres[] = {"Carmensita","Jerónimo","Eugenio"};
		int dep[] = {10,20,30};
		double sal[]={150,120,100};
		Empleado empleado=null;
		
		//Streams y fichero
		String nombreFichero="C:\\Users\\21438581\\workspace\\Empleados.dat";
		File f = new File("C:\\Users\\21438581\\workspace\\Empleados.dat");
		
	
		FileOutputStream fos =null;
		ObjectOutputStream oos = null;
		
		//Rellenado
		try{
			fos = new FileOutputStream(nombreFichero);
			oos = new ObjectOutputStream(fos);
			
			
			for(int i =0 ; i<dep.length; i++){
				empleado = new Empleado(id[i],nombres[i],dep[i],sal[i]);
				oos.writeObject(empleado);
				System.out.println("empleado " + empleado.getNombre() + " guardado");
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
			Document document = implementation.createDocument(null, "Empleados",null); // "Empleados: Nodo padre"
			//4 líneas replicadas en uso de DOM.
			document.setXmlVersion("1.0"); //asignamos la version de nuestro XML

			
			try
			{
				while(true)
				{
					empleado=(Empleado) ois.readObject();
					//crea nodo hijo
					Element raiz = document.createElement("empleado"); 
					document.getDocumentElement().appendChild(raiz); 
					//rellena de elementos el nodo hijo
					//Nombre nodo, valor, a que nodo, en que documento.
					CrearElemento("id",Integer.toString(empleado.getId()), raiz, document);
					CrearElemento("nombre",empleado.getNombre(),raiz, document);
					CrearElemento("dep",Integer.toString(empleado.getDepartamento()),raiz,document); 
					CrearElemento("salario",Double.toString(empleado.getSalario()), raiz, document);


				}	
			}catch(EOFException eofe){
				Source source = new DOMSource(document);
				Result result = new StreamResult(new java.io.File("C:\\Users\\21438581\\workspace\\Empleados.xml"));
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

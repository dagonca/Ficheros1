package XStream;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.thoughtworks.xstream.XStream;

public class MainXstream {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		File f = new File("C:\\Users\\21438581\\workspace\\Empleados.dat");            
		ObjectInputStream objecOS = new ObjectInputStream(new FileInputStream(f));
		ListaEmpleados listaemp= new ListaEmpleados();
				Empleados emp = new Empleados(1,"Dani",2,150.0);
				listaemp.add(emp);
				Empleados emp2 = new Empleados(2,"Maria",21,850.0);
				listaemp.add(emp2);
				Empleados emp3 = new Empleados(3,"Alex",26,950.0);
				listaemp.add(emp3);
			
		
		try{
			System.out.println("Comienza el proceso de creacion de un fichero XML");
			XStream xstream=new XStream();
			xstream.alias("EmpleadosUEM", ListaEmpleados.class);
			xstream.alias("DatosEmpleados", Empleados.class);
			xstream.addImplicitCollection(ListaEmpleados.class, "lista");
			xstream.toXML(listaemp, new FileOutputStream("C:\\Users\\21438581\\workspace\\EmpleadosUEM.xml"));
			System.out.println("Fichero XML creado..");
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

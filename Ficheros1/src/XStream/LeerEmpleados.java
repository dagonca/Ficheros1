package XStream;
//ES48 0061 0196 0700 7130 0214
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class LeerEmpleados {

	public static void main(String[] args) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("EmpleadosUEM", ListaEmpleados.class);
		xstream.alias("DatosEmpleados", Empleados.class);
		xstream.addImplicitCollection(ListaEmpleados.class, "lista");
		ListaEmpleados lista = (ListaEmpleados) xstream.fromXML(new FileInputStream("C:\\Users\\21438581\\workspace\\EmpleadosUEM.xml"));
		System.out.println("Nº de empleados: "+lista.getListaEmpleados().size());
		List<Empleados> listEmp = new ArrayList<Empleados>();
		listEmp = lista.getListaEmpleados();
		Iterator iterator = listEmp.listIterator();
		while(iterator.hasNext()){
			Empleados emp = (Empleados) iterator.next();
			System.out.print("ID: "+emp.getId());
			System.out.print("\t Nombre: "+emp.getNombre());
			System.out.print("\t Departamento: "+emp.getDepartamento());
			System.out.println("\t Salario: "+emp.getSalario());
		}
		

	}

}

package XStream;

	import java.util.ArrayList;
	import java.util.List;
	public class ListaEmpleados {
		        
		        private List<Empleados> lista = new ArrayList<Empleados>();
		        public void add(Empleados per){
		                lista.add(per);
		        }
		        public List<Empleados> getListaEmpleados(){
		                return lista;
		        }
		}



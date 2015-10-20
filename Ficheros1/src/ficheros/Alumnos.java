package ficheros;

import java.io.Serializable;

public class Alumnos implements Serializable {
	String nombre;
	int edad;
	private static final long serialVersionUID=1L;
	
	public Alumnos(){
		
	}
	public Alumnos(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	

}

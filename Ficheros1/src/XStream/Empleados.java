package XStream;

import java.io.Serializable;

import java.io.Serializable;


public class Empleados implements Serializable
{
	private static final long serialVersionUID=1L;
	private int id;
	private String nombre;
	private int departamento;
	private double salario;
	

	public Empleados ()
	{
		
	}

	public Empleados(int id,String nombre, int departamento, double salario) 
	{
		super();
		this.id=id;
		this.nombre = nombre;
		this.departamento = departamento;
		this.salario = salario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
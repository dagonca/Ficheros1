package DOM;
import java.io.Serializable;

public class Alumno implements Serializable {
	
	private static final long serialVersionUID=1L;
	private int cod;
	private String nombre;
	private double media;
	public Alumno(int cod, String nombre, double media) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.media = media;
	}
	public Alumno(){
		
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		this.media = media;
	}

	
}

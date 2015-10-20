package ficheros;

import java.io.File;

public class ficheros1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		File fichero =new File("C:\\Users\\21438581");
		System.out.println("ficheros en el directorio");
		//System.out.println(fichero.getAbsolutePath());
		String[] arrayFicheros = fichero.list();
		
	for(int i=0;i<arrayFicheros.length;i++){
		System.out.println(arrayFicheros[i]);
	}
	
	}

}

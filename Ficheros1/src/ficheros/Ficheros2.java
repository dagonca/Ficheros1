package ficheros;

import java.io.*;

public class Ficheros2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File d= new File("NUEVODIR");
		File f1= new File(d,"fichero1.txt");
		File f2= new File(d,"fichero2.txt");
		d.mkdir();
		f1.createNewFile();
		f2.createNewFile();
		

	}

}

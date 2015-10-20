package ficheros;

import java.io.*;


public class LeerFichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String nomFich="C:\\Users\\21438581\\workspace\\ArrayCiudades.txt";
String nomFich2="C:\\Users\\21438581\\workspace\\ArrayCiudadesCopia.txt";

		try{
			BufferedWriter fw = new BufferedWriter(new FileWriter(nomFich2));
			BufferedReader fr = new BufferedReader(new FileReader(nomFich));
			String linea;
			while((linea=fr.readLine())!=null){
				System.out.println(linea);
				fw.write(linea);
				fw.write("\r\n");	
			}
			fw.close();
			fr.close();
		}catch(FileNotFoundException fnf){
			System.out.println("Archivo no encontrado");
		}catch(IOException ioe){
			System.out.println("Error E/S");
		}
		
		
	}

}


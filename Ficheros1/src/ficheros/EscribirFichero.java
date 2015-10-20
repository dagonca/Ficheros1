package ficheros;
import java.io.*;
public class EscribirFichero {

	public static void main(String[] args) {
		String nomFich="C:\\Users\\21438581\\workspace\\ArrayCiudades.txt";
		
		try{
			File fichero = new File(nomFich);
			
			FileWriter fw = new FileWriter(fichero,true);
			String[] cadena = new String[] {"Madrid","Barcelon","Valencia","Malaga","Sevilla","Cordoba","Andorra"};
			
			/*char[] cad= cadena.toCharArray();
			for(int i=0; i<cad.length; i++){
				f.write(cad[i]);
			}*/
			
			for(int i=0; i<cadena.length; i++){
				
				fw.write(i+". "+cadena[i]);
				fw.write("\r\n");
			}
		
			fw.close();
		}catch(IOException ioe){
			System.out.println("Disco lleno o protegido");
		}
	}
}

package ficheros;
import java.io.*;
import java.util.Scanner;
public class FicherosBi {

	public static void main(String[] args)  throws IOException, ClassNotFoundException{
	
		//Primeros100Bi();
		//ArraysDat();
		//ObjetosDat();
		RandomFile();
	}
	
static void Primeros100Bi() throws IOException{
		File f=new File("C:\\Users\\21438581\\workspace\\numeros.dat");
		FileOutputStream fos= new FileOutputStream(f);
		FileInputStream fis=new FileInputStream(f);
		//f.createNewFile();
		int n[]=new int[100];
		for(int i=0;i<n.length;i++){
			fos.write(i);
		}
		int i;
		while((i=fis.read())!=-1)
		System.out.println(i);

		fis.close();
		fos.close();
	}
	
 static void ArraysDat() throws IOException {
	String[] nombres = new String[] {"dani","juan","pepito","maria","marta","borja","adrian"};
	int[] edades=new int[]{12,5,26,21,14,18,36};
	
	File f2=new File("C:\\Users\\21438581\\workspace\\alumnos.dat");
	
	FileOutputStream fos2= new FileOutputStream(f2);
	DataOutputStream dataout = new DataOutputStream(fos2);
	
	FileInputStream fis2=new FileInputStream(f2);
	DataInputStream datain = new DataInputStream(fis2);
	
	//f2.createNewFile();
	
	for(int i=0;i<nombres.length;i++){
		
		dataout.writeUTF(nombres[i]);
		dataout.writeInt(edades[i]);
	}
	try{
		
		while(true){
			System.out.println(datain.readUTF());
			System.out.println(datain.readInt());
	
		}
	
	}catch(EOFException eof){
		System.out.println("EOF exception");
	}finally{
		datain.close();
		dataout.close();
	}

	
}
	
static void ObjetosDat() throws IOException, ClassNotFoundException {
		
	String[] nombres = new String[] {"dani","juan","pepito","maria","marta","borja","adrian"};
	int[] edades=new int[]{12,5,26,21,14,18,36};
	
	File f2=new File("C:\\Users\\21438581\\workspace\\alumnosObjetos.dat");
	
	
//ESCRIBIR	
	
	FileOutputStream fos2= new FileOutputStream(f2);
	ObjectOutputStream Objout = new ObjectOutputStream(fos2);
	
	for(int i=0;i<nombres.length;i++){
		Alumnos al=new Alumnos(nombres[i],edades[i]);
		Objout.writeObject(al);
	}
	
//LEER
	
	FileInputStream fis2=new FileInputStream(f2);
	ObjectInputStream Objain = new ObjectInputStream(fis2);
	try{
		Alumnos al= (Alumnos) Objain.readObject();
		while(al != null){
			System.out.println("Nombre: "+al.getNombre()+" Edad: "+al.getEdad());
			 al= (Alumnos) Objain.readObject();
		}
	
	}catch(EOFException eof){
		System.out.println("EOF exception");
	}finally{
		Objain.close();
		Objout.close();
	}

	
	}

static void RandomFile() throws IOException{
	
	/*short 2bytes
	 * byte 1byte
	 * long 8bytes
	 * boolean 1byte
	 * float 4bytes
	 * int 4bytes
	 * double 8bytes
	 * char 2bytes
	 * */
	File f=new File("C:\\Users\\21438581\\workspace\\AleatorioNumeros.dat");
	RandomAccessFile rf = new RandomAccessFile(f,"rw");
	int[] edades=new int[]{12,5,26,21,14,18,36};
	for(int i=0;i<edades.length;i++){
		rf.writeInt(edades[i]);	
	}
	
	
	
	System.out.println("Posicion?");
	Scanner sc = new Scanner(System.in);
	int a = sc.nextInt()-1;
    rf.seek(a*4);
    
    System.out.println("En la posicion "+a+" esta el numero "+rf.readInt());
    rf.close();
}
	
}

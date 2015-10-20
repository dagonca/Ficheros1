package SAX;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class GestionContenido extends DefaultHandler {

	public GestionContenido(){
		super();
	}
	
	public void startDocument(){
		System.out.println("comienzo del documento XML");
	}
	public void endDocument(){
		System.out.println("fin del documento XML");
	}
	public void startElement(String uri, String nombre, String nombreC, Attributes atts){
		System.out.println("comienzo del elemento "+nombre);
	}
	public void endElement(String uri, String nombre, String nombreC){
		System.out.println("fin del elemento "+nombre);
	}
	public void characters(char [] ch,int inicio,int longitud) throws SAXException{
		String c=new String(ch,inicio,longitud);
		c=c.replace("[\t\n]","");
		System.out.println("\t Caracteres: "+c);
		
	}
}

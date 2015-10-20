package SAX;
import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
public class leerFichero {

	public static void main(String[] args) throws FileNotFoundException, IOException, SAXException {
		XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
		GestionContenido gestor=new GestionContenido();
		procesadorXML.setContentHandler(gestor);
		InputSource fileXML=new InputSource("C:\\Users\\21438581\\workspace\\Alumno.xml");
		procesadorXML.parse(fileXML);

	}

}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Utilidades {
	
	public static void CSVToXML() throws IOException, ParserConfigurationException, TransformerException {
		
		Path origenCSV = Paths.get("D:\\PRUEBAS\\dam.csv");
		BufferedReader br = Files.newBufferedReader(origenCSV);
		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		
		//Generación del Document para XML
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = factory.newDocumentBuilder();
		Document documento = db.newDocument();
		
		Element alumnos = documento.createElement("alumnos");
		documento.appendChild(alumnos);
		
		Stream<String> lineas = br.lines();
		lineas.forEach(alumno -> {
			String[] valores = alumno.split(";");
			//Alumno objetoAlumno = new Alumno(Integer.parseInt(valores[0]), valores[1], valores[2]);
			//listaAlumnos.add(objetoAlumno);
			
			Element etiquetaAlumno = documento.createElement("alumno");
			alumnos.appendChild(etiquetaAlumno);
			
			Element codigo = documento.createElement("codigo");
			codigo.setTextContent(valores[0]);
			etiquetaAlumno.appendChild(codigo);
			
			Element nombre = documento.createElement("nombre");
			nombre.setTextContent(valores[1]);
			etiquetaAlumno.appendChild(nombre);
			
			Element apellidos = documento.createElement("apellidos");
			apellidos.setTextContent(valores[2]);
			etiquetaAlumno.appendChild(apellidos);
			
		});
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		
		DOMSource dom = new DOMSource(documento);
		StreamResult fichero =  new StreamResult("D:\\PRUEBAS\\dam.xml");
		
		transformer.transform(dom, fichero);
		
		br.close();
	}
	
	public static void XMLToCSV() throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = factory.newDocumentBuilder();
		Document documento = db.parse("D:\\PRUEBAS\\dam.xml");
		
		NodeList codigo = documento.getElementsByTagName("codigo");
		NodeList nombres = documento.getElementsByTagName("nombre");
		NodeList apellidos = documento.getElementsByTagName("apellidos");
		
		BufferedWriter bw = Files.newBufferedWriter(Paths.get("D:\\PRUEBAS\\dam.csv"));
		
		for (int i = 0; i< codigo.getLength(); i++) {
			String linea = codigo.item(i).getTextContent() + ";" + nombres.item(i).getTextContent()
						   + ";" + apellidos.item(i).getTextContent() + "\n";
			bw.write(linea);
		}
		
		bw.flush();
		
		bw.close();
		
	}

}

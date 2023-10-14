import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Principal {

	public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException, SAXException {
		
		int opcion = -1;
		Scanner teclado = new Scanner(System.in);
		
		imprimirMenu();
		opcion = teclado.nextInt();
		
		while(opcion!=3) {
			
			imprimirMenu();
			opcion = teclado.nextInt();
			switch (opcion) {
				case 1: {
					Utilidades.CSVToXML();
				}
				case 2: {
					Utilidades.XMLToCSV();
				}
				default:
					System.out.println("Opción no válida");
			}
			
		}

	}
	
	private static void  imprimirMenu() {
		
		System.out.println("***********MENÚ***********");
		System.out.println("      1. CSV -> XML");
		System.out.println("      2. XML -> CSV");
		System.out.println("      3. Salir");
		
	}

}

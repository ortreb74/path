package bundle.schema.es;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class XMLWriter {

	XMLStreamWriter writer;
	
	static public String getSvgNamespaceURI() {
		return "http://www.w3.org/2000/svg";
		
	}
	
	public void startSvgDocument(String fileName) {
		File file = new File(fileName);
		System.out.println("Production du fichier (dans le r�pertoire de ce projet) : " + fileName);
		//file.getParentFile().mkdirs();
		
		try {
			
			writer =  XMLOutputFactory.newInstance().createXMLStreamWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
			
			writer.writeStartDocument("UTF-8","1.0");
			
			// le dernier argument est l'URI correspondant au namespace
			writer.writeStartElement( "svg", "svg", getSvgNamespaceURI());
			// le dernier argument est l'URI correspondant au namespace
			// cette URI doit �tre reprise ici
			writer.writeNamespace("svg", getSvgNamespaceURI());
			
			writer.setPrefix("svg", getSvgNamespaceURI());
			writer.writeAttribute("width", "1900px");
			writer.writeAttribute("height", "1900px");
			
			// cela fait le contraire de ce que je pense
			// une fois d�finit le namespace par d�faut ne s'affiche plus
			// writer.setDefaultNamespace(getSvgNamespaceURI());
			
		} catch (XMLStreamException e) {
			// au pire:
			// cette erreur est l'�quivalent d'une erreur de compilation
			e.printStackTrace();
		} catch (FactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// cette erreur est l'�quivalent d'une erreur de compilation
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// cette erreur ne doit pas de produire parce que le fichier a �t� cr�� avant
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			writer.writeEndElement();
			writer.close();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void startElement(String balise) {
		try {
			writer.writeStartElement(getSvgNamespaceURI(),balise);
		} catch (XMLStreamException e) {
			// si cette erreur se produit c'est que le programme est face � un bogue
			// cette erreur est l'�quivalent d'une erreur de compilation
			e.printStackTrace();
		}
		
	}
	
	public void attribute(String key, String value) {
		try {
			writer.writeAttribute(key, value);
		} catch (XMLStreamException e) {
			// si cette erreur se produit c'est que le programme est face � un bogue
			// cette erreur est l'�quivalent d'une erreur de compilation
			e.printStackTrace();
		}
		
	}
	
	public void endElement() {
		try {
			writer.writeEndElement();
		} catch (XMLStreamException e) {
			// si cette erreur se produit c'est que le programme est face � un bogue
			// cette erreur est l'�quivalent d'une erreur de compilation
			e.printStackTrace();
		}
		
	}
	
	public void text(String text) {
		try {
			writer.writeCharacters(text);
		} catch (XMLStreamException e) {
			// si cette erreur se produit c'est que le programme est face � un bogue
			// cette erreur est l'�quivalent d'une erreur de compilation
			e.printStackTrace();
		}
		
	}



}

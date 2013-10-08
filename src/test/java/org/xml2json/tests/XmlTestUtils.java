package org.xml2json.tests;

import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlTestUtils {

	public static Document newDocument() {
		try {
			return DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		} catch (ParserConfigurationException e) {
			throw new RuntimeException("Error creating new test document: ", e);
		}
	}

	public static Element newElement(String tagName) {
		Document document = newDocument();
		return newElement(document, tagName);
	}

	public static Element newElement(Document document, String tagName) {
		return document.createElement(tagName);
	}

	public static Element newElementWithAttrs(String tagName, String... attrNames) {
		Document document = newDocument();
		Element element = newElement(document, tagName);
		
		for (String attr : attrNames) {
			element.appendChild(document.createAttribute(attr));
		}
		
		return element;
	}

	public static Element newElementWithAttrs(String tagName, Map<String, String> attrs) {
		Document document = newDocument();
		Element element = newElement(document, tagName);
		
		for (Entry<String, String> entry : attrs.entrySet()) {
			element.setAttribute(entry.getKey(), entry.getValue());
		}
		
		return element;
	}

}

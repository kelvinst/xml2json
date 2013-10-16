package org.xml2json;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.google.gson.JsonObject;

public class Xml2Json {

	public static JsonObject convert(Node node) {
		JsonObject result = new JsonObject();
		
		if (node instanceof Element) {
			Element element = (Element) node; 
			
			JsonObject object = new JsonObject();
			result.add(element.getNodeName(), object);
		}
		
		return result;
	};
	
}


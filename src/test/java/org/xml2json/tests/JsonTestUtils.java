package org.xml2json.tests;

import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonObject;

public class JsonTestUtils {

	public static JsonObject newObject() {
		return new JsonObject();
	}

	public static JsonObject newTagObject(JsonObject parent, String tagName) {
		JsonObject result = newObject();
		parent.add(tagName, result);
		
		return result;
	}

	public static JsonObject newTagObjectWithAttrs(JsonObject parent, String tagName, String... attrNames) {
		JsonObject object = newTagObject(parent, tagName);
		for (String attr : attrNames) {
			object.addProperty(attr, "");
		}
		return object;
	}
	
	public static JsonObject newTagObjectWithAttrs(JsonObject parent, String tagName, Map<String, String> attrs) {
		JsonObject object = newTagObject(parent, tagName);
		for (Entry<String, String> entry : attrs.entrySet()) {
			object.addProperty(entry.getKey(), entry.getValue());
		}		
		return object;
	}

}

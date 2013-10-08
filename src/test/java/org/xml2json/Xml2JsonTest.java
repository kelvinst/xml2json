package org.xml2json;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;
import org.xml2json.tests.JsonTestUtils;
import org.xml2json.tests.XmlTestUtils;

import com.google.gson.JsonObject;

public class Xml2JsonTest {

	@Test
	public void convertSimpleTagTest() {
		String tagName = "simpleTag";
		
		JsonObject parent = JsonTestUtils.newObject();
		JsonTestUtils.newTagObject(parent, tagName);
		
		Assert.assertEquals(Xml2Json.convert(XmlTestUtils.newElement(tagName)), parent);
	}
	
	@Test
	public void convertTagWithAttrTest() {
		String tagName = "tagWithAttr";
		String attrName = "attr";
		
		JsonObject parent = JsonTestUtils.newObject();
		JsonTestUtils.newTagObjectWithAttrs(parent, tagName, attrName);

		Assert.assertEquals(Xml2Json.convert(XmlTestUtils.newElementWithAttrs(tagName, attrName)), parent);
	}

	@Test
	public void convertTagWithAttrsTest() {
		String tagName = "tagWithAttr";
		String[] attrNames = {"attr1", "attr2"};
		
		JsonObject parent = JsonTestUtils.newObject();
		JsonTestUtils.newTagObjectWithAttrs(parent, tagName, attrNames);

		Assert.assertEquals(Xml2Json.convert(XmlTestUtils.newElementWithAttrs(tagName, attrNames)), parent);
	}

	@Test
	public void convertTagWithAttrAndValueTest() {
		String tagName = "tagWithAttr";
		
		HashMap<String, String> map = new HashMap<String, String>(1);
		map.put("attr", "value");
		
		JsonObject parent = JsonTestUtils.newObject();
		JsonTestUtils.newTagObjectWithAttrs(parent, tagName, map);
		
		Assert.assertEquals(Xml2Json.convert(XmlTestUtils.newElementWithAttrs(tagName, map)), parent);
	}
	
	@Test
	public void convertTagWithAttrsAndValuesTest() {
		String tagName = "tagWithAttr";
		
		HashMap<String, String> map = new HashMap<String, String>(1);
		map.put("attr1", "value1");
		map.put("attr2", "value2");
		
		JsonObject parent = JsonTestUtils.newObject();
		JsonTestUtils.newTagObjectWithAttrs(parent, tagName, map);
		
		Assert.assertEquals(Xml2Json.convert(XmlTestUtils.newElementWithAttrs(tagName, map)), parent);
	}
	

}

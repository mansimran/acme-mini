package com.acme.mini;

import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class ImportService {

  // CWE-611: Improper Restriction of XML External Entity Reference (XXE)
  // DocumentBuilderFactory is left with default settings, so external entities
  // and DTDs are resolved for untrusted input.
  public Document parseImport(InputStream xmlInput) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    return builder.parse(xmlInput);
  }
}

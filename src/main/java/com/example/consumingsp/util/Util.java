package com.example.consumingsp.util;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.MessageFormat;

public class Util {

    public static void convertCSVtoXML(File csvFilePath, File xmlFilePath) throws Exception {
        BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath));
        String[] headers = csvReader.readLine().split(",");

        XMLStreamWriter xmlWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(new FileWriter(xmlFilePath));

        xmlWriter.writeStartDocument();
        xmlWriter.writeStartElement("data");

        String line;
        while ((line = csvReader.readLine()) != null) {
            String[] data = line.split(",");
            xmlWriter.writeStartElement("row");
            for (int i = 0; i < headers.length; i++) {
                xmlWriter.writeStartElement(headers[i]);
                xmlWriter.writeCharacters(data[i]);
                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();
        }

        xmlWriter.writeEndElement();
        xmlWriter.writeEndDocument();

        xmlWriter.flush();
        xmlWriter.close();
        csvReader.close();

        System.out.println("CSV to XML conversion completed successfully.");
    }
}

package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.*;

import xmlwriter.XMLPayload;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import cobol.*;

public class XMLPayloadTest {

	@Test
    void testAddElements() {
		XMLPayload xmlPayload = new XMLPayload();
		
        Cobol cobol = new Cobol();
        cobol.setProgram_ID("base_jb");
        cobol.setSectionName("working-storage");
        cobol.setDivisionName("identification");
        cobol.setDayDateWritten(7);
        cobol.setMonthDateWritten("jul");
        cobol.setYearDateWritten(1995);
        cobol.setComputeVar_1("num_1");
        cobol.setComputeVar_2("num_2");
        cobol.setComputeOperator("+");
        cobol.setComputeEqual("=");
        cobol.setComputeSum("sum");
        cobol.setDisplay1("num_1");
        cobol.setDisplay2("num_2");
        cobol.setDisplayNumber(10);
        cobol.setDisplayString1("\"The sum of \"");
        cobol.setDisplayString2("\" and \"");
        cobol.setDisplayString3("\" is \"");
        cobol.setStopRun("run");

        xmlPayload.addElements(cobol);

        Document doc = xmlPayload.getDoc();
        Element rootElement = xmlPayload.getRootElement();

        assertNotNull(doc);
        assertNotNull(rootElement);

        assertEquals("cobol", rootElement.getNodeName());

        Element programIdElement = (Element) rootElement.getElementsByTagName("Program-ID").item(0);
        assertNotNull(programIdElement);
        assertEquals("base_jb", programIdElement.getTextContent());

        Element sectionElement = (Element) rootElement.getElementsByTagName("section").item(0);
        assertNotNull(sectionElement);
        assertEquals("working-storage", sectionElement.getTextContent());

        Element divisionElement = (Element) rootElement.getElementsByTagName("division").item(0);
        assertNotNull(divisionElement);
        assertEquals("identification", divisionElement.getTextContent());

        Element dayDateWrittenElement = (Element) rootElement.getElementsByTagName("day-date-written").item(0);
        assertNotNull(dayDateWrittenElement);
        assertEquals("7", dayDateWrittenElement.getTextContent());

        Element monthDateWrittenElement = (Element) rootElement.getElementsByTagName("month-date-written").item(0);
        assertNotNull(monthDateWrittenElement);
        assertEquals("jul", monthDateWrittenElement.getTextContent());

        Element yearDateWrittenElement = (Element) rootElement.getElementsByTagName("year-date-written").item(0);
        assertNotNull(yearDateWrittenElement);
        assertEquals("1995", yearDateWrittenElement.getTextContent());

        Element computeElement = (Element) rootElement.getElementsByTagName("Compute").item(0);
        assertNotNull(computeElement);
        assertEquals("sum = num_1 + num_2", computeElement.getTextContent());

        Element displayElement = (Element) rootElement.getElementsByTagName("Display").item(0);
        assertNotNull(displayElement);
        assertEquals("\"The sum of \"num_1\" and \"num_2\" is \"10", displayElement.getTextContent());

        Element stopRunElement = (Element) rootElement.getElementsByTagName("Stop").item(0);
        assertNotNull(stopRunElement);
        assertEquals("run", stopRunElement.getTextContent());
    }
}


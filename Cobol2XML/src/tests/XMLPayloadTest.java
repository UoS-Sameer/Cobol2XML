package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.*;

import xmlwriter.XMLPayload;

public class XMLPayloadTest {

    @Test
    void testWriteFile() {

        XMLPayload xmlPayload = new XMLPayload();
        String filename = "test.xml";

        xmlPayload.writeFile(filename);
        File file = new File(filename);

        assertTrue(file.length() > 0);
        file.delete();
    }
}


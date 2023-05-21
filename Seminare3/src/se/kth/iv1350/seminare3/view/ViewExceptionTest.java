package se.kth.iv1350.seminare3.view;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.seminare3.Integration.FileLogger;
import se.kth.iv1350.seminare3.controller.Controller;


import static org.junit.jupiter.api.Assertions.*;
public class ViewExceptionTest {
    /*Testa att korrekt felmeddelande skrivs ut när exception händer

     */
    Controller testContr = new Controller(new FileLogger("exceptionLog"));

    View view = new View(testContr, new FileLogger("exceptionLog"));

    @Test
    void testExceptionInvalidIE() {
        testContr.startSale();
        String input = "n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        try {
            testContr.enterItemIdentifier(8);
        } catch (ItemIdentifierInvalidException e) {
            boolean exceptionThrown = true;
            assertTrue(exceptionThrown == true);
        }
    }

    @Test
    void testDatabaseException() {
        testContr.startSale();
        String input = "n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean exceptionThrown = false;
        try {
            testContr.enterItemIdentifier(10);
        } catch (DatabaseFailureException e) {
            exceptionThrown = true;
        } catch (ItemIdentifierInvalidException e) {

        }
        assertTrue(exceptionThrown == true, "DatabaseFailureException not thrown using " +
                "itemIdentifier 10, (Database failed");
    }
}

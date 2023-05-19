package se.kth.iv1350.seminare3.view;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.seminare3.Integration.FileLogger;
import se.kth.iv1350.seminare3.controller.Controller;


import static org.junit.jupiter.api.Assertions.*;
public class ViewExceptionTest {
    /*Testa att korrekt felmeddelande skrivs ut när exception händer

     */
    Controller testContr = new Controller(new FileLogger());

    View view = new View(testContr,new FileLogger());
    @Test
    void testExceptionInvalidIE() {
        testContr.startSale();
        try {
            testContr.enterItemIdentifier(8);
        } catch (ItemIdentifierInvalidException e) {
            ItemIdentifierInvalidException t = new ItemIdentifierInvalidException("ItemIdentifier not found");

            assertTrue(e ==t, "Not correct exception type" );
        }

    }
}

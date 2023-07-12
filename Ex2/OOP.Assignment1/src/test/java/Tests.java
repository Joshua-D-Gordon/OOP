import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.Member;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test(){
        //making group admin
        GroupAdmin admin = new GroupAdmin();
        //checking admin customerlist is emepty
        assertEquals(0,admin.customers.size());
        //checking admins undoabale string builder is a new clean seqence and empty stack
        assertEquals("",admin.usb.toString());
        assertEquals(new Stack<>(),admin.usb.getStack());
        //making members m1-m4
        Member m1 = new ConcreteMember(), m2 = new ConcreteMember(), m3 = new ConcreteMember(), m4 = new ConcreteMember();
        //printing ONE members info
        System.out.println("PRINTING ONE CONCRETEMEMBER INFO");
        logger.info(()->JvmUtilities.objectFootprint(m1));

        logger.info(()->JvmUtilities.objectTotalSize(m1));

        logger.info(() -> JvmUtilities.jvmInfo());
        //priinting admins JVM info
        System.out.println("PRINTING ADMIN INFO BEFORE ADDING MEMEBRS TO ADMIN");
        logger.info(()->JvmUtilities.objectFootprint(admin));

        logger.info(()->JvmUtilities.objectTotalSize(admin));

        logger.info(() -> JvmUtilities.jvmInfo());
        //regestering members m1-m4 on admins customer list
        admin.register(m1);
        //checking that admins customer list size is now one , m1 is the last memebr in the admins customer list, m1 and admins seqences are the same
        assertEquals(1,admin.customers.size());
        assertEquals(m1,admin.customers.get(admin.customers.size()-1));
        assertEquals(admin.usb.toString(),admin.customers.get(admin.customers.size()-1).getUsb().toString());

        admin.register(m2);

        //checking that admins customer list size is now 2 , m2 is the last memebr in the admins customer list, m2 and admins seqences are the same
        assertEquals(2,admin.customers.size());
        assertEquals(m2,admin.customers.get(admin.customers.size()-1));
        assertEquals(admin.usb.toString(),admin.customers.get(admin.customers.size()-1).getUsb().toString());

        admin.register(m3);

        //checking that admins customer list size is now 3 , m3 is the last memebr in the admins customer list, m3 and admins seqences are the same
        assertEquals(3,admin.customers.size());
        assertEquals(m3,admin.customers.get(admin.customers.size()-1));
        assertEquals(admin.usb.toString(),admin.customers.get(admin.customers.size()-1).getUsb().toString());

        admin.register(m4);

        //checking that admins customer list size is now 4 , m4 is the last memebr in the admins customer list, m4 and admins seqences are the same
        assertEquals(4,admin.customers.size());
        assertEquals(m4,admin.customers.get(admin.customers.size()-1));
        assertEquals(admin.usb.toString(),admin.customers.get(admin.customers.size()-1).getUsb().toString());

        System.out.println("PRINTING ADMIN INFO AFTER ADDING MEMBERS TO ADMIN CUSTOMER LIST");
        //priinting admins JVM info
        logger.info(()->JvmUtilities.objectFootprint(admin));

        logger.info(()->JvmUtilities.objectTotalSize(admin));

        logger.info(() -> JvmUtilities.jvmInfo());

        //appending a string to admins undoablestringbulders string builder
        admin.append("to be or not to be");
        //checking admins seqence;
        assertEquals("to be or not to be",admin.usb.toString());
        //check all memebrs have been updated
        for(int i = 0; i<admin.customers.size();i++){
            assertEquals(admin.usb.toString(),admin.customers.get(i).getUsb().toString());
        }

        System.out.println("PRINTING JVM INFO AFTER APPENDING TO ADMIN");
        logger.info(()->JvmUtilities.objectFootprint(admin));

        logger.info(()->JvmUtilities.objectTotalSize(admin));

        logger.info(() -> JvmUtilities.jvmInfo());
        System.out.println("PRINTING JVM INFO OF ONE MEMBER AFTER APPENDING STRING TO ADMIN THAT THEN UPDATED THAT MEMEBR");
        logger.info(()->JvmUtilities.objectFootprint(m1));

        logger.info(()->JvmUtilities.objectTotalSize(m1));

        logger.info(() -> JvmUtilities.jvmInfo());

        //Unregestering a memebr
        int adminsize = admin.customers.size();
        admin.unregister(m2);
        //chekcing admins size was reduced by 1
        assertEquals(adminsize-1,admin.customers.size());
        //trying to unregister a memebr that dose not exist try and catch catch the error
        admin.unregister(m2);

        System.out.println("PRINTING ADMIN INFO AFTER removing M2");
        logger.info(()->JvmUtilities.objectFootprint(admin));

        logger.info(()->JvmUtilities.objectTotalSize(admin));

        logger.info(() -> JvmUtilities.jvmInfo());
        //doing a replace on admins seqence
        admin.usb.replace(3, 5, "eat") ;
        //doing a replace on admins seqence
        admin.usb.replace(17, 19, "eat") ;
        //checking admin seqence and its memebrs have been updated
        assertEquals("to eat or not to eat",admin.usb.toString());
        for(int i = 0; i<admin.customers.size();i++){
            assertEquals(admin.usb.toString(),admin.customers.get(i).getUsb().toString());
        }
        //doing a reverse on admins seqence
        admin.usb.reverse();
        //checking the memebrs seqence was reversed and eqauls admins
        for(int i = 0; i<admin.customers.size();i++){
            assertEquals(admin.usb.toString(),admin.customers.get(i).getUsb().toString());
        }
        //undoing admins seqqence 3 times
        admin.usb.undo();
        admin.usb.undo();
        admin.usb.undo();
        //checking admins seqence eqauls original first appened
        assertEquals("to be or not to be", admin.usb.toString());
        //checking memebers seqence eqauls orginal first append
        for(int i = 0; i<admin.customers.size();i++){
            assertEquals(admin.usb.toString(),admin.customers.get(i).getUsb().toString());
        }
        //last undo to empty stack and seqence
        admin.usb.undo();
        //checking admin and meber have empty seqence and stack
        assertEquals("", admin.usb.toString());
        assertEquals(new Stack<>(),admin.usb.getStack());
        for(int i = 0; i<admin.customers.size();i++){
            assertEquals(admin.usb.toString(),admin.customers.get(i).getUsb().toString());
            assertEquals(new Stack<>(),admin.customers.get(i).getUsb().getStack());
        }
        //should print no more undo's
        admin.undo();
        //finsihed




    }
}

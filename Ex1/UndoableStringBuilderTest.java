package Matala1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UndoableStringBuilderTest {

    @Test
    void undo() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("to be or not to be") ;
        usb.replace(3, 5, "eat") ;
        usb.replace(17, 19, "eat") ;
        usb.reverse();

        usb.undo();
        usb.undo();
        usb.undo();
        assertEquals("to be or not to be", usb.toString());
        usb.undo();
        assertEquals("", usb.toString());

        usb.undo();
        usb.undo();
        assertEquals("", usb.toString());
    }

    @Test
    void append() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        assertEquals("", usb.toString());
        usb.append(null);
        assertEquals("null", usb.toString());
        usb = new UndoableStringBuilder();
        usb.append("this is my appended string");
        assertEquals("this is my appended string",usb.toString());
    }

    @Test
    void delete() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("hello (delete this part) world");
        usb.delete(6,25);
        assertEquals("hello world", usb.toString());
        usb.delete(5,5);
        assertEquals("hello world", usb.toString());

        usb = new UndoableStringBuilder();
        usb.append("no change");
        usb.delete(-1,3);
        assertEquals("no change",usb.toString());
        usb.delete(5,4);
        assertEquals("no change",usb.toString());
        usb.delete(usb.toString().length() + 1,usb.toString().length() + 3);
        assertEquals("no change",usb.toString());



    }

    @Test
    void insert() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("hi my name is and its nice to meet you");
        usb.insert(13, " Joshua");
        assertEquals("hi my name is Joshua and its nice to meet you", usb.toString());

        usb.insert(-1, "this cant be inserted");
        assertEquals("hi my name is Joshua and its nice to meet you", usb.toString());
        usb.insert(usb.toString().length() + 1, "this cant be inserted");
        assertEquals("hi my name is Joshua and its nice to meet you", usb.toString());

        usb = new UndoableStringBuilder();
        usb.append("12345678");
        usb.insert(2, null);
        assertEquals("12null345678", usb.toString());


    }

    @Test
    void replace() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("12345abc6789");
        usb.replace(5,8,"");
        assertEquals("123456789", usb.toString());
        usb.replace(5,8,null);
        assertEquals("123456789", usb.toString());

        usb.replace(-1, 5, "this cant replace");
        assertEquals("123456789", usb.toString());
        usb.replace(8, 5, "this cant replace");
        assertEquals("123456789", usb.toString());
        usb.replace(usb.toString().length() + 1, usb.toString().length() + 3 ,"this cant replace");
        assertEquals("123456789", usb.toString());

        usb = new UndoableStringBuilder();
        usb.append("12345");
        usb.replace(3,10,"thhhhhhhhhhhhhhhhhhhh");
        assertEquals("123thhhhhhhhhhhhhhhhhhhh", usb.toString());
        usb = new UndoableStringBuilder();
        usb.append("12345");
        usb.replace(3,100,"the");
        assertEquals("123the", usb.toString());

    }

    @Test
    void reverse() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("abcdefg");
        usb.reverse();
        assertEquals("gfedcba", usb.toString());
    }

    @Test
    void testToString() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("testing done");
        assertEquals("testing done", usb.toString());
    }
}
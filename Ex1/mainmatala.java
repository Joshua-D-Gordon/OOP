package Matala1;

public class mainmatala {
    /***
     * Runs Program for Matala 1
     * @param args - the main function
     */
    public static void main(String[] args){

        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("to be or not to be") ;
        System.out.println(usb) ;
        usb.replace(3, 5, null) ;
        System.out.println(usb) ;
        usb.replace(17, 19, "eat") ;
        System.out.println(usb) ;
        usb.reverse();
        System.out.println(usb) ;
        System.out.println();
        usb.undo();
        System.out.println(usb);
        usb.undo();
        System.out.println(usb);
        usb.undo();
        System.out.println(usb);
        usb.undo();
        usb.undo();
        System.out.println(usb);


    }

}

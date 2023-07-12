package observer;

import java.util.ArrayList;

public class main {

    public static void main(String[] args){

        GroupAdmin admin = new GroupAdmin();

        Member m1 = new ConcreteMember(), m2 = new ConcreteMember(), m3 = new ConcreteMember(), m4 = new ConcreteMember();

        admin.register(m1);
        admin.register(m2);
        admin.register(m3);
        admin.register(m4);



        System.out.println();
        System.out.println(JvmUtilities.jvmInfo());
        System.out.println();

        admin.append("to be or not to be") ;
        System.out.println(admin.usb) ;

        System.out.println("members:");
        for(ConcreteMember m:admin.customers){
            System.out.println(m.getUsb());
        }

        System.out.println();
        System.out.println(JvmUtilities.jvmInfo());
        System.out.println();

        admin.usb.replace(3, 5, "rt") ;

        System.out.println(admin.usb) ;

        System.out.println("members:");
        for(ConcreteMember m:admin.customers){
            System.out.println(m.getUsb());
        }

        System.out.println();
        System.out.println(JvmUtilities.jvmInfo());
        System.out.println();



        admin.usb.replace(17, 19, "eat") ;
        System.out.println(admin.usb) ;
        System.out.println("members:");
        for(ConcreteMember m:admin.customers){
            System.out.println(m.getUsb());
        }


        System.out.println();
        System.out.println(JvmUtilities.jvmInfo());
        System.out.println();

        admin.usb.reverse();

        System.out.println(admin.usb) ;

        System.out.println("members:");
        for(ConcreteMember m:admin.customers){
            System.out.println(m.getUsb());
        }

        System.out.println();
        System.out.println(JvmUtilities.jvmInfo());
        System.out.println();

        System.out.println();

        admin.unregister(m2);

        admin.undo();

        System.out.println(admin.usb);
        System.out.println("m2:is");
        System.out.println(((ConcreteMember) m2).getUsb());
        System.out.println("members:");
        for(ConcreteMember m:admin.customers){
            System.out.println(m.getUsb());
        }
        System.out.println();
        System.out.println(JvmUtilities.jvmInfo());
        System.out.println();


        admin.undo();
        System.out.println(admin.usb);
        System.out.println("m2:is");
        System.out.println(((ConcreteMember) m2).getUsb());
        System.out.println("members:");
        for(ConcreteMember m:admin.customers){
            System.out.println(m.getUsb());
        }
        System.out.println();
        System.out.println(JvmUtilities.jvmInfo());
        System.out.println();
        admin.undo();
        System.out.println(admin.usb);
        System.out.println("m2:is");
        System.out.println(((ConcreteMember) m2).getUsb());
        System.out.println("members:");
        for(ConcreteMember m:admin.customers){
            System.out.println(m.getUsb());
        }
        System.out.println();
        System.out.println(JvmUtilities.jvmInfo());
        System.out.println();
        admin.undo();
        admin.undo();
        System.out.println(admin.usb);
        System.out.println("members:");
        for(ConcreteMember m:admin.customers){
            System.out.println(m.getUsb());
        }
        System.out.println();
        System.out.println(JvmUtilities.jvmInfo());
        System.out.println();
    }
}

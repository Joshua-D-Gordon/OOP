package observer;

import java.util.ArrayList;
import java.util.Stack;

public class GroupAdmin implements Sender{
    public ArrayList<ConcreteMember> customers;
    public UndoableStringBuilder usb;

    /***
     * constructor
     */
    public GroupAdmin(){
        this.customers = new ArrayList<>();
        this.usb = new UndoableStringBuilder();
    }

    /***
     * alternitave constructor
     * @param customers
     */
    public GroupAdmin(ArrayList<ConcreteMember> customers){
        this.customers = customers;
        this.usb = new UndoableStringBuilder();
    }

    /***
     * register a memebr to admins array list of Concretemeberes
     * @param obj - the member to add
     */
    @Override
    public void register(Member obj) {
        this.customers.add((ConcreteMember) obj);
        this.customers.get(customers.size()-1).update(this.usb);
    }

    /***
     * unregister member from admins list of ConcreteMemebers
     * @param obj - memebr to remove
     */
    @Override
    public void unregister(Member obj) {
        try {
            //UndoableStringBuilder forunregestered = new UndoableStringBuilder(null);
            this.customers.get(this.customers.indexOf((ConcreteMember) obj)).update(null);
            this.customers.remove(customers.indexOf((ConcreteMember) obj));
        }catch (Exception e){
            //catch error
            System.out.println("No such memebr to remove");
            e.printStackTrace();
        }
    }

    /***
     * insert string at an offset in to admins stringbuilder
     * @param offset - index's to offset by
     * @param obj - string to insert
     */
    @Override
    public void insert(int offset, String obj) {
        this.usb.insert(offset, obj);
        for(Member m:customers){
            m.update(this.usb);
        }
    }

    /***
     * appends a string to current admins stringbuilder seqeunce
     * @param obj - string to append
     */
    @Override
    public void append(String obj) {

        this.usb.append(obj);

        for(Member m:customers){
            m.update(this.usb);
        }
    }

    /***
     * dlete a substring from admins stringbuilder current seqence
     * @param start - start index of substring to delete
     * @param end - end index of substring to delete
     */
    @Override
    public void delete(int start, int end) {
        this.usb.delete(start, end);
        for(Member m:customers){
            m.update(this.usb);
        }
    }

    /***
     * un-dose admins last change.
     */
    @Override
    public void undo() {
        this.usb.undo();
        for(Member m:customers){
            m.update(this.usb);
        }
    }
}

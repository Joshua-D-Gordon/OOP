package observer;

public class ConcreteMember implements Member{
    private UndoableStringBuilder usb;

    /***
     * undoablestringbuilder getter
     * @return - this undoablestringbuilder
     */
    public UndoableStringBuilder getUsb() {
        return usb;
    }
    //constructor
    public ConcreteMember(){
        this.usb = null;
    }

    /***
     * updates this undoable string builder to admins undoable string builder
     * @param usb
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.usb = usb;
    }
}

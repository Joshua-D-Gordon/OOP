package observer;


import java.util.Stack;

import java.lang.StringBuilder;

public class UndoableStringBuilder {

    private StringBuilder sequence;
    private Stack<String> stack;

    /***
     * String builder getter
     * @return - returns this undoablestringbuilder's stringbuilder
     */
    public StringBuilder getSequence() {
        return sequence;
    }
    /***
     * stack getter
     * @return - returns this undoablestringbuilder's stack of strings
     */
    public Stack<String> getStack() {
        return stack;
    }

    /***
     * Stringbuilder setter
     * @param sequence - sets this undoablestringbuilder's stringbuilder
     */
    public void setSequence(StringBuilder sequence) {
        this.sequence = sequence;
    }

    /***
     * stack setter
     * @param stack - sets this undoablestringbuilder's stack
     */
    public void setStack(Stack<String> stack) {
        this.stack = stack;
    }

    /**
     * this method undoes the last method applied to the sequence.
     */
    public void undo(){
        try{
            String temp = this.stack.pop();
            this.sequence.setLength(0);
            this.sequence.append(temp);
        }catch (Exception e){
            if(this.stack.isEmpty()){
                System.out.println("No more Undo's");
            }
            // if this stack is "full" the java.util.stack will automatically extend the stack capacity
            // as java.util.stack extends from vector and has this possibility
        }

    }

    /***
     * This is the Class's constructor.
     */
    public UndoableStringBuilder(){
        this.sequence = new StringBuilder();
        this.stack = new Stack<String>();

    }

    public UndoableStringBuilder(UndoableStringBuilder usb){
        this.sequence = usb.sequence;
        this.stack = usb.stack;
    }


    /**
     * This method appends a String to the current sequence.
     * @param str - The string to be appended
     * @return - returns the object UndoableStringBuilder with its sequence updated via the method
     */
    public UndoableStringBuilder append(String str){

        this.stack.push(sequence.toString());
        this.sequence.append(str);
        return this;

    }

    /**
     * This method deletes a sub-sequence from the current sequence
     * @param start - starting index of the sub-sequence to remove from the sequence.
     * @param end - ending index of the sub-sequence to remove from the sequence.
     * @return - returns the object UndoableStringBuilder with its sequence updated via the method
     */
    public UndoableStringBuilder delete(int start, int end){

        try{
            this.stack.push(sequence.toString());
            this.sequence.delete(start,end);
            return this;
        } catch (Exception e){
            if(Integer.class.isInstance(start) && Integer.class.isInstance(end)){
                if(start < 0){
                    System.out.println("start integer must be greater than 0");
                } else if(start > end) {
                    System.out.println("start integer must be smaller than end");
                } else if(start > this.sequence.length()){
                    System.out.println("start integer must be smaller than seqence length");
                }
                return this;
            }else{
                System.out.println(" start and end must be integers");
                return this;
            }
        }

    }

    /**
     * This method inserts at an offset index a String in to the current sequence.
     * @param offset - the index to insert the String in to the current sequence.
     * @param str - the string to be inserted in to the sequence.
     * @return - returns the object UndoableStringBuilder with its sequence updated via the method
     */
    public UndoableStringBuilder insert(int offset, String str){

        try{
            this.stack.push(sequence.toString());
            this.sequence.insert(offset, str);
            return this;
        } catch (Exception e){
            if(offset < 0){
                System.out.println("Offset must be equal or greater than 0");
            } else if (offset > sequence.length())
                System.out.println("offset must be equal or smaller than sequence's length");
            return this;
        }

    }

    /**
     * This method replaces a sub-sequence from the current sequence with a String.
     * @param start - The starting index of the sub-sequence.
     * @param end - The ending index of the sub-sequence.
     * @param str - The String that replaces the sub-sequence.
     * @return - returns our object UndoableStringBuilder with its sequence updated via the method
     */
    public UndoableStringBuilder replace(int start,int end, String str){

        try{
            this.stack.push(sequence.toString());
            this.sequence.replace(start, end, str);
            return this;
        } catch (Exception e){
            if(str == null){
                System.out.println("cant replace with null");
            }
            if(start < 0){
                System.out.println("start must be equal or greater than 0");
            } else if (start > end){
                System.out.println("start must be equal or smaller than end");
            } else if(start > sequence.length()){
                System.out.println("start must be equal or smaller than sequences length");
            }

            return this;
        }

    }

    /**
     * This method reverses the current sequence.
     * @return - returns our object UndoableStringBuilder with its sequence updated via the method
     */
    public UndoableStringBuilder reverse(){
        this.stack.push(sequence.toString());
        this.sequence.reverse();
        return this;
    }

    /**
     * This method returns the String value (rather than the memory value) of the current sequence.
     * @return - returns the sequence.
     */
    public String toString(){
        return this.sequence.toString();
    }


}


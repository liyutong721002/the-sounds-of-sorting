package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T>{
    private int destination;
    private T val;
    
    public CopyEvent(int destination, T val) {
        this.destination = destination;
        this.val = val;
    }

    public void apply(T[] arr) {
        arr[destination] = val;
    }

    public List<Integer> getAffectedIndices() {
        List<Integer> l = new ArrayList<Integer>();
        l.add(destination);
        return l;
    }

    public boolean isEmphasized() {
        return true; 
    }
}

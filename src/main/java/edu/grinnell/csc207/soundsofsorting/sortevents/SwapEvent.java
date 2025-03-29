package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> implements SortEvent<T>{
    private int index1; 
    private int index2;

    public SwapEvent(int index1, int index2) {
        this.index1 = index1;
        this.index2 = index2;
    }

    public void apply(T[] arr) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public List<Integer> getAffectedIndices() {
        List<Integer> l = new ArrayList<Integer>();
        l.add(index1);
        l.add(index2);
        return l;
    }

    public boolean isEmphasized() {
        return true; 
    }
}

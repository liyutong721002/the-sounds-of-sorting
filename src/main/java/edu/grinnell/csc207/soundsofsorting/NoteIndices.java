package edu.grinnell.csc207.soundsofsorting;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {
    
    private List<Integer> indices;
    private List<Boolean> highlighted;
    private int size;
    
    /**
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
        initializeAndShuffle(n);
    }
    
    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size.  The collection is also shuffled to provide an
     * initial starting point for the sorting process.
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
        indices = new ArrayList<Integer>();
        highlighted = new ArrayList<Boolean>(Collections.nCopies(n, false));

        for (int i = 0; i < n; i++) {
            indices.add(i);
        }

        Collections.shuffle(indices);
        size = n;
    }
    
    /** @return the indices of this NoteIndices object */
    public Integer[] getNotes() { 
        Integer[] arr = new Integer[size];
        return indices.toArray(arr);
    }
    
    /**
     * Highlights the given index of the note array
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        if (index >= 0 && index < highlighted.size()) {
            highlighted.set(index, true);
        }
    }
    
    /**
     * @param index the index to check
     * @return true if the given index is highlighted
     */
    public boolean isHighlighted(int index) {
        return index >= 0 && index < highlighted.size() && highlighted.get(index);
    }
    
    /** Clears all highlighted indices from this collection */
    public void clearAllHighlighted() {
        highlighted = new ArrayList<Boolean>(Collections.nCopies(size, false));
    }
}

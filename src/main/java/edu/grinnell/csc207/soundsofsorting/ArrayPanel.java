package edu.grinnell.csc207.soundsofsorting;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {
    @SuppressWarnings("unused")
    private NoteIndices notes;
    private int width;
    private int height;
    private int r, g, b;
   
    /**
     * Create a new <code>ArrayPanel</code> with the given notes and dimensions.
     * @param notes the note indices 
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(width, height));
        r = 0;
        g = 0;
        b = 255;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("Repainting ArrayPanel");
        Integer[] indices = notes.getNotes();
        System.out.println(java.util.Arrays.toString(notes.getNotes()));
        int barWidth = width / indices.length;
        for (int i = 0; i < indices.length; i++) {
            int barHeight = (int) ((double) (indices[i] + 1) / indices.length * height);
            this.b = (int) ((double) 255 / indices.length ) * indices[i];
            this.g = 255 - this.b;
            g.setColor(new Color(r, this.g, b));
            g.fillRect(i * barWidth, height - barHeight, barWidth, barHeight);
        }
    }
}
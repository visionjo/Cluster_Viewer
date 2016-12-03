/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.FileNotFoundException;
import java.util.Vector;
import javax.swing.JPanel;

/**
 *
 * @author Tim
 */

// to represent the view for unclustered samples (i.e. unrelated/unknown)
public class Unclustered extends ASampleView {
    // Unrelated: -1, Unknown: 0
    String type;
    
    public Unclustered(String fid, int cluster, Vector fnames) {
        super(fid, cluster, fnames);
        
        // init panel
        this.panel = new JPanel();
        
        // check for valid cluster
        switch (this.cluster) {
            case -1:
                this.type = "Unrelated";
                break;
            case 0:
                this.type = "Unknown";
                break;
            default:
                throw new IllegalArgumentException("Invalid cluster");
        }
        
        // load the images into the panel
        try {
            this.loadImgs();
        } catch (FileNotFoundException ef) { }
    }
}

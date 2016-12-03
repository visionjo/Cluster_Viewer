/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.util.Vector;
import javax.swing.JPanel;

/**
 *
 * @author Tim
 */

// to represent a grid of sample images for a specific cluster
public class ClusterGrid extends ASampleView {

    // grid where samples will appear
    private GridLayout photoGrid;
    
    // rows and columns for grid
    private int row, col;
    
    // gaps between sample images
    private final int vGap  = 10;
    private final int hGap = 5;
    
    public ClusterGrid(String fid, int cluster, Vector fnames) {
        super(fid, cluster, fnames);
        
        // initialize the grid and panel
        this.initGrid();
        
        this.panel.setName("ClusterGrid: " + fid);
        
        // load the images into the grid
        try {
            this.loadImgs();
        } catch (FileNotFoundException ef) { }     
    }
    
    private void initGrid() {
        // set the rows and columns
        this.photoGrid = new GridLayout(5, 4);
        
        // set the gaps between images
        photoGrid.setHgap(this.hGap);
        photoGrid.setVgap(this.vGap);
        
        // init JPanel
        this.panel = new JPanel(this.photoGrid);
    }
}

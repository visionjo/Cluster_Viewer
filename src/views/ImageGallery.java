/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Tim
 */
// to represent the gallery of ClusterGrids displayed when user selects an FID
public class ImageGallery extends javax.swing.JFrame {
    // FID
    String fid;
    
    // the clusters displayed as grids
    Vector<ClusterGrid> grids;
    
    // the layout for the clusters
    GridLayout clusters;
    
    // Panel where ClusterGrids are placed
    JPanel container;
    
    // scrollbar
    JScrollPane scrollPane;
    
    // width and height for grid
    int row;
    final int col = 2;
            
    public ImageGallery(Vector<ClusterGrid> grids, String fid) { 
        this.fid = fid;
        this.grids = grids;
        
        // initialize the gallery to a GridLayout of Clusters
        this.initGallery();
        
        // add the ClusterGrids to the Gallery
        this.addClusters();
        
        this.setName("ImageGallery");
        
        // FOR NOW
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    // initialze the Gallery
    private void initGallery() {
        // title
        setTitle("Clusters for: " + this.fid);
        
        // set the row size based on the amount of clusters
        this.row = (int)Math.ceil(grids.size() / 2.0);
        this.clusters = new GridLayout(this.row, this.col);
        
        // set the gaps between clusters
        this.clusters.setHgap(10);
        this.clusters.setVgap(50);
        
        // add initialize GridLayout to the gallery
        this.container = new JPanel(this.clusters);
        
        // init scrollbar
        this.scrollPane = new JScrollPane(container);
        this.add(scrollPane, BorderLayout.CENTER);
        
        // set position/size
        this.setPos();
    }
    
    // set the position of the gallery to the right-half of the screen
    private void setPos() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        this.setSize(1000, (int)rect.getMaxY() - 50);
        int x = (int) rect.getMaxX() - this.getWidth();
        int y = 0;
        this.setLocation(x,y);
    }
    
    // add the clusters to the Panel
    private void addClusters() {
        int size = this.grids.size();
        for (ClusterGrid cg : this.grids) {
            JPanel jp = cg.getPanel();
            jp.setBorder(BorderFactory.createTitledBorder(createLineBorder(
                    Color.BLACK), "Cluster ID: " + cg.getCluster()));
            this.container.add(jp);
        }
    }
    
    // updates the grids when a Sample's cluster is changed
    public void updateGrids(Sample samp, int val) {
        this.setVisible(false);
        if (val < 1) {
            SwingUtilities.getRoot(this);
            System.out.println();
        }
        else {
        for (ClusterGrid cg : this.grids) {
            // find the grid with the new cluster value and add the sample
            if (cg.cluster == val) {
                cg.add(samp);
            }
            // find the grid with the old cluster value and remove the sample
            if (cg.cluster == samp.cluster) {
                cg.remove(samp);
            }
        }
        }
        this.setVisible(true);
    }
    
    public void setDefaultFocus(Sample samp) {
        ClusterGrid foc = null;
        for (ClusterGrid cg : this.grids) {
            if (cg.cluster == samp.cluster) {
                foc = cg;
                foc.getFirst().requestFocus();
            }
            else {
                System.out.println("ERRORERRORERROR");
            }
        }
    }
}

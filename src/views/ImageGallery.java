/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import static javax.swing.BorderFactory.createLineBorder;

/**
 *
 * @author Tim
 */
// to represent the gallery of ClusterGrids displayed when user selects an FID
public class ImageGallery extends javax.swing.JFrame {
    // FID
    String fid;
    
    // the clusters displayed as grids
    Vector<ASampleView> grids;
    
    // the layout for the clusters
    WrapLayout clusters;
    
    // Panel where ClusterGrids are placed
    JPanel container;
    
    // scrollbar
    JScrollPane scrollPane;
    
    // width and height for grid
    int row;
    final int col = 2;
    
    public Logger logger = Logger.getLogger("MyLog");  
    FileHandler fh;  
            
    public ImageGallery(Vector<ASampleView> grids, String fid) { 
        this.fid = fid;
        this.grids = grids;
        try {
            this.fh = new FileHandler(System.getProperty("user.dir") + "/log.log");
            logger.addHandler(this.fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException e) { }
        logger.info("Family: " + this.fid + " images loaded");
        // initialize the gallery to a GridLayout of Clusters
        this.initGallery();
        
        // add the ClusterGrids to the Gallery
        this.addClusters();
        
        this.setName("ImageGallery");
        this.pack();
    }
    
    // initialze the Gallery
    private void initGallery() {
        // title
        setTitle("Clusters for: " + this.fid);
        
        // set the row size based on the amount of clusters
        this.row = (int)Math.ceil(grids.size() / 2.0);
        this.clusters = new WrapLayout(FlowLayout.LEFT);
        
        // set the gaps between clusters
        this.clusters.setHgap(10);
        this.clusters.setVgap(10);
        
        // add initialize GridLayout to the gallery
        this.container = new JPanel(this.clusters);
        
        // init scrollbar
        this.scrollPane = new JScrollPane(container);
        this.scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        this.add(scrollPane, BorderLayout.CENTER);
        
        // set position/size
        this.setPos();
    }
    
    // set the position of the gallery to the right-half of the screen
    private void setPos() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        this.setSize(1650, (int)rect.getMaxY() - 50);
        int x = (int) rect.getMaxX() - (this.getWidth());
        int y = 0;
        this.setLocation(x,y);
    }
    
    // add the clusters to the Panel
    private void addClusters() {
        int size = this.grids.size();
        for (ASampleView cg : this.grids) {
            JPanel jp = cg.getPanel();
            int cluster = cg.getCluster();
            if (cluster == -1) {
                jp.setBorder(BorderFactory.createTitledBorder(createLineBorder(
                    Color.BLACK), "Unrelated: '-'", 0, 0, new Font("Arial", 
                            Font.PLAIN, 16)));
            }
            else if (cluster == 0) {
                jp.setBorder(BorderFactory.createTitledBorder(createLineBorder(
                    Color.BLACK), "Unknown: '0'", 0, 0, new Font("Arial", 
                            Font.PLAIN, 16)));
            }
            else {
                jp.setBorder(BorderFactory.createTitledBorder(createLineBorder(
                    Color.BLACK), "Cluster ID: " + cg.getCluster(), 0, 0, 
                    new Font("Arial", Font.PLAIN, 16)));
            }
            this.container.add(jp);
        }
        this.pack();
    }
    
    // updates the grids when a Sample's cluster is changed
    public void updateGrids(Sample samp, int val) {
        int row, col;
        for (ASampleView cg : this.grids) {
            // find the grid with the new cluster value and add the sample
            if (cg.cluster == val) {
                cg.add(samp);
                col = 5 + (cg.ref_sample.size() / 24);
                if (cg.ref_sample.size() < 5) {
                    col = cg.ref_sample.size();
                }
                row = (int)Math.ceil(cg.ref_sample.size() / (double)col);
                if (col == 0) {
                    col = 1;
                }
                if (row == 0) {
                    row = 1;
                }
                GridLayout g = (GridLayout)cg.getPanel().getLayout();
                g.setRows(row);
                g.setColumns(col);
            }
            // find the grid with the old cluster value and remove the sample
            if (cg.cluster == samp.cluster) {
                cg.remove(samp);
                col = 5 + (cg.ref_sample.size() / 24);
                if (cg.ref_sample.size() < 5) {
                    col = cg.ref_sample.size();
                }
                row = (int)Math.ceil(cg.ref_sample.size() / (double)col);
                if (col == 0) {
                    col = 1;
                }
                if (row == 0) {
                    row = 1;
                }
                GridLayout g = (GridLayout)cg.getPanel().getLayout();
                g.setRows(row);
                g.setColumns(col);
            }
            cg.revalidate();
        }
        this.revalidate();
    }
    
    // glitchy, usually doesn't work like I want it to
    public void setDefaultFocus(Sample samp) {
        ASampleView foc = null;
        for (ASampleView cg : this.grids) {
            if ((cg.cluster == samp.cluster) && !cg.ref_sample.isEmpty()) {
                foc = cg;
                foc.getFirst().requestFocus();
            }
        }
    }
    
    public void finalize(String outPath) throws IOException {
        PrintWriter pw = new PrintWriter(new File(outPath));
        StringBuilder builder = new StringBuilder();
        builder.append("Ids,Confidence,FilePath" + "\n");
        for (ASampleView cg : this.grids) {
            for (Sample s: cg.ref_sample) {
                builder.append(s.cluster + ",");
                // placeholder for confidence
                builder.append("-1" + ",");
                builder.append(s.path + "\n");
            }
        }
        pw.write(builder.toString());
        pw.close();
        logger.info("Family: " + this.fid + " clusters finalized");
    }
    
    public void logTxt(String text) {
        logger.info(text);    
    }
}

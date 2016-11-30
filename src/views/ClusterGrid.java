/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/**
 *
 * @author Tim
 */

/*
    TODO:
     - determine rows & columns based on size of fnames
     - center images (glue?)
     - unrelated/unknown panel functionality
     - add cluster id, name of person to each window
*/

// to represent a grid of sample images for a specific cluster
public class ClusterGrid extends JFrame {
    
    // filenames of the samples
    private Vector<String> imageFileNames;
    
    // vector of loaded images that will be converted to ImageIcons and set on
    // JLabels
    private Vector<BufferedImage> images;

    // grid where samples will appear
    private GridLayout photoGrid;
    
    // vector of JLabels, each will be added to the JPanel
    private Vector<JLabel> labels;
    
    // panel where the grid is placed
    private JPanel panel;
    
    // rows and columns for grid
    private int row, col;
    
    // gaps between sample images
    private final int vGap  = 10;
    private final int hGap = 10;
    
    // directory for sample images
    private String imagedir = System.getProperty("user.dir") + "/data/FIDs/";
    
    public ClusterGrid(Vector fnames) {
        this.imageFileNames = new Vector<>(fnames);
        
        // set the title, size, and window to the center of the screen
        setTitle("ClusterGrid test");
        setSize(500, 500);
        setLocationRelativeTo(null);
        
        // initialize the grid and panel
        this.photoGrid = new GridLayout(4, 3);
        photoGrid.setHgap(this.hGap);
        photoGrid.setVgap(this.vGap);
        this.panel = new JPanel(this.photoGrid);
        
        // initialize the JLabels and load the images
        this.labels = new Vector<JLabel>();
        this.images = new Vector<BufferedImage>();
        this.initLabels();
        try {
            this.loadImgs();
        } catch (FileNotFoundException ef) { }
        
        // add the completed JPanel to the JFrame
        this.add(panel);
    }
    
    // load the Images as BufferedImages, then 
    void loadImgs() throws FileNotFoundException {
        BufferedImage img = null;
        Image imgRS;
        int count = 0;
        for (String f : this.imageFileNames) {
            try {
                // read the image
                img = ImageIO.read(new File(this.imagedir + f));
                // resize the image
                imgRS = this.getScaledImage(img, 100, 100);
                // add the image as an ImageIcon to each JLabel in the JPanel
                this.labels.get(count).setIcon(new ImageIcon(imgRS));
                count++;
            }
            catch (FileNotFoundException ef) {
                System.out.println("File not found");
            }
            catch (IOException e) { }
            this.images.add(img);
        }
    }
    
    // initialize the Vector of JLabels and add each JLabel to the JPanel
    void initLabels() {
        for (int i = 0; i < this.imageFileNames.size(); i++) {
            this.labels.add(new JLabel());
            panel.add(this.labels.get(i));
        }
    }
    
    /**
     * Resizes an image using a Graphics2D object backed by a BufferedImage.
     * @param srcImg - source image to scale
     * @param w - desired width
     * @param h - desired height
     * @return - the new resized image
     */
    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, 
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }
}

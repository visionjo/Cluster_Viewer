/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Tim
 */
// to represent an abstract view for samples, either a grid of clustered images,
// or in an unrelated/unknown panel
public class ASampleView extends JPanel {
    // family ID
    String fid;
    
    // cluster number of this fid
    int cluster;
    
    // filenames of the samples
    Vector<String> fnames;
    
    // panel where the grid is placed
    JPanel panel;
    
    // directory for sample images
    String imagedir = System.getProperty("user.dir") + "/data/FIDs/";
    
    // reference to samples in this view (FOR CHANGING CLUSTERS)
    Vector<Sample> ref_sample;
    
    ASampleView(String fid, int cluster, Vector fnames) {
        this.fid = fid;
        this.cluster = cluster;
        this.fnames = fnames;
        this.ref_sample = new Vector<>();
    }
    
    // load the Images as BufferedImages, resizes them to 75x75 pixels, creates
    // a sample from the images, and adds the samples to the panel
    final void loadImgs() throws FileNotFoundException {
        BufferedImage img = null;
        Sample samp;
        for (String f : this.fnames) {
            try {
                // read the image
                img = ImageIO.read(new File(this.imagedir + f));

                // add the resized image as a Sample to the JPanel
                samp = new Sample(this.getScaledImage(img, 75, 75), "Name",
                        this.cluster);
                samp.setHorizontalAlignment(JLabel.CENTER);
                panel.add(samp);
                this.ref_sample.add(samp);
            }
            catch (FileNotFoundException ef) {
                System.out.println("File not found");
            }
            catch (IOException e) { }
        }
    }
    
    // gets the cluster associated with this view
    public int getCluster() {
        return this.cluster;
    }
    
    // returns the JPanel filled with Samples in a grid
    public JPanel getPanel() {
        return this.panel;
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
    
    public void add(Sample samp) {
        this.ref_sample.add(samp);
        this.updateSamps();
    }
    
    public void remove(Sample samp) {
        this.ref_sample.remove(samp);
        this.updateSamps();
    }
    
    private void updateSamps() {
        this.panel.removeAll();
        for (Sample s : this.ref_sample) {
            this.panel.add(s);
        }
    }
}

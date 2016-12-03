/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Tim
 */

// to represent an image with button functionality
public class Sample extends JLabel {
    Image img;
    
    // sample name
    String name;
    
    // the cluster in its fid
    int cluster;
    
    Sample(Image img, String name, int cluster) {
        this.img = img;
        this.name = name;
        this.cluster = cluster;
        this.setIcon(new ImageIcon(img));
        
        // Set the border with the name of the sample
        this.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEmptyBorder(), name));
    }
    
    // called when user changes cluster of Sample
    void update(int clusterNew) {
        this.cluster = clusterNew;
    }
    
}


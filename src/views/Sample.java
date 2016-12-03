/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Tim
 */

// to represent an image with button functionality
public class Sample extends JButton {
    Image img;
    
    // sample name
    String name;
    
    // the cluster in its fid
    int cluster;
    
    // Borders
    TitledBorder noFocus = BorderFactory.createTitledBorder(
                BorderFactory.createEmptyBorder(), this.name);
    TitledBorder focused = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.RED, 5), this.name);
    
    Sample(Image img, String name, int cluster) {
        this.img = img;
        this.name = name;
        this.cluster = cluster;
        this.setIcon(new ImageIcon(img));
        
        // Set the border with the name of the sample
        this.setBorder(this.noFocus);
        
        // removes the "button" look
        this.setContentAreaFilled(false);
        
        // set keylistener
        this.addKeyListener(new KeyListener() {
            SwingUtilities util;
            
            @Override
            public void keyTyped(KeyEvent e) {
                int ke = Character.getNumericValue(e.getKeyChar());
                if (ke != Sample.this.cluster && ke >= -1) {
                    Component c = SwingUtilities.getRoot(Sample.this);
                    if (c instanceof ImageGallery) {
                        ImageGallery ig = (ImageGallery)c;
                        ig.updateGrids(Sample.this, ke);
                    }
                    else if (c instanceof Unclustered) {
                        ASampleView un = (Unclustered)c;
                        un.remove(Sample.this);
                        
                    }
                    Sample.this.upCluster(ke);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) { }

            @Override
            public void keyReleased(KeyEvent e) { }
            
        });
        
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // add border
                Sample.this.setBorder(Sample.this.focused);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Set focus to first in unknown
                
                // remove border
                Sample.this.setBorder(Sample.this.noFocus);

            }
            
        });
    }
    
    // called when user changes cluster of Sample, updates to new cluster
    public void upCluster(int clusterNew) {
        System.out.println("Changed from " + this.cluster + " to " + clusterNew);
        this.cluster = clusterNew;
    }
    
}


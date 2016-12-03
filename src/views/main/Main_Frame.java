/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.main;


import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import utils.Configurations;
import utils.Parse_FID_LUT;
import utils.Parse_Face_LUT;
import views.About;

import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import utils.Sample_LUT;
import views.ASampleView;
import views.ClusterGrid;
import views.ImageGallery;
import views.Sample;
import views.Unclustered;

/**
 *
 * @author jrobby
 */
public class Main_Frame extends javax.swing.JFrame {
    
    // <editor-fold defaultstate="collapsed" desc="Global Vars">
    Configurations configs; 
    public HashMap<Integer, String>   face_lut;
    public HashMap<Integer, String>   fid_lut;
    public Sample_LUT   sample_ids_lut; // sample ID to FID
    public Sample_LUT  cluster_ids_lut; // sample ID to Cluster ID
    String cfid; // current FID
   // ImageGallery Ig;
    
    //</editor-fold>
       
    /**
     * Main_Frame(): Creates new form Main_Frame
     */
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public Main_Frame() {
        configs = new Configurations();
        initComponents();
        get_luts();
        //this.Ig = null;
        
        sample_ids_lut = new Sample_LUT(configs.f_sample_lut, configs.do_debug);
        sample_ids_lut.readLUT();
        
        cluster_ids_lut = new Sample_LUT(configs.f_cluster_ids, configs.do_debug);
        cluster_ids_lut.readLUT();
        
        this.setName("Main_Frame");
        
    }
    //</editor-fold>
    
       
    /**
     * Method to read in both FID and FaceID LUTs.
     */
    private void get_luts()
    {       
        Parse_Face_LUT pface = new Parse_Face_LUT(configs.f_face_lut, configs.do_debug);
        pface.readLUT();
        face_lut = pface.getLUT();

        Parse_FID_LUT pfid = new Parse_FID_LUT(configs.f_fid_lut, configs.do_debug);
        pfid.readLUT();
        fid_lut = pfid.getLUT();
        
        set_window_state();
    }
       
    private void set_window_state() {                                       
        // Set the appropriate state of all components of main GUI (ie this)
        set_fid_cbox();
        if (cb_fids.getItemCount()>0)
            b_go.setEnabled(true);
        else
            b_go.setEnabled(false);
        this.set_sPanes();
               
    }
    
    private void set_fid_cbox() {                                       
        // Set the appropriate state of all components of main GUI (ie this)
        Set<Integer> fid_ids = fid_lut.keySet();
        // sort by key
        TreeSet sortedSet = new TreeSet<>(fid_ids);

        for (Iterator<Integer> it = sortedSet.iterator(); it.hasNext();) {
            int f = it.next();
            String fid = fid_lut.get(f);
            cb_fids.addItem(fid);
            if (configs.do_debug) {
                System.out.println("Adding " + fid + " to list menu");
            }
        }
    }
    
    private void set_sPanes() {
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_south = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        b_go = new javax.swing.JButton();
        cb_fids = new javax.swing.JComboBox<>();
        b_next = new javax.swing.JButton();
        b_prev = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tf_ids_fin = new javax.swing.JTextField();
        tf_ids_fout = new javax.swing.JTextField();
        l_ids_out = new javax.swing.JLabel();
        l_ids_in = new javax.swing.JLabel();
        b_load = new javax.swing.JButton();
        b_save = new javax.swing.JButton();
        p_north = new javax.swing.JPanel();
        sp_unknown = new javax.swing.JScrollPane();
        sp_unrelated = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mn_file = new javax.swing.JMenu();
        mnu_load_database = new javax.swing.JMenuItem();
        mnu_close = new javax.swing.JMenuItem();
        mnu_quit = new javax.swing.JMenuItem();
        mn_help = new javax.swing.JMenu();
        mnu_about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        b_go.setText("Go!");
        b_go.setToolTipText("Press to load clustered faces for FID selected in dropdown menu.");
        b_go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_go_pressed(evt);
            }
        });

        b_next.setText("Next");
        b_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_nextActionPerformed(evt);
            }
        });

        b_prev.setText("Prev");
        b_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_prevActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_prev)
                .addGap(96, 96, 96)
                .addComponent(cb_fids, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(b_go)
                .addGap(63, 63, 63)
                .addComponent(b_next)
                .addGap(196, 196, 196))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_next, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_prev, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_fids, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_go))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("File Settings"));

        tf_ids_fin.setText("<CSV Filepath>");
        tf_ids_fin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ids_finActionPerformed(evt);
            }
        });

        tf_ids_fout.setText("<CSV Filepath>");
        tf_ids_fout.setEnabled(false);
        tf_ids_fout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ids_foutActionPerformed(evt);
            }
        });

        l_ids_out.setText("Cluster IDs out:");
        l_ids_out.setEnabled(false);

        l_ids_in.setText("Cluster IDs in:");

        b_load.setText("Okay");
        b_load.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        b_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_load_pressed(evt);
            }
        });

        b_save.setText("Okay");
        b_save.setEnabled(false);
        b_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_ids_in, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(l_ids_out, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tf_ids_fout, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(b_save))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tf_ids_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(b_load)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_ids_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_ids_in)
                    .addComponent(b_load))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_ids_fout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_ids_out)
                    .addComponent(b_save)))
        );

        javax.swing.GroupLayout p_southLayout = new javax.swing.GroupLayout(p_south);
        p_south.setLayout(p_southLayout);
        p_southLayout.setHorizontalGroup(
            p_southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_southLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        p_southLayout.setVerticalGroup(
            p_southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_southLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Unrelated [-]");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Unknown [0]");

        javax.swing.GroupLayout p_northLayout = new javax.swing.GroupLayout(p_north);
        p_north.setLayout(p_northLayout);
        p_northLayout.setHorizontalGroup(
            p_northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_northLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp_unknown, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(p_northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(sp_unrelated, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        p_northLayout.setVerticalGroup(
            p_northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_northLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sp_unknown, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(sp_unrelated))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        mn_file.setText("File");

        mnu_load_database.setText("Load Database");
        mn_file.add(mnu_load_database);

        mnu_close.setText("Close Database");
        mn_file.add(mnu_close);

        mnu_quit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        mnu_quit.setText("Quit");
        mnu_quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_quitActionPerformed(evt);
            }
        });
        mn_file.add(mnu_quit);

        jMenuBar1.add(mn_file);

        mn_help.setText("Help");

        mnu_about.setText("About");
        mnu_about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_aboutActionPerformed(evt);
            }
        });
        mn_help.add(mnu_about);

        jMenuBar1.add(mn_help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_south, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(p_north, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(p_north, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_south, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnu_quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_quitActionPerformed

        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_mnu_quitActionPerformed

    private void mnu_aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_aboutActionPerformed

        About ab = new About();
        ab.setAlwaysOnTop(true);
        ab.setVisible(true);
    }//GEN-LAST:event_mnu_aboutActionPerformed

    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_saveActionPerformed

    private void b_load_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_load_pressed

    }//GEN-LAST:event_b_load_pressed

    private void tf_ids_foutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ids_foutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ids_foutActionPerformed

    private void tf_ids_finActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ids_finActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ids_finActionPerformed

    private void b_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_prevActionPerformed
        // TODO add your handling code here:
        try {
            this.cb_fids.setSelectedIndex(this.cb_fids.getSelectedIndex() - 1);
        }
        catch(IllegalArgumentException e) { }
    }//GEN-LAST:event_b_prevActionPerformed

    private void b_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_nextActionPerformed
        // TODO add your handling code here:
        try {
            this.cb_fids.setSelectedIndex(this.cb_fids.getSelectedIndex() + 1);
        }
        catch (IllegalArgumentException e) { }
    }//GEN-LAST:event_b_nextActionPerformed

    private void b_go_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_go_pressed
        // Load current FID selected in drop down menu
        int ind = cb_fids.getSelectedIndex();
        if (ind == -1) {
            //custom title, error icon
            JOptionPane.showMessageDialog(new JFrame(),
                "Must select FID.",
                "Loading Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        cfid = cb_fids.getItemAt(ind);

        System.out.println("Faces for FID : " + cfid);
        // all images for current FID (i.e., images to be displayed)

        this.initGallery();

    }//GEN-LAST:event_b_go_pressed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Frame().setVisible(true);
            }
        });
    }

 // class id for images


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_go;
    private javax.swing.JButton b_load;
    private javax.swing.JButton b_next;
    private javax.swing.JButton b_prev;
    private javax.swing.JButton b_save;
    private javax.swing.JComboBox<String> cb_fids;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel l_ids_in;
    private javax.swing.JLabel l_ids_out;
    private javax.swing.JMenu mn_file;
    private javax.swing.JMenu mn_help;
    private javax.swing.JMenuItem mnu_about;
    private javax.swing.JMenuItem mnu_close;
    private javax.swing.JMenuItem mnu_load_database;
    private javax.swing.JMenuItem mnu_quit;
    private javax.swing.JPanel p_north;
    private javax.swing.JPanel p_south;
    private javax.swing.JScrollPane sp_unknown;
    private javax.swing.JScrollPane sp_unrelated;
    private javax.swing.JTextField tf_ids_fin;
    private javax.swing.JTextField tf_ids_fout;
    // End of variables declaration//GEN-END:variables

    public void initGallery() {
        Vector<String> fid_paths = new Vector<>();
        Vector<Integer> sample_ids = sample_ids_lut.get(cfid);

        String fpath = configs.d_images + "/" + cfid;
        // The Iterator object is obtained using iterator() method
        
        Iterator it = sample_ids.iterator();
        // To iterate through the elements of the collection we can use hasNext() and next() methods of Iterator
        
        Vector<ClusterGrid> grids = new Vector();
        Vector<String> fid_paths_unknown = new Vector();
        Vector<String> fid_paths_unrelated = new Vector();

        int count = 1; // for testing only! Adds 12 members to each grid
        int cluster = -1; // for testing only, each 12 members is a cluster
        while(it.hasNext()) {
            // Unknown ID = -1, if cluster is -1, add to unknown panel
            if (cluster == -1) {
                fid_paths_unknown.add(face_lut.get(it.next()));
                if (count % 12 == 0) {
                    cluster++;
                    count = 1;
                }
            }
            // Unrelated ID = 0, if cluster is 0, add to unrelated panel
            else if (cluster == 0) {
                fid_paths_unrelated.add(face_lut.get(it.next()));
                if (count % 12 == 0) {
                    cluster++;
                    count = 1;
                }
            }
            else {
                fid_paths.add(face_lut.get(it.next()));
            }
            if (count % 12 == 0 && cluster > 0) {
                // add a new ClusterGrid to the Vector
                grids.add(new ClusterGrid(cfid, cluster, fid_paths));
                fid_paths.clear();
                cluster++;
            }
            count++;
        }
        
        // Create and set visible the unrelated/unknown scrollpanels and the
        // main image gallery
        ASampleView uc = new Unclustered(cfid, -1, fid_paths_unknown);
        this.sp_unknown.setViewportView(uc.getPanel());
        ASampleView ur = new Unclustered(cfid, 0, fid_paths_unrelated);
        this.sp_unrelated.setViewportView(ur.getPanel());
        ImageGallery Ig  = new ImageGallery(grids, cfid);
        
        Ig.setVisible(true);
        
    }
}

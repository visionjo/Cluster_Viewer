/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.main;


import java.util.Vector;
import utils.Configurations;
import views.About;

/**
 *
 * @author jrobby
 */
public class Main_Frame extends javax.swing.JFrame {
    
    // <editor-fold defaultstate="collapsed" desc="Global Vars">
    Configurations configs;
    //</editor-fold>
       
    /**
     * Main_Frame(): Creates new form Main_Frame
     */
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public Main_Frame() {
        configs = new Configurations();
        initComponents();
        
    }
    //</editor-fold>
    
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
        b_next = new javax.swing.JButton();
        cb_fids = new javax.swing.JComboBox<>();
        b_prev = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        p_central = new javax.swing.JPanel();
        p_north = new javax.swing.JPanel();
        sp_unknown = new javax.swing.JScrollPane();
        sp_unrelated = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mn_file = new javax.swing.JMenu();
        mnu_load_database = new javax.swing.JMenuItem();
        mnu_close = new javax.swing.JMenuItem();
        mnu_quit = new javax.swing.JMenuItem();
        mn_help = new javax.swing.JMenu();
        mnu_about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        b_next.setText("jButton1");

        cb_fids.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        b_prev.setIcon(new javax.swing.ImageIcon("/home/jrobby/Documents/janus/sandbox/jrobinson/Agglomerative/java/Cluster_Viewer/resources/arrowleft.png")); // NOI18N
        b_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_prevActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(b_prev, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cb_fids, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_next)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_prev)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b_next)
                        .addComponent(cb_fids, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("File Settings"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 59, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout p_southLayout = new javax.swing.GroupLayout(p_south);
        p_south.setLayout(p_southLayout);
        p_southLayout.setHorizontalGroup(
            p_southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_southLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_southLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(88, 88, 88))
        );
        p_southLayout.setVerticalGroup(
            p_southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_southLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout p_centralLayout = new javax.swing.GroupLayout(p_central);
        p_central.setLayout(p_centralLayout);
        p_centralLayout.setHorizontalGroup(
            p_centralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        p_centralLayout.setVerticalGroup(
            p_centralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout p_northLayout = new javax.swing.GroupLayout(p_north);
        p_north.setLayout(p_northLayout);
        p_northLayout.setHorizontalGroup(
            p_northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_northLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(sp_unknown, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sp_unrelated, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );
        p_northLayout.setVerticalGroup(
            p_northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_northLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(p_northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp_unrelated, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sp_unknown, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        mn_file.setText("File");

        mnu_load_database.setText("Load Database");
        mnu_load_database.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_load_databaseActionPerformed(evt);
            }
        });
        mn_file.add(mnu_load_database);

        mnu_close.setText("Close Database");
        mnu_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_closeActionPerformed(evt);
            }
        });
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(p_north, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(p_central, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(p_south, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p_north, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_central, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(p_south, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_prevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_prevActionPerformed

    private void mnu_load_databaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_load_databaseActionPerformed
        
   
    }//GEN-LAST:event_mnu_load_databaseActionPerformed

    private void mnu_quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_quitActionPerformed

        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_mnu_quitActionPerformed

    private void mnu_aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_aboutActionPerformed

        About ab = new About();
        ab.setAlwaysOnTop(true);
        ab.setVisible(true);
    }//GEN-LAST:event_mnu_aboutActionPerformed

    private void mnu_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_closeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnu_closeActionPerformed

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

 


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_next;
    private javax.swing.JButton b_prev;
    private javax.swing.JComboBox<String> cb_fids;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenu mn_file;
    private javax.swing.JMenu mn_help;
    private javax.swing.JMenuItem mnu_about;
    private javax.swing.JMenuItem mnu_close;
    private javax.swing.JMenuItem mnu_load_database;
    private javax.swing.JMenuItem mnu_quit;
    private javax.swing.JPanel p_central;
    private javax.swing.JPanel p_north;
    private javax.swing.JPanel p_south;
    private javax.swing.JScrollPane sp_unknown;
    private javax.swing.JScrollPane sp_unrelated;
    // End of variables declaration//GEN-END:variables
}

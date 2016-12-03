///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package views;
////package components;
//
//import java.awt.BorderLayout;
//import java.awt.Graphics2D;
//import java.awt.Image;
//import java.awt.RenderingHints;
//import java.awt.event.ActionEvent;
//import java.awt.image.BufferedImage;
//import java.util.List;
//import java.util.Vector;
//import javax.swing.AbstractAction;
//
//import javax.swing.BorderFactory;
//import javax.swing.Box;
//import javax.swing.Icon;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JToolBar;
//import javax.swing.SwingWorker;
//import views.utils.MissingIcon;
///**
// *
// * @author jrob
// */ 
//public class ImageGalleryJoe extends JFrame {
//    private static final long serialVersionUID = 1L;
//    
//    private JLabel photographLabel = new JLabel();
//    private JToolBar buttonBar = new JToolBar();
//    
//    private String imagedir = System.getProperty("user.dir") + "/data/FIDs/";
//    
//    private MissingIcon placeholderIcon = new MissingIcon();
//        
//    /**
//     * List of all the image files to load.
//     */
//     private Vector<String> imageFileNames;
//     
//        public ImageGalleryJoe(Vector fnames) {
//            imageFileNames = new Vector<>(fnames);
////            imageFileNames = new String(fnames);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setTitle("Icon Demo: Please Select an Image");
//        
//        // A label for displaying the pictures
//        photographLabel.setVerticalTextPosition(JLabel.BOTTOM);
//        photographLabel.setHorizontalTextPosition(JLabel.CENTER);
//        photographLabel.setHorizontalAlignment(JLabel.CENTER);
//        photographLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//        
//        // We add two glue components. Later in process() we will add thumbnail buttons
//        // to the toolbar inbetween thease glue compoents. This will center the
//        // buttons in the toolbar.
//        buttonBar.add(Box.createGlue());
//        buttonBar.add(Box.createGlue());
//        
//        add(buttonBar, BorderLayout.SOUTH);
//        add(photographLabel, BorderLayout.CENTER);
//        
//        setSize(400, 300);
//        
//        // this centers the frame on the screen
//        setLocationRelativeTo(null);
//        
//        // start the image loading SwingWorker in a background thread
//        loadimages.execute();
//    }
//        
//    /**
//     * SwingWorker class that loads the images a background thread and calls publish
//     * when a new one is ready to be displayed.
//     *
//     * We use Void as the first SwingWroker param as we do not need to return
//     * anything from doInBackground().
//     */
//    private SwingWorker<Void, ThumbnailAction> loadimages = new SwingWorker<Void, ThumbnailAction>() {
//        
//        /**
//         * Creates full size and thumbnail versions of the target image files.
//         */
//        @Override
//        protected Void doInBackground() throws Exception {
//            for (int i = 0; i < imageFileNames.size(); i++) {
//                ImageIcon icon;
//                icon = createImageIcon(imagedir + imageFileNames.get(i), "");
//                
//                ThumbnailAction thumbAction;
//                if(icon != null){
//                    
//                    ImageIcon thumbnailIcon = new ImageIcon(getScaledImage(icon.getImage(), 32, 32));
//                    
//                    thumbAction = new ThumbnailAction(icon, thumbnailIcon, "");
//                    
//                }else{
//                    // the image failed to load for some reason
//                    // so load a placeholder instead
//                    thumbAction = new ThumbnailAction(placeholderIcon, placeholderIcon, "");
//                }
//                publish(thumbAction);
//            }
//            // unfortunately we must return something, and only null is valid to
//            // return when the return type is void.
//            return null;
//        }
//        
//        /**
//         * Process all loaded images.
//         */
//        @Override
//        protected void process(List<ThumbnailAction> chunks) {
//            for (ThumbnailAction thumbAction : chunks) {
//                JButton thumbButton = new JButton(thumbAction);
//                // add the new button BEFORE the last glue
//                // this centers the buttons in the toolbar
//                buttonBar.add(thumbButton, buttonBar.getComponentCount() - 1);
//            }
//        }
//    };
//    
//    /**
//     * Creates an ImageIcon if the path is valid.
//     * @param String - resource path
//     * @param String - description of the file
//     */
//    protected ImageIcon createImageIcon(String path,
//            String description) {
//        return new ImageIcon(path, description);
//    }
//    
//    /**
//     * Resizes an image using a Graphics2D object backed by a BufferedImage.
//     * @param srcImg - source image to scale
//     * @param w - desired width
//     * @param h - desired height
//     * @return - the new resized image
//     */
//    private Image getScaledImage(Image srcImg, int w, int h){
//        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
//        Graphics2D g2 = resizedImg.createGraphics();
//        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//        g2.drawImage(srcImg, 0, 0, w, h, null);
//        g2.dispose();
//        return resizedImg;
//    }
//    
//    /**
//     * Action class that shows the image specified in it's constructor.
//     */
//    private class ThumbnailAction extends AbstractAction{
//        
//        /**
//         *The icon if the full image we want to display.
//         */
//        private Icon displayPhoto;
//        
//        /**
//         * @param Icon - The full size photo to show in the button.
//         * @param Icon - The thumbnail to show in the button.
//         * @param String - The descriptioon of the icon.
//         */
//        public ThumbnailAction(Icon photo, Icon thumb, String desc){
//            displayPhoto = photo;
//            
//            // The short description becomes the tooltip of a button.
//            putValue(SHORT_DESCRIPTION, desc);
//            
//            // The LARGE_ICON_KEY is the key for setting the
//            // icon when an Action is applied to a button.
//            putValue(LARGE_ICON_KEY, thumb);
//        }
//        
//        /**
//         * Shows the full image in the main area and sets the application title.
//         */
//        public void actionPerformed(ActionEvent e) {
//            photographLabel.setIcon(displayPhoto);
//            setTitle("Icon Demo: " + getValue(SHORT_DESCRIPTION).toString());
//        }
//    }
//}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.Vector;


/**
 *
 * @author jrobby
 */
public class Configurations {

    public String f_cluster_ids = "cluster_ids_F0009.csv";
    public String d_root; 
    public String d_data;
    public String d_images;
    public String f_face_lut = "Face_LUT.csv";
    public String f_fid_lut = "FID_LUT.csv";
    public String f_sample_lut = "sample_to_fid.csv";
    public static Vector<String> fids = new Vector();
    public static final String CONFIG_PATH
            = "resources/config.properties";

    private static final String[] CONFIG_KEYS = {"d_images", "f_cluster_ids",
        "FIDS", "DO_DEBUG", "d_data"};
    public boolean do_debug = true;

    public Configurations() {

        Properties prop = new Properties();
        InputStream input = null;

        try {

            d_root = System.getProperty("user.dir") + "/";

            String fpath = d_root + CONFIG_PATH;
            input = new FileInputStream(fpath);

            // load a properties file
            prop.load(input);
            // get the property value and print it out
            d_data = prop.getProperty(CONFIG_KEYS[4]);
            
            f_fid_lut = d_root + d_data + f_fid_lut;
            f_face_lut = d_root + d_data + f_face_lut;
            f_sample_lut = d_root + d_data + f_sample_lut;
            
            d_images = d_root + prop.getProperty(CONFIG_KEYS[0]);
            f_cluster_ids = d_root + d_data + f_cluster_ids;
            String tmp = prop.getProperty(CONFIG_KEYS[2]);

            String[] fid_array = tmp.split(",");

            fids.addAll(Arrays.asList(fid_array));

            tmp = prop.getProperty(CONFIG_KEYS[3]);
            do_debug = "true".equals(tmp.toLowerCase());

            
            if (do_debug) {
                System.out.println("Settings (" + CONFIG_PATH + ")");
                System.out.println("Current working directory : " + d_root);
                System.out.println("Data Directory: " + d_data);
                System.out.println("Image Directory: " + d_images);
                System.out.println("FID LUT: " + f_fid_lut);
                System.out.println("Face LUT " + f_face_lut);
                
                System.out.println(Integer.toString(fids.size()) + " FIDs");
                System.out.println("Cluster assignments located at " + f_cluster_ids);
                System.out.println("Debug mode set on (i.e., VERBOSE = 1)");
            }
       


        } catch (IOException ex) {
            
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                }
            }
        }

    }

}

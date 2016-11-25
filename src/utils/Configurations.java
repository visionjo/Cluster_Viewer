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

    public String f_cluster_ids;
    public static Vector<String> fids = new Vector();
    public static final String CONFIG_PATH
            = "/home/jrobby/Documents/janus/sandbox/jrobinson/Agglomerative/java/Cluster_Viewer/resources/config.properties";

    private static final String[] CONFIG_KEYS = {"d_images", "f_cluster_ids",
        "FIDS", "DO_DEBUG"};
    public boolean do_debug = true;

    public Configurations() {

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream(CONFIG_PATH);

            // load a properties file
            prop.load(input);
            // get the property value and print it out
            prop.getProperty(CONFIG_KEYS[0]);
            f_cluster_ids = prop.getProperty(CONFIG_KEYS[1]);
            String tmp = prop.getProperty(CONFIG_KEYS[2]);

            String[] fid_array = tmp.split(",");

            fids.addAll(Arrays.asList(fid_array));

            tmp = prop.getProperty(CONFIG_KEYS[3]);
            do_debug = "true".equals(tmp.toLowerCase());

            if (do_debug) {
                System.out.println("Settings (" + CONFIG_PATH + ")");
                System.out.println(Integer.toString(fids.size()) + " FIDs");
                System.out.println("Clsuter assignments located at " + f_cluster_ids);
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

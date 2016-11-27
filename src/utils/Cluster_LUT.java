/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author Tim
 */
public class Cluster_LUT {
    
    private String fpath = "";
    public HashMap<Integer, Vector<Integer>> cluster_lut;
    private boolean do_debug = false;
    
    public Cluster_LUT(String fpath) {
        cluster_lut = new HashMap<>();
        this.fpath = fpath;
    }
    
    public Cluster_LUT(String fpath, boolean do_debug) {
        cluster_lut = new HashMap<>();
        this.fpath = fpath;
        this.do_debug = do_debug;
    }
    
    public void set_fpath(String fin) {
        this.fpath = fin;
    }
    
    public void readLUT() {
        BufferedReader br = null;
        String line;
        String cvsSplitBy = ",";
        
        if (do_debug)
                System.out.println("Parsing Sample-to-Cluster CSV: " + fpath);
        
        try {
            br = new BufferedReader(new FileReader(fpath));
            // ignore first row (i.e. headers)
            line = br.readLine();
            
            Vector<Integer> values = new Vector<>();
            int last_cid = -1;
            
            while ((line = br.readLine()) != null) {
                String[] im = line.split(cvsSplitBy);
                
                int samp = Integer.parseInt(im[0]);
                if (Integer.parseInt(im[1]) == last_cid) {
                    values.add(samp);
                }
                else {
                    if (last_cid == -1) {
                        values.add(samp);
                    }
                    else {
                        cluster_lut.put(last_cid, values);
                        if (do_debug)
                            System.out.println("Added " + values.size() + 
                                    "to cluster ID" + last_cid);
                        values = new Vector<>();
                        values.add(samp);
                    }
                    last_cid = Integer.parseInt(im[1]);
                }
            }
            
            
//            // read first line with data and get first cluster ID
//            line = br.readLine();
//            String[] initIm = line.split(cvsSplitBy);
//            
//            int c_val = Integer.parseInt(initIm[1]);
//            values.add(Integer.parseInt(initIm[0]));
//            
//            // add all values for a cluster in vector, then add to HashMap
//            while ((line = br.readLine()) != null) {
//                String[] im = line.split(cvsSplitBy);
//                int samp_id = Integer.parseInt(im[0]);
//                int c_val_cur = Integer.parseInt(im[1]);
//                
//                if (c_val_cur == c_val) {
//                    values.add(samp_id);
//                }
//                else {
//                    this.cluster_lut.put(c_val, values);
//                    if (do_debug)
//                        System.out.println("Added " + values.size() + 
//                                " to cluster " + c_val);
//                    c_val = c_val_cur;
//                    values = new Vector<>();
//                    values.add(samp_id);
//                }
//            }
            
        }
        catch (FileNotFoundException e) {
            System.out.println("Cluster File not found: " + fpath);
        } 
        catch (IOException e) { }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (IOException e) { }
            }
        }
        
        if (do_debug) {
            System.out.println("Done Parsing cluster_ids.csv");
        }
    }
    
    public HashMap getDatabase() {
        return this.cluster_lut;
    }
    
    public Vector get(int cid) {
        return this.cluster_lut.get(cid);
    }
    
}

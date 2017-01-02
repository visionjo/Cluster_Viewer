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
 * @class Parse_FID_LUT
 *
 * Class to parse the ClusterID-to-FID LUT (CSV File).
 *
 * @author Joseph Robinson
 */
public class Parse_Cluster_LUT {
    

   private String                   fpath = "";
   public HashMap<Integer, Vector<String>>   cluster_lut;
   private boolean do_debug = true;
   int max;

   public Parse_Cluster_LUT(String fpath) {
      cluster_lut = new HashMap<>();
      this.fpath = fpath;
      max = this.findMax();
   }
   public Parse_Cluster_LUT(String fpath, boolean do_debug) {
      cluster_lut = new HashMap<>();
      this.fpath = fpath;
      this.do_debug = do_debug;
   }
   
   public void set_fpath(String fin)
   {
       fpath = fin;
   }
   // <editor-fold defaultstate="collapsed" desc="readFidDatabase">
   /**
    * Method to parse FID file containing each ID lookup.
    */
   public void readLUT() {
      BufferedReader br = null;
      String line;
      String cvsSplitBy = ",";

      if (do_debug)
                System.out.println("Parsing Cluster-to-FID csv: " + fpath);
      
      try {
         int count = -1;
         
         while (count <= max) {
             br = new BufferedReader(new FileReader(fpath));
             line = br.readLine();    // ignore first row (i.e., headers)

             // add all values for a single cluster in vector, then add to HashMap
             Vector <String> faces = new Vector<>();
             
             while ((line = br.readLine()) != null) {
                 // use comma as seperator
                 String[] im = line.split(cvsSplitBy);
                  if (Integer.parseInt(im[0]) == count) {
                      String path = im[2];
                      faces.add(path);
                  }
             }
             
             cluster_lut.put(count, faces);
             count++;
          }
      } catch (FileNotFoundException e) {

         System.out.println("FID File not found: " + fpath);
      } catch (IOException e) {
      } finally {
         if (br != null) {
            try {
               br.close();
            } catch (IOException e) {
            }
         }
      }

      if (do_debug) {
         System.out.println("Done Parsing cluster_ids_F0009.csv");
      }
   }// </editor-fold>

   // <editor-fold defaultstate="collapsed" desc="getDatabase">
   /**
    * Method to return <CLUSTER, VECTOR<FPATH>> pairs
    *
    * @return cluster_lut
    */
   public HashMap getLUT() {
      return cluster_lut;
   }// </editor-fold>
   
     
   // <editor-fold defaultstate="collapsed" desc="get">
   /**
     * @param cluster - cluster key to return face samples for
    *
    * @return vector of fpaths for that cluster
    */
   public Vector get(int cluster) {
      return cluster_lut.get(cluster);
   }// </editor-fold>
   
   public int findMax() {
       BufferedReader br = null;
       String line;
       int val = -3;
       try {
           br = new BufferedReader(new FileReader(fpath));
           line = br.readLine();
           while ((line = br.readLine()) != null) {
               String[] im = line.split(",");
               if (Integer.parseInt(im[0]) > val) {
                   val = Integer.parseInt(im[0]);
               }
           }
       }
       catch (IOException e) { }
       System.out.println("MAX: max");
       return val;
   }
   
   
}

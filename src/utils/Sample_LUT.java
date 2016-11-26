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
public class Sample_LUT {
    

   private String                   fpath = "";
   public HashMap<String, Vector<Integer>>   sample_lut;
   private boolean do_debug = false;

   public Sample_LUT(String fpath) {
      sample_lut = new HashMap<>();
      this.fpath = fpath;
   }
   public Sample_LUT(String fpath, boolean do_debug) {
      sample_lut = new HashMap<>();
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
                System.out.println("Parsing FID-to-Sample CSV: " + fpath);
      
      try {
         br = new BufferedReader(new FileReader(fpath));
         line = br.readLine();    // ignore first row (i.e., headers)

         // add all values for a single FID in vector, then add to HashMap
         Vector <Integer> values = new Vector<>();
         String last_fid = "";
         
         while ((line = br.readLine()) != null) {
             
            // use comma as separator
            String[] im = line.split(cvsSplitBy);

            int value = Integer.parseInt(im[0]);
            if (im[1].equals(last_fid))
            {
                values.add(value);
                
            } else {
                
                
                if (last_fid.equals(""))
                {
                    values.add(value);
                }else{
                    sample_lut.put(last_fid, values);
                    if (do_debug)
                        System.out.println("Added " + values.size()
                                + " to FID " + last_fid);
                    
                    values = new Vector<>();
                    values.add(value);
                }
                last_fid = im[1];
                
             }
            
            
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
         System.out.println("Done Parsing FID_DB.csv");
      }
   }// </editor-fold>

   // <editor-fold defaultstate="collapsed" desc="getDatabase">
   /**
    * Method to return <ID, FID> pairs
    *
    * @return sample_lut
    */
   public HashMap getDatabase() {
      return sample_lut;
   }// </editor-fold>
   
     
   // <editor-fold defaultstate="collapsed" desc="get">
   /**
     * @param fid - FID key to return face samples for
    *
    * @return vector of samples for that fid
    */
   public Vector get(String fid) {
      return sample_lut.get(fid);
   }// </editor-fold>
   
   
}

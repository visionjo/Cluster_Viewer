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

/**
 * @class Parse_FID_LUT
 *
 * Class to parse the ClusterID-to-FID LUT (CSV File).
 *
 * @author Joseph Robinson
 */
public class Parse_FID_LUT {
    

   private String                   fpath;
   public HashMap<Integer, String>   fid_lut;
   private boolean do_debug = false;

   public Parse_FID_LUT(String fpath) {
      fid_lut = new HashMap<>();
      this.fpath = fpath;
   }
   public Parse_FID_LUT(String fpath, boolean do_debug) {
      fid_lut = new HashMap<>();
      this.fpath = fpath;
      this.do_debug = do_debug;
   }
   
   // <editor-fold defaultstate="collapsed" desc="readFidDatabase">
   /**
    * Method to parse FID file containing each ID lookup.
    */
   public void readLUT() {
      BufferedReader br = null;
      String line;
      String cvsSplitBy = ",";

      try {
         br = new BufferedReader(new FileReader(fpath));
         line = br.readLine();    // ignore first row (i.e., headers)
         
         while ((line = br.readLine()) != null) {

            // use comma as separator
            String[] im = line.split(cvsSplitBy);

            if (do_debug)
                System.out.println("ID= " + Integer.parseInt(im[1]) + " , FID=" + im[0]);
            
            fid_lut.put(Integer.parseInt(im[1]), im[0]);
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

   // <editor-fold defaultstate="collapsed" desc="getLUT">
   /**
    * Method to return <ID, FID> pairs
    *
    * @return fid_lut
    */
   public HashMap getLUT() {
      return fid_lut;
   }// </editor-fold>
   
     
   // <editor-fold defaultstate="collapsed" desc="get">
   /**
    * @param index - index of FID to return
    *
    * @return type String (Face ID)
    */
   public String get(int index) {
      return fid_lut.get(index);
   }// </editor-fold>
   
   
}

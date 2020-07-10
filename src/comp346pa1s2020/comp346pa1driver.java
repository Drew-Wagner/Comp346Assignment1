/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp346pa1s2020;

/**
 *
 * @author Kerly Titus
 */

import java.io.*;

public class comp346pa1driver {

    /** normal
     * main class
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	 /*******************************************************************************************************************************************
    	  * TODO : implement all the operations of main class   																					*
    	  ******************************************************************************************************************************************/
        
    	Network objNetwork = new Network("network");              /* Activate the network */
        objNetwork.start();
        Server objServer = new Server();                                 /* Start the server */
        objServer.start();
        Client objClient1 = new Client("sending");              /* Start the sending client */
        objClient1.start();
        Client objClient2 = new Client("receiving");            /* Start the receiving client */
        objClient2.start();

        PrintWriter pw = null;

        try
        {
            pw = new PrintWriter("results");
        } catch(FileNotFoundException e){
            e.printStackTrace();
            System.exit(0);
        }

            try {
                objNetwork.join();
                objServer.join();
                objClient1.join();
                objClient2.join();
            } catch (Exception ex) {
                System.out.println(ex);
            }

            pw.close();
        // System.out.println("DONE!");
    }
}

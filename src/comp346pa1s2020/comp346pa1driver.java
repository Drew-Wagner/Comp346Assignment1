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
    	PrintStream o = null;
        try
        {
            o = new PrintStream(new File("results.txt"));
        } 
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
        System.setOut(o);
        
        for(int i = 0; i < 3; i++) {
        	System.out.println("\n ------------------------- Test " + (i + 1) + " -------------------------");
	    	Network objNetwork = new Network("network");              /* Activate the network */
	        objNetwork.start();
	        Server objServer = new Server();                                 /* Start the server */
	        objServer.start();
	        Client objClient1 = new Client("sending");              /* Start the sending client */
	        objClient1.start();
	        Client objClient2 = new Client("receiving");            /* Start the receiving client */
	        objClient2.start();
	
	        try 
	        {
	            objNetwork.join();
	            objServer.join();
	            objClient1.join();
	            objClient2.join();
	        } 
	        catch (Exception ex)
	        {
	            System.out.println(ex);
	        }
        }
        // Explanation for varying execution times.
        System.out.println("\n Since there are processes performing OS and user tasks at the same time as our Java"
        		+ " program, the OS does not always interleave the threads in the same way. The threads thus do"
        		+ " not always execute in the exact same order, nor yield for the same number of CPU cycles with"
        		+ " each test run.");
        o.close();
        // System.out.println("DONE!");
    }
}

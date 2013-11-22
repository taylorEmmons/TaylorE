package program4;

import java.io.File;
import java.util.ArrayList;

public class ProcessText {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// int count = 0;

	        if (args.length == 0) {
	            System.err.println();
	            System.err.println("Usage: java ReadFromFile <filename>");
	            System.err.println();
	            System.exit(1);
	        }
	        
	   /*     TextStatistics test = new TextStatistics(args[0]);
	        String values = ":;.!-'\"?/\\";
	        int[] puncts = test.getPunctuation(values);
	        
	        for(int i = 0; i < puncts.length; i++) {
	        	System.out.print("[" + values.charAt(i) + ": " + puncts[i] + "]");
	        }*/
	        
	        TextStatistics test = new TextStatistics(args[0]);
	        
	       test.getStats();
	       
	       System.out.print(test.toString());
	        
	      /* ArrayList<String> ftc = new ArrayList<String>();
	        
	       File directory = new File("res");
	       File[] listOfFiles = directory.listFiles();
	       
	       for(int i = 0; i < listOfFiles.length; i++) {
	    	   if(listOfFiles[i].isFile()) {
	    		  // System.out.println("File Name: " + listOfFiles[i].getName());
	    		   ftc.add("res/" + listOfFiles[i].getName());
	    	   }
	    	   if(listOfFiles[i].isDirectory()) {
	    		  // System.out.println("Directory: " + listOfFiles[i].getName());
	    		   File[] subDirectory = listOfFiles[i].listFiles();
	    		   for(int j = 0; j < subDirectory.length; j++) {
	    			  // System.out.println("		File Name: " + subDirectory[j].getName());
	    			   ftc.add("res/" + listOfFiles[i].getName() + "/" + subDirectory[j].getName());
	    		   }
	    		   
	    	   }
	       }
	       
	       for(int i = 0; i < ftc.size(); i++) {
	    	   
	    	   //TextStatistics stats = new TextStatistics(args[0]);
	    	  // System.out.println(ftc.get(i));
	    	   TextStatistics stats = new TextStatistics(ftc.get(i));
	    	   System.out.println(stats.toString());
	    	   System.gc();
	       }*/
		
	}

}























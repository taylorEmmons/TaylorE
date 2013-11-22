package program4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TextStatistics {

	private int numOfChars, numOfWords, numOfLines = 1;
	private float averageWordLength;
	private int[] letterCount;
	private File processFile;
	private String fileName;
	private String[] alphabet;
	private String lalphabet = "abcdefghijklmnopqrstuvwxyz";
	private String longestWord = "";
	private ArrayList<Integer> lineNums = new ArrayList<Integer>();
	
	public TextStatistics(String fileName) {
		this.fileName = fileName;
		this.processFile = new File(this.fileName);
			
	}
	
	public int[] getPunctuation(String puncts) {
			
		int[] counts = new int[puncts.length()];
		
		 try {
		        Scanner inFile = new Scanner(this.processFile);
		        while (inFile.hasNext()) 
		        {
		            String line = inFile.nextLine();
		            StringTokenizer tokenizer = new StringTokenizer(line, "");
		            while(tokenizer.hasMoreTokens()) {
		            	String token = tokenizer.nextToken().toLowerCase();
		            		for(int i = 0; i < puncts.length(); i++) {
		            			char c = puncts.charAt(i);
		            			for(int j = 0; j < token.length(); j++) {	
		            				char tokenC = token.charAt(j);
		            				if(c == tokenC) {
		            					counts[i]++;
		            				}
		            			}
		            		}
		            	}	
		            }
		    } catch (FileNotFoundException e) {
		        System.err.println();
		        System.err.println("ReadFromFile: File " + fileName + " does not exist.");
		        System.err.println();
	    }
		 
		 return counts;
		
	}
	
	public void getStats() {
		this.alphabet = lalphabet.split("");
		letterCount = new int[this.alphabet.length];
	
		    try {
		        Scanner inFile = new Scanner(this.processFile);
		        while (inFile.hasNext()) 
		        {
		            String line = inFile.nextLine();
		            StringTokenizer tokenizer = new StringTokenizer(line, " , .;:'\"&!?-_\n\t12345678910[]{}()@#$%/*^+-");
		            while(tokenizer.hasMoreTokens()) {
		            	String token = tokenizer.nextToken().toLowerCase();
		            	
		            		if(longestWord != "" && token.equals(longestWord)) {
		            			lineNums.add(this.numOfLines);
		            		}
		            		
		            		if(token.length() > longestWord.length()) {
		            			longestWord = token;
		            			lineNums.clear();
		            			lineNums.add(this.numOfLines);
		            		}
		            		
		            	
		            		String[] letters = token.split("");
		            		for(int i = 0; i < letters.length; i++) {
		            			for(int j = 0; j < alphabet.length; j++) {
		            				if(letters[i].equals(alphabet[j])) {
		            					letterCount[j]++;
		            				}
		            			}
		            			this.numOfChars++;
		            		}	
		            	this.numOfWords++;
		            }
		            this.numOfLines++;
		        }
		         
		         this.averageWordLength = this.numOfChars/this.numOfWords;
		         
		    } catch (FileNotFoundException e) {
		        System.err.println();
		        System.err.println("ReadFromFile: File " + fileName + " does not exist.");
		        System.err.println();
	    }
	}
	
	public int getNumOfChars() {
		return numOfChars;
	}
	
	public void setNumOfChars(int numOfChars) {
		this.numOfChars = numOfChars;
	}
	
	public int getNumOfWords() {
		return numOfWords;
	}
	
	public void setNumOfWords(int numOfWords) {
		this.numOfWords = numOfWords;
	}
	
	public int getNumOfLines() {
		return numOfLines;
	}
	
	public void setNumOfLines(int numOfLines) {
		this.numOfLines = numOfLines;
	}
	
	public float getAverageWordLength() {
		return averageWordLength;
	}
	
	public void setAverageWordLength(float averageWordLength) {
		this.averageWordLength = averageWordLength;
	}
	
	public int[] getLetterCount() {
		return letterCount;
	}
	
	public void setLetterCount(int[] letterCount) {
		this.letterCount = letterCount;
	}

	public String toString() {
		String alphaHolder = "\n";
		
		for(int i = 1; i < this.alphabet.length; i++) {
			alphaHolder = alphaHolder + this.alphabet[i] + ": " + this.letterCount[i] + "\n";
		}
		
		String linesHolder = "";
		
		for(int i = 0; i < this.lineNums.size(); i++) {
			linesHolder += this.lineNums.get(i) + " ";
		}
		
		String str = "Number Of Characters = " +	this.numOfChars
						+ " numOfWords = " + this.numOfWords
						+ " numOfLines = " + this.numOfLines
						+ " averageWordLength = " + this.averageWordLength
						+ " letterCount = [ " + alphaHolder + "]\n"
						+ " longestLetter = " + this.longestWord + "\n at line(s): " + linesHolder;
		
		//*******File Name**********\\
		//Number Of Lines: 
		//Number Of Words:
		//Number Of Characters:
		//Average Word Length:
		//**********Character Data****\\
		//    A/a:
		//		etc,
		//*********Word Specifics*******\\
		//	Longest Letter:
		//  Occurs on lines: 1, 4, 5
		
		
		return str;
	}
	
}

package funParser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class Decoder {
	
	public Decoder() {
		
	}
	
	public static File encode(String key, String fileName) {
		File file = new File(fileName);
		byte[] byteKey = key.getBytes();
		byte[] result;
		byte[] encFileData;
		ArrayList<byte[]> fileContents = new ArrayList<byte[]>();
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				byte[] ln = line.getBytes();
				result = new byte[ln.length];
				for(int i = 0; i < ln.length; i++) {
					result[i] = (byte)(ln[i] ^ byteKey[i%key.length()]);
				}
				fileContents.add(result);
			}
			
			System.out.println(fileContents.size());
			
			encFileData = new byte[fileContents.get(0)[0].length()];
			//encFileData = fileContents.toArray();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		File efile = new File("e" + fileName);
		
	        FileOutputStream is = null;
			try {
				is = new FileOutputStream(efile);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
	        OutputStreamWriter osw = new OutputStreamWriter(is);    
	        Writer w = new BufferedWriter(osw);
	        try {
				w.write(new String());
			} catch (IOException e) {

				e.printStackTrace();
			}
	        try {
				w.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		return efile;
	}
	
	public static File parseFile() {
		File file = null;
		
		return file;
	}
	
}

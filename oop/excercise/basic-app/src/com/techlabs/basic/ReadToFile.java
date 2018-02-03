package com.techlabs.basic;
import java.io.*;

public class ReadToFile {

	public void read(String filename) {
		BufferedReader br = null;
		try{	
			br = new BufferedReader(new FileReader("data/"+filename));
			String contentLine = br.readLine();
			while (contentLine != null) {
				System.out.println(contentLine);
				contentLine = br.readLine();
			}
		}
		catch (IOException ioe) 
		{
			System.out.println("Exception Occurred:" + ioe);;
		} 
		finally 
		{
			try {
				if (br != null)
					br.close();
			} 
			catch (IOException ioe) {
				System.out.println("Error closing BufferedReader");
			}
		}
	}
}


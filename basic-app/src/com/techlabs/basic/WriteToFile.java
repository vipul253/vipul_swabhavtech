package com.techlabs.basic;
import java.io.*;

public class WriteToFile {

	public void write(String content,String filename) {
		BufferedWriter bw = null;
		try {
			File file = new File(filename);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(content);
			System.out.println("File written Successfully");

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		finally
		{ 
			try{
				if(bw!=null)
					bw.close();
			}catch(Exception ex){
				System.out.println("Error in closing BufferedWriter" + ex);
			}
		}
	}
}

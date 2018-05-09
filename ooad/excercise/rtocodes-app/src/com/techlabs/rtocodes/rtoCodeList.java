package com.techlabs.rtocodes;

import java.io.*;
import java.util.*;

public class rtoCodeList {

	Properties prop = new Properties();
	Map<String,String> rtocodes,result;
	
	public rtoCodeList() {
		InputStream input = null;

		try {

			input = new FileInputStream("data/rtocodes.properties");

			// load a properties file
			prop.load(input);
			
			rtocodes = new HashMap<String,String>();
			for (Map.Entry<Object, Object> entry : prop.entrySet()) {
			    rtocodes.put((String) entry.getKey(), (String) entry.getValue());
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public Map<String,String> getRTOlist(){
		return this.rtocodes;
	}
	
	public Map<String,String> searchRTOCode(String search) {
		result = new HashMap<String,String>();
		for (Map.Entry<String, String> entry : rtocodes.entrySet()) {
			String s = entry.getKey();
			if (s.toLowerCase().contains(search.toLowerCase())) {
				result.put(s, entry.getValue());
			}
		}
		return result;
	}
}

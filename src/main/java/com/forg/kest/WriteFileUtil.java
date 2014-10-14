package com.forg.kest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class WriteFileUtil {

	public static boolean writeFile(String data, String filePath) {
		try {
			File f = new File(filePath);
			if (!f.exists()) {
				f.createNewFile();
			}

			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(data);
			bw.close();
		} catch (Exception e) {
			return false;
		}

		return true;
	}
	
	public static boolean writeFile(List<String> list, String filePath) {
		
		StringBuilder sb = new StringBuilder();

		for(String b : list)
			sb.append(b).append("\r\n");
		
		return writeFile(sb.toString(),filePath);
	}

}

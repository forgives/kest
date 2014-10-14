package com.forg.net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DownloadUtil {
	
	public static int MAX_BYTE = 1024 * 1024 * 10;
	
	public static boolean download(String url,String path){
		
		if(url==null || path==null || url.trim().length()==0 && path.trim().length()==0 ){
			return false;
		}
		
		
		try {
			URL ul = new URL(url);
			URLConnection uc = ul.openConnection();
			
			InputStream is = uc.getInputStream();
			String picName = url.substring(url.lastIndexOf("/")+1,url.length());
			
			SimpleDateFormat f = new SimpleDateFormat("yyyyMMDD");
			
			String filePath = path + f.format(new Date()) + "/" ;
			
			File dir = new File(filePath);
			if(!dir.exists()){
	            dir.mkdirs();
	        }
			
			FileOutputStream out = new FileOutputStream(filePath + picName);
			
//			long streamTotal = is.available();
//			int streamNum = 0 ;
//			int level = 0 ;
//			byte[] bts ; 
//			
//			if(streamTotal > MAX_BYTE){
//				streamNum = (int)Math.floor(streamTotal/MAX_BYTE);
//			}
//			level = (int)streamTotal % MAX_BYTE;
//			
//			if(streamNum > 0){
//				
//			}
//			
//			bts = new byte[level];
//			is.read(bts, 0, level);
			
			int i = 0;
	        while ((i = is.read()) != -1) {
	            out.write(i);
	        }
	        
	        is.close();
	        out.close();
	        
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
		System.out.println(url);
		
		return true;
	}

	public static void main(String[] args) {

	}

}

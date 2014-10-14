package com.forg.net;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupKest {

	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("http://www.dbmeizi.com/img/rank").get();
			Elements imgs = doc.getElementsByTag("img");
			
			for(Element e: imgs ){
				//System.out.println(e.attr("src"));
				DownloadUtil.download(e.attr("src"),"d:/downloadTest/");
				
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

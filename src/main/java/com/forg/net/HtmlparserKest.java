package com.forg.net;

//import org.htmlparser.NodeFilter;
//import org.htmlparser.Parser;
//import org.htmlparser.filters.TagNameFilter;
//import org.htmlparser.tags.ImageTag;
//import org.htmlparser.util.NodeList;
//import org.htmlparser.util.ParserException;

public class HtmlparserKest {

	String rank = "http://www.dbmeizi.com/img/rank";
	
	public static void main(String[] args) {
		HtmlparserKest kest = new HtmlparserKest();
		kest.mainKest();
	}

	
	public void mainKest(){
		
//		try{
//			Parser urlParser = new Parser(rank);
//			urlParser.setEncoding("GBK");
//			String filterType = "img";
//			NodeFilter nodeFilter = new TagNameFilter(filterType);
//			NodeList nodeList = urlParser.extractAllNodesThatMatch(nodeFilter);
//			
//			for(int i =0 ; i<nodeList.size() ; i++){
//				ImageTag imgtag = (ImageTag) nodeList.elementAt(i);
//				DownloadUtil.download(imgtag.getImageURL(), "d:\\downloadtest\\");
//			}
//			
//		} catch (ParserException e) {
//			e.printStackTrace();
//		}
	}
	
	
}

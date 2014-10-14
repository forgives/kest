package com.forg.net;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import com.forg.encryption.MD5;

public class SmsSendKest {
	
	public static String URL= "http://api.xxx.com/xxx";

	public static void main(String[] args) {
		
		SmsSendKest s = new SmsSendKest();
		try {
			s.sendSms("xxxx", "xxx", "xxx","xxx");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String sendSms(String username, String password, String phone,
			String content) throws Exception {

		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyMMddhhmm");
		String strDate = sf.format(date);
		MD5 m = new MD5();

		StringBuilder sb = new StringBuilder("");
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<MtPacket>");
		sb.append("<cpid>010001000332</cpid>");
		sb.append("<mid>0</mid>");
		sb.append("<cpmid>0</cpmid>");
		sb.append("<mobile>"+phone+"</mobile>");
		sb.append("<port>010150</port>");
		sb.append("<msg>"+content+"</msg>");
		sb.append("<msgtype>1</msgtype>");
		sb.append("<signature>"+m.getMD5ofStr("685417172375a6937af7096fa8366022"+strDate)+"</signature>");
		sb.append("<timestamp>"+strDate+"</timestamp>");
		sb.append("<validtime></validtime>");
		sb.append("</MtPacket>");
		
		return methodPost(URL,sb.toString());
	}
	
    public String methodPost(String url,String data){

        String response= "";//要返回的response信息
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(url);
        postMethod.setRequestEntity(new StringRequestEntity(data));
        try {
			postMethod.setRequestEntity(new StringRequestEntity(data, "text/html", "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

        // 执行postMethod
        int statusCode = 0;
        try {
            statusCode = httpClient.executeMethod(postMethod);
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY
                || statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
            // 从头中取出转向的地址
            Header locationHeader = postMethod.getResponseHeader("location");
            String location = null;
            if (locationHeader != null) {
                location = locationHeader.getValue();
                System.out.println("The page was redirected to:" + location);
                response= methodPost(location,data);
            } else {
                System.err.println("Location field value is null.");
            }
        } else {
            System.out.println(postMethod.getStatusLine());

            try {
                response= postMethod.getResponseBodyAsString();
                System.out.println("postMethod.getResponseBodyAsString():"+ response);
            } catch (IOException e) {
                e.printStackTrace();
            }
            postMethod.releaseConnection();
        }
        return response;
    }


}

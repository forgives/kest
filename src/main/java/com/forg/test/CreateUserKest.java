package com.forg.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.forg.kest.WriteFileUtil;

public class CreateUserKest {

	private static String INSERT_SQL = "INSERT INTO USERS (USER_ID,NICK_NAME,USER_PWD,MAIL_ADDRESS, TYPE_ID,USER_HEAD_FILE_ID,VALID_FLG) VALUES  (  'kanlianhui', 'kanlianhui', MD5('123456'), '51jiecai@51jiecai.com', '01', '314','0') ;";
	private static long num = 95800000000L;

	public static void main(String[] args) {

		CreateUserKest k = new CreateUserKest();
		List<String> l = new ArrayList<String>();

		for (int i = 1; i <= 3500; i++) {
			String n = ++ k.num + "";

			l.add(INSERT_SQL.replaceAll("kanlianhui", n));
		}
		try {
			WriteFileUtil.writeFile(l,"D:\\1234.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

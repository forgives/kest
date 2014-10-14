package com.forg.test;

public class StringOut {

	public static void main(String[] args) {
		StringBuilder wSql = new StringBuilder();
		wSql.append("SELECT UU.FILE_URL, T.LINK_URL ,T.ADVERTISING_ID");
		wSql.append("  FROM ADVERTISING T ");
		wSql.append("  LEFT JOIN USERS_UPFILES UU ON T.ADVERTISING_IMG = UU.FILE_ID ");
		wSql.append(" WHERE T.ADVERTISING_VALID_FLG = '1' ");
		wSql.append(" ORDER BY T.ADVERTISING_SORT ");
		System.out.println(wSql.toString());
	}

}
